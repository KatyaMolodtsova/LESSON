package com.ifmo.jjd.lesson18;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TstProperties {
    public static void main(String[] args) {
        // Properties основан на hash таблице и используется в основном для хранения настроек приложения
        // данные хранятся в парах: ключ - значение, при этом ключ - строка, значение - строка

        //
        // файл config.properties
        Properties properties = new Properties();
        properties.setProperty("someKey", "value"); // принимает ключ и значение
        System.out.println(properties.getProperty("someKey"));
        System.out.println(properties.getOrDefault("key", "default"));

        try (InputStream input = TstProperties.class.getClassLoader() // чтение файла
                .getResourceAsStream("config.properties")) {
            properties.load(input); // загружаем информацию из файла
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
