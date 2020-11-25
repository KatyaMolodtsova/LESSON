package com.ifmo.jjd.lesson24;

import com.ifmo.jjd.lesson22.Course;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Reader implements Runnable{
    private CopyOnWriteArrayList<Course> courses;

    public Reader(CopyOnWriteArrayList<Course> courses){
        this.courses = courses;
    }

    @Override
    public void run() {
        // lesson24.txt

        while (true){
            Course course = courses.stream()
                    .min(Comparator.comparing(Course::getDuration))
                    .orElse(Course.getInstance());
            String forFile = Thread.currentThread().getName() + ": " + course + "\n";
            try {
                // Записываем в файлик
                Files.write(Paths.get("sources/lesson24.txt"), forFile.getBytes(), StandardOpenOption.APPEND);
                // удаляем из коллекции
                courses.remove(course);

                // метод sleep
                // переводит поток в состояние ожидания на указанное количество миллисекунд
                // после будет передано планировщику потоков
                // может привести к эксепшену InterruptedException
                Thread.sleep(5000);
            } catch (IOException | InterruptedException ioException) {
                ioException.printStackTrace();
            }
        }

    }
}
