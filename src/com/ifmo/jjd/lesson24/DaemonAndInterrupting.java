package com.ifmo.jjd.lesson24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DaemonAndInterrupting {
    public static void main(String[] args) {
        // Daemon (фоновые) потоки
        // завершают свою работу, когда завершаются все основные потоки
        Thread daemon = new Thread(()->{
            while (true){
                try {
                    Thread.sleep(5000);
                    Files.write(Paths.get("sources/lesson24.txt"),
                            "Daemon поток...".getBytes(), StandardOpenOption.APPEND);
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        });
        // фоновый поток
        daemon.setDaemon(true);
        daemon.start();

//        try {
//            daemon.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // прерывание потоков
        // поток остановится, если:
        // 1. выполнил свои инструкции
        // 2. было выброшено необработанное исключение
        // 3. остановилась JVM
        // 4. если поток был daemon потоком и все не daemon потоки завершили свою работу

        Thread actions = new Thread(()->{
            // пока поток не прерван
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("Some actions..");
                try {
                    Thread.sleep(1000);
                    // при перехвате InterruptedException статус сбрасывается, необходимо установить заново
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        actions.start();

        // поток засывает, мы пытаемся его изменить
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // меняет true на false и наоборот
        actions.interrupt();
    }
}
