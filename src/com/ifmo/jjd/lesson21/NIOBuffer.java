package com.ifmo.jjd.lesson21;

import java.io.InputStream;
import java.nio.*;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NIOBuffer {
    public static void main(String[] args) {

        // пакет noi (new io / non-blocking io) предназначен для работы с вводом и выводом
        // * неблокирующий
        // * асинхронный
        // * буфер-ориентированный

        // Path (аналог класс File)
        // Files (статические методы: чтение, запись, копирование и тд)
        // Channel, Buffer, селекторы (набор классов)

        // данные идут по каналам
        // каналы (аналог InputStream и OutputStream)
        // можно использовать для записи и для чтения
        // события в канале могут происходить ассинхронно (с одной стороны запись, с другой чтение)
        // не будут блокировать друг друга, не параллельно
        // каналы всегда читают и пишут в буфер
        // управление буфер происходит вручную

        // каналы
        // FileChannel - для работы с файлами
        // SocketChannel - для соединения с сервером, клиентский сокет, передает данные по TCP протоколу
        // DatagramChannel - для соединения с сервером, клиентский сокет, передает данные по UDP протоколу
        // ServerSocketChannel - используется на сервере, ждет входящих подключений

        // буферы
        // ByteBuffer - в основном используется
        // CharBuffer
        // DoubleBuffer / FloatBuffer
        // ShortBuffer / IntBuffer / LongBuffer

        // свойства буферов
        // capacity - емкость, задается при создании объекта и не меняется
        // position - текущая позиция в буфере (изначально равна 0), меняется по мере добавления данных
        // limit - указатель, до какого значения можно читать / писать данные (изначально равен capacity)
        // сколько нужно прочитать или записать, не будет больше емкости

        // если читаем из буфера, то лимит перемещаем к позиции, чтобы читались только актуальные данные
        // после этого позицию перемещаем на 0
        // при записи - позиция на 0, лимит на уровне емкости
        // при чтении - лимит к позиции, позицию к 0

        // assert используются только при разработке, чтобы они работали, их нужно включить
        // утверждение, если верно, то assert его пропустит
        // утверждение, если не верно, то программа упадет с ошибкой
        // Edit Configuration -> VM Options: -ea
        // assert небольшие проверки кода
        // их не должно быть, если программа идет на выпуск

        ByteBuffer buffer = ByteBuffer.allocate(16); // создаем ByteBuffer и устанавливаем емкость 16
        assert buffer.position() == 0; // возвращает позицию
        assert buffer.capacity() == 16; // возвращает емкость
        assert buffer.limit() == 16; // возвращает значение лимита
        assert buffer.remaining() == 16; // возвращает разницу между position и limit

        //  put - записываем данные в буфер
        // каждый вызов метода put будет изменять позицию
        // Увеличивает позицию на 4.
        // int - 4 байта
        buffer.putInt(100);

        assert buffer.position() == 4;
        assert buffer.remaining() == 12;

        // Увеличивает позицию на 8.
        buffer.putDouble(100.25);

        assert buffer.position() == 12;
        assert buffer.remaining() == 4;

        // подготавливаем буфер для чтения
        // Устанавливает лимит на место позиции, сбрасывает позицию в 0 (для чтения из буфера)
        buffer.flip();

        assert buffer.position() == 0;
        assert buffer.limit() == 12;
        assert buffer.remaining() == 12;

        // считывает на 4 байта
        // Увеличивает позицию на 4.
        int anInt = buffer.getInt();

        assert buffer.position() == 4;
        assert buffer.remaining() == 8;

        // считывает на 8 байт
        // Увеличивает позицию на 8.
        double aDouble = buffer.getDouble();

        assert buffer.position() == 12;
        assert buffer.remaining() == 0;

        // используется, если нужно повторное чтение / записи
        // Сбрасывает позицию в 0 (limit остается на прежнем месте - для повторного чтения)
        buffer.rewind();

        assert buffer.position() == 0;
        assert buffer.limit() == 12;
        assert buffer.remaining() == 12;

        // Увеличивает позицию на 4.
        assert anInt == buffer.getInt();
        // Увеличивает позицию на 8.
        assert aDouble == buffer.getDouble();

        // подготовка буфера для последующей записи
        // не очищает данные в буфере
        // Сбрасывает позицию в 0, ставит лимит, равный емкости буфера (для записи в буфер)
        buffer.clear();

        assert buffer.position() == 0;
        assert buffer.capacity() == 16;
        assert buffer.limit() == 16;
        assert buffer.remaining() == 16;

        // если вызываем position(), то возвращает
        // если вызываем position() с параметрами, то устанавливает
        //buffer.position();

        // копирует все непрочитанные данные в начало буфера, установит лимит равной емкости
        // буфер может быть использован для дозаписи данных
        // buffer.compact();

    }
}