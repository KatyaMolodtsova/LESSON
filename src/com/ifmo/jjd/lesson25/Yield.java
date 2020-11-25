package com.ifmo.jjd.lesson25;

public class Yield {
    public static void main(String[] args) {

        Runnable task = () -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread());
                // не гарантированный метод
                // предлагает планировщику передать управление другому потоку, освободить процессор,
                // чтобы начал выплняться другой поток. yield не указывает, какой поток нужно запустить
                // планировщик может проигнорировать этот метод
                Thread.yield();
            }
        };

        new Thread(task).start();
        new Thread(task).start();

        // основной поток
        // читает из файла
        // разбивает на несколько частей
        // каждый поток получает свою часть
        // считает количество слов
        // переносит результат в общую мапу
        // выводит топ n слов

        // количество потоков должно быть равно Runtime.getRuntime().availableProcessors()
    }
}

