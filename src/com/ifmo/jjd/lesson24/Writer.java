package com.ifmo.jjd.lesson24;

import com.ifmo.jjd.lesson22.Course;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.CopyOnWriteArrayList;

public class Writer extends Thread{
    private CopyOnWriteArrayList<Course> courses;
    private BufferedReader reader;

    public Writer(CopyOnWriteArrayList<Course> courses) {
        this.courses = courses;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    // нельзя путать с методом start, метод start переопределять нельзя
    // когда планировщик запустит поток, инструкции метода run начнут выполняться
    @Override // в методе run описываются иснтрукции потока, метод вызывается при запуске потока (RUNNING)
    public void run() {
        while (true){
            try {
                //Thread.currentThread() - ссылка на текущий поток
                // getName() - возвращает имя потока
                System.out.println("Введите название курса");
                String name = reader.readLine();
                System.out.println("Введите продолжительность курса");
                int duration = Integer.parseInt(reader.readLine());
                System.out.println("Введите стоимость курса");
                int price = Integer.parseInt(reader.readLine());

                // добавит объект, переданный в конец списка, если элемент отстутствует
                // проверка по equals. если объект есть, то вернет false
                if (courses.addIfAbsent(new Course(name, duration, price))){
                    System.out.println("Курс успешно добавлен");
                } else {
                    System.out.println("Курс не был добавлен");
                }

                // если в потоке возникнет необработанное исключение, то поток завершит свою работу
                // программа продолжит свою работу, остальные потоки тоже
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
