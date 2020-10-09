package com.ifmo.jjd.Lesson7;

public interface AttackAble {
    // метод без реализации
    void attack(BattleUnit unit);
    // метод с реализацией
    default void run(){
        System.out.println("run AttackAble");
    }
}
