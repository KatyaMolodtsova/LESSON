package com.ifmo.jjd.lesson20.socketio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// AutoCloseable + close() позволит создать объекты в try-with-sources блоке
public class Connection implements AutoCloseable{

    // объект типа Socket позволит клиенту установить соединение с сервером
    // а серсеру принять клиента
    private Socket socket; // соединение
    private ObjectInputStream input;
    private ObjectOutputStream output;

    // client ====== server

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        // сначала получаем, потом отправляем
        output = new ObjectOutputStream(this.socket.getOutputStream()); // передача из сокета
        input = new ObjectInputStream(this.socket.getInputStream()); // получение из сокета
    }

    public void sendMessage(SimpleMessage message) throws IOException {
        message.setDateTime();
        output.writeObject(message); // преобразование в байт, вызов getOutputStream, отправлен по сети
        output.flush(); // насильно отдали, чтобы байты ушли в канал
    }

    public SimpleMessage readMessage() throws IOException, ClassNotFoundException {
        return (SimpleMessage) input.readObject();
    }


    @Override // будет вызван автоматически после завершения try блока,
    // если объект Connection был создан в () try
    public void close() throws Exception {
        input.close();
        output.close();
        socket.close();
    }
}
