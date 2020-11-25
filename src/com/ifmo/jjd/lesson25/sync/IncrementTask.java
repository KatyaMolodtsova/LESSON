package com.ifmo.jjd.lesson25.sync;

public class IncrementTask extends Thread{
    private final SomeAccount account;

    public IncrementTask(SomeAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // есть синхронизированные методы и синхронизированный блок
        // используется либо то, либо другое

        // синхронизированный блок, на объект переданный в ()
        //synchronized (account) { // монитор захвачен
            // кладется то, что нужно выполнить последовательно
            // выносить за этот блок то, что не касается объекта, тк объект будет заблокирован
            account.upBalance(10);
        //} // монитор разблокмрован

        // у каждого объекта есть так назывемый монитор
        // obj - monitor lock / unlock
        // монитор может быть либо заблокирован каким-то потоком, либо разблокирован
        // в одну единицу времени только один поток может заблокировать монитор объекта
        // если какой-то поток заблокировал монитор объекта, то другие потоки не могут работать с этим объектом
        // может быть несколько синхронизированных блоков
    }
}
