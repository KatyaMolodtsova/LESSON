package com.ifmo.jjd.lesson25.sync;

public class SomeAccount {
    private int balance;

    public int getBalance(){
        return balance;
    }

    // синхронизированный метод, слово synchronized
    // пока метод выполняется, монитор объекта будет заблокирован
    // может быть несколько синхронизированных методов
    public synchronized void upBalance(int count){
        balance += count;
    }
}
