package com.ifmo.jjd.lesson25.task;

import com.ifmo.jjd.lesson25.sync.IncrementTask;
import com.ifmo.jjd.lesson25.sync.SomeAccount;
import com.ifmo.jjd.lesson25.waitnotify.GetThread;
import com.ifmo.jjd.lesson25.waitnotify.Library;
import com.ifmo.jjd.lesson25.waitnotify.PutThread;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        SomeAccount account = new SomeAccount();

        // несколько потоков пытаются изменить значение его свойств
        ArrayList<IncrementTask> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(new IncrementTask(account));
        }
        for (IncrementTask task : tasks) {
            task.start();
        }

        for (IncrementTask task : tasks) {
            try {
                task.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Library library = new Library();
        new Thread(new PutThread(library)).start();
        new Thread(new PutThread(library)).start();
        new Thread(new GetThread(library)).start();
    }
}
