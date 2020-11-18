package com.ifmo.jjd.lesson19;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Field;

/**
 * класс IOLesson
 * @author
 * @version
 */
public class IOLesson {
    /**
     * поле data - описание
     */
    private String data;

    /**
     * конструктор
     * @param data
     * @see IOLesson#IOLesson(String)  указание на другое место в документации
     */
    public IOLesson(String data) {
        this.data = data;
    }

    public static void main(String[] args) {
        // пакеты IO / NIO
        // IO передача данных в прогамму и из программы, либо последовательность byte, либо последовательность char

        // класс File
        File file = new File("somefile.txt");

        try {
            file.createNewFile(); // создание файла
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        System.out.println(file.exists()); // существует или нет файл, возврат true или false
        System.out.println(file.isDirectory()); // это директория?
        System.out.println(file.isFile()); // это файл?
        System.out.println(file.canRead()); // доступен ли для чтения
        System.out.println(file.canWrite()); // доступен ли для записи
        System.out.println(file.canExecute()); // исполняемый ли файл или нет

        // список файлов в директории
        File[] files = new File("sources").listFiles();

        File lessonFile = new File("sources/lesson19.txt");
        // если пишем в несуществующий файл, то он будет создан,
        // либо в корень проекта, либо по тому пути, который будет указан
        // 1. если программа передает данные, используем наследников OutputStream
        // 2. если программа получает данные, используем наследников InputStream

        try {
            writeToFile(lessonFile, "строка для записи", false);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }

    /**
     * метод записи в файл
     * @param file файл для записи
     * @param data строка для записи
     * @param append флаг
     *               если значение true, запись в конец файла
     *               если значение false, запись в начало файла
     * @throws IOException файл не найден (не удалось создать файл), проблема во время записи
     */
    private static void writeToFile(File file, String data, boolean append) throws IOException {
        // try-with-sources
        // когда выполнение блока try завершится (с исключением или без него) у объектов, созданных в () будет
        // автоматически вызван метод close()
        // для создания объектов внутри () необходима имплементация интерфейса AutoCloseable
        // и реализация метода close()
        // если в try - IOException, то закрытие ресурсов будет происходить немедленно
        // если нет, то в finally, но не в блоке catch
        try(FileOutputStream outputStream = new FileOutputStream(file, append)){
            byte[] bytes = data.getBytes(); // преобразование строки в массив byte
            outputStream.write(bytes); // пишет либо byte, либо массив byte, либо указанную длину из массива byte
        }
    }

    // программа -> файл
    // программа -> буфер (накопил) -> файл

    private static void writeWithBuffer(File file) throws IOException {
        // по умолчанию флаг - false, пишет в начало
        try(FileOutputStream outputStream = new FileOutputStream(file);
            BufferedOutputStream buffer = new BufferedOutputStream(outputStream)){
            // принято писать BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(file))
            // BufferedOutputStream является декоратором по отношению к FileOutputStream
            for (int i = 0; i < 100_000; i++) {
                buffer.write((i + " ").getBytes());
            }
        }

        // при написании собственных декораторов io классы декораторы должны наследоваться
        // от FileOutputStream FileInputStream

        //SomeIODecorator someIODecorator = new SomeIODecorator(new BufferedOutputStream(new FileOutputStream(file)));
        //someIODecorator.write("dds".getBytes());
    }

    /**
     * Метод чтения из файла
     * @param file файл, содержимое которого нужно прочитать
     * @return строка, прочитанная из файла
     * @throws IOException файл не найден, проблема во время чтения
     */
    private static String readFromFile(File file) throws IOException{
        String res = null;
        try(FileInputStream fileInputStream = new FileInputStream(file);
            // BufferedInputStream buffer = new BufferedInputStream(fileInputStream);
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream()){

            byte[] bytes = new byte[300]; // собирает прочитанные данные в массив
            int data;
            // read возвращает количество прочитанных байт или -1, если нечего читать
            while ((data = fileInputStream.read(bytes)) != -1){
                byteArray.write(bytes, 0, data);
            }
            res = new String(byteArray.toByteArray());
        }
        return res;
    }

    /**
     * Массив с байтами собираем в изображение
     * @param file изображение
     * @param bytes массив байт
     * @return
     * @throws IOException
     */
    // img -> byte[] ---передача--- byte[] -> img
    public static boolean byteArrayToImg(File file, byte[] bytes) throws IOException{
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        BufferedImage image = ImageIO.read(inputStream); // прочитали
        return ImageIO.write(image, "jpg", file); // из image в file с расширением jpg
    }

    /**
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static byte[] imgToByteArray(File file) throws IOException{
        BufferedImage image = ImageIO.read(file); // из файла сюда
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); // из буфера сюда
        ImageIO.write(image, "jpg", outputStream);
        return outputStream.toByteArray();
    }


    class SomeIODecorator extends FilterOutputStream {

        public SomeIODecorator(OutputStream out){
            super(out);
        }

        @Override
        public void write(byte[] b) throws IOException {
            // шифрование xor ^
            out.write(b);
        }
    }

    class SomeInputDecorator extends FilterInputStream{

        protected SomeInputDecorator(InputStream in){
            super(in);
        }

        @Override
        public int read(byte[] b) throws IOException {
            // read вернет количество прочитанных байт
            // b перебор, декодирование, возврат
            for (int i = 0; i < b.length; i++) {
                b[i] = 54; // Расшифрованные байты
            }
            return in.read(b); // количество прочитанных байт
        }

    }
}

