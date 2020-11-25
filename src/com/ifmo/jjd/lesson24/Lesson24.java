package com.ifmo.jjd.lesson24;

import com.ifmo.jjd.lesson22.Course;

import javax.sound.midi.Patch;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CopyOnWriteArrayList;

public class Lesson24 {
    public static void main(String[] args) {
        // старт программы -> создание процесса в ОС -> создание основного потока
        // после создания основного потока можно запускать дополнительные потоки
        // (инструкции будут выполняться параллельно в рамках одной программы, в рамках одного процесса)
        // все сервер, либо все клиент

        // одно ядро процессора может обрабатывать в одну единицу времени только один поток
        // переключение между потоками, псевдопараллелизм. быстрее, чем последовательное выполнение инструкций

        // многопоточность используется в графических интерфейсках или получают/обрабатывают/отправляют данные

        // у каждого потока есть свой жизненный цикл
        // 1. NEW - поток создан (создание объекта класса Thread, инструкции не выполняются)

        // за управление потоками отвечает 'планировщику потоков jmv'
        // есть очередь потоков, распределяет сам

        // 2. RUNNABLE - вызов метода start() у объекта Thread, далее поток переается на
        // 'планировщику потоков jmv' (Thread Scheduler). когда его запускать, решает 'планировщику потоков jmv'
        // 3. RUNNING - поток запущен и начинает выполнять инструкции. время запуска потока определяет 'планировщику потоков jmv'
        // 4. NON-RUNNING (TIME WAITING, WAITING, BLOCKED) - поток может находиться в состоянии ожидания
        // 5. TERMINATED - поток завершает работу - случилось исключение или все сделал

        // нет метода остановки потока
        // !!! поток запускает планировщик, а остановиться он должен после того, как выполнены все инструкции

        // вариант создать поток - только один, создать экземпляр класса Thread
        // передача потока планировщику - вызов метода start() у объекта Thread

        // варианты описания инструкций
        // #1. создать класс, который наследуется от класса Thread, инструкции, которые должен выполнять поток
        // описываются в методе public void run()
        // #2. инструкции, которые должен выполнять поток описываются в методе public void run()
        // интерфейса Runnable (при этом наборе инструкций можно описать в лямбда или создать отдельный класс)
        // #3. воспользоваться возможностями пакета java.util.concurrent.* - пакет для многопоточности

        CopyOnWriteArrayList<Course> courses = new CopyOnWriteArrayList<>();

        // #1. создание потока
        Thread writer = new Writer(courses);
        // имя присваивать не обязательно, оно в любом случае будет присвоино по умолчанию
        writer.setName("WRITER");

        // передаем поток планировщику
        writer.start();

        // #2.1. создание потока
        // сначала создается объект Thread, а потом создаем объект Runnable
        Thread reader = new Thread(new Reader(courses));
        reader.start();

        // программа завершится, когда завершатся все потоки
        // основной поток завершится, когда выполнит все свои инструкции
        // writer -> courses -> reader

        // #2.2. создание потока (лямбда)
        // реализация метода run интерфейса Runnable
        Thread simpleTask = new Thread(()->{
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println(Thread.currentThread().getName() + " прочитал курсы "
                        + Files.readAllLines(Paths.get("sources/lesson24.txt")));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        // потоков несколько, консоль одна
        // нельзя проследить за работой потоков через консоль. следить за потоками не нужно
        simpleTask.setName("SIMPLE_TASK");
        simpleTask.start();

        // приоритет потоков от 1 до 10, 10 - максимум
        // рекомендательный характер, планировщик может согласиться, а может не согласиться
        Thread readerOne = new Thread(new Reader(courses)); // Thread-3
        Thread readerTwo = new Thread(new Reader(courses)); // Thread-4
        Thread readerThree = new Thread(new Reader(courses)); // Thread-5

        // по умолчанию у всех приоритет 5
        readerOne.setPriority(Thread.MAX_PRIORITY);
        readerTwo.setPriority(Thread.MIN_PRIORITY);
        readerThree.setPriority(7);

        readerOne.start();
        readerTwo.start();
        readerThree.start();

        // группа потоков - есть свое имя, может быть макс и мин приоритет, могут выполнять определенные задачи
    }
}
