package com.ifmo.jjd.lesson25.sync;

public class SyncProblem {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();

        // пример вложенной синхронизации
        Thread thread1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "запущен");
            synchronized (object1){
                try {
                    System.out.println("thread1 -> object1");
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2){
                    System.out.println("thread1 -> object1 и object2");
                }
            }
        });

        Thread thread2 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "запущен");
            synchronized (object1){
                try {
                    System.out.println("thread2 -> object2");
                    // если sleep не будет, тогда мы не увидим проблему
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2){
                    System.out.println("thread2 -> object1 и object2");
                }
            }
        });

        // thread1 -> object1 | thread2 -> object2
        // чтобы избежать взаимной блокировки, необходимо установить одинаковую очередность
        thread1.start();
        thread2.start();

    }
}
