package com.ifmo.jjd.lesson24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.CopyOnWriteArrayList;

public class JoinThreads {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> results = new CopyOnWriteArrayList<>();

        Thread task1 = new Thread(()->{
            // получаем число из консоли
            System.out.println("Введите число");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                // добавляем в результат
                results.add(Integer.parseInt(reader.readLine()));
            } catch (IOException | NumberFormatException ioException) {
                ioException.printStackTrace();
            }
        });
        Thread task2 = new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task2 обработал данные");
            results.add(100);
        });
        Thread task3 = new Thread(()->{
            try {
                Thread.sleep(000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task3 обработал данные");
            results.add(9000);
        });

        task1.start();
        task2.start();
        task3.start();

        // нам необходимо, чтобы поток (в данном случае основной)
        // ждал завершения работы других потоков (task1 / task2 / task3)

        // join - вызывающий поток (в данном случае основной) ожидает, когда указанные потоки
        // (task1 / task2 / task3) присоединятся к нему

        try {
            // основной поток ждет поток task1 10000 милисекунд, пока task1 присоедениться (завершит свою работу),
            // если не дождется, перейдет к следующему
            task1.join(10000);
            // основной поток ждет поток task1 до бесконечности, если не дождется, перейдет к следующему
            task2.join();
            task3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "получил результаты: " + results);
    }
}
