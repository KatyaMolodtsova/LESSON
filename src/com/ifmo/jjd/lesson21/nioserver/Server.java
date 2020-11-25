package com.ifmo.jjd.lesson21.nioserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    public void start(){
        // запускаем один поток для обработки всех соединений
        new Thread(new NioThread()).start();
    }

    // ассинхронная (не параллельная) работа с клиентами
    // в одном потоке работает с несколькими клиентами
    // client1 | client2 | client3
    private class NioThread extends Worker{
        private static final int BUF_SIZE = 1024;

        private ByteBuffer byteBuffer;
        private ServerSocketChannel serverChannel; // нужен, чтобы ждать клиента
        private Selector selector; // прыжки от одного клиента к другому

        // для каждого клиента создается отдельный канал
        // каждый канал регистрируется в селекторе, чтобы селектор следил за событиями в канале

        @Override
        protected void init() throws IOException {
            // создание буфера
            byteBuffer = ByteBuffer.allocate(BUF_SIZE);

            // создание селектора
            selector = Selector.open();

            // открытие канала сервера
            serverChannel = ServerSocketChannel.open();
            // ждем входящих подключений на порту 8090
            serverChannel.bind(new InetSocketAddress(8090));
            // перевод в неблокирующий режим
            serverChannel.configureBlocking(false);
            // регистрация канала в селекторе, селектор подписывается на события в канале
            // для serverChannel - OP_ACCEPT -  все события определены битовыми масками
            serverChannel.register(selector, serverChannel.validOps()); // реагирует на все события в канале
            // ServerSocketChannel ждет подключений

            // новый клиент - событие OP_ACCEPT в канале
            // когда оно наступает, селектор переключает внимание на данный канал и сервер принимает клиента
        }

        // этот блок выполняется в бесконечном цикле
        @Override
        protected void loop() throws IOException {
            // селектор ждет новых событий во всех каналах, на которые подписан
            selector.select();

            // ServerSocketChannel -> OP_ACCEPT
            // SocketChannel -> клиент постучался, восстанавливаем с ним связь
            // OP_CONNECT - клиент подключился
            // OP_READ - в канал пришли данные
            // OP_WRITE - в канал нужно передать данные

            // с селектора собираем информацию по всем событиям
            // получить ключи на события
            // ключ содержит информацию и в каком канале оно произошло
            Set<SelectionKey> keys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = keys.iterator();

            // какое событие первым наступило, то первым и будет обработано
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();

                // обращение к ключу
                // если у ключа isAcceptable возвращает true, то 100% пришло входящее подключение
                if (key.isAcceptable()){
                    // устанавливаем связь
                    SocketChannel channel = serverChannel.accept();
                    // переводим в неблокирующий режим
                    channel.configureBlocking(false);
                    // селектор должен реагировать только на события чтения
                    // регистрируем канал только на событие чтение
                    channel.register(selector, SelectionKey.OP_READ);
                    System.out.println("Client connected " + channel.getRemoteAddress());
                    // если это событие чтения
                } else if (key.isReadable()) {
                    System.out.println("читаем входящие данные...");
                    // читаем входящие данные
                    readData((SocketChannel)key.channel());
                } else if (key.isValid() && key.isWritable()){
                    System.out.println("запись данных в канал...");
                    // событие в канале, может быть от клиента, может быть от сервера
                    // если с ключом все нормально, то записываем данные
                    writeData((SocketChannel)key.channel(), key);
                }
                // событие удаляем
                iterator.remove();
            }

        }

        @Override
        protected void stop() throws IOException {
            serverChannel.close();
            selector.close();
        }

        private void readData(SocketChannel channel){
            // обратились к буферу
            byteBuffer.clear();

            try {
                // обращаемся к каналу и из канала читаем в буфер
                // клиент прислал значение серверу
                int read = channel.read(byteBuffer);
                if(read != -1) {
                    // передали массив байт, начиная с 0 по значение позиции
                    // получили строчку
                    System.out.println(new String(byteBuffer.array(), 0, byteBuffer.position(), StandardCharsets.UTF_8));
                } else {
                    // клиент отвалился
                    System.out.println("client disconnected " + channel.getRemoteAddress());
                    channel.close();
                }

                // подготовили буфер для чтения
                // лимит на позицию, позицию в 0
                byteBuffer.flip();

                // все зависит от того, что нужно сделать дальше
                // этот вариант может быть другой
                // в этом варианте отправка всем клиентам
                // берем все ключи
                Set<SelectionKey> keys = selector.keys();
                for (SelectionKey key: keys){
                    // среди доступных событий может происходить событие записи
                    // возможные события channel().validOps()
                    // события на данный момент key.interestOps()
                    if ((key.channel().validOps() & SelectionKey.OP_WRITE) > 0){
                        // если в канал можно писать, то в список событий
                        // добавляем событие, записи не происходит
                        key.interestOps(key.interestOps() | SelectionKey.OP_WRITE);
                    }
                }

            } catch (IOException e) {
                System.out.println("client disconnected ");
                byteBuffer.clear();
                try {
                    channel.close();
                } catch (IOException e1) {
//                    e1.printStackTrace();
                }
            }
        }

        private void writeData(SocketChannel channel, SelectionKey key) throws IOException {
            // записываем данные из буфера и записываем в канал
            channel.write(byteBuffer);
            byteBuffer.rewind();
            // по данному ключу убираем событие записи
            key.interestOps(key.interestOps() & ~SelectionKey.OP_WRITE);
        }
    }
}