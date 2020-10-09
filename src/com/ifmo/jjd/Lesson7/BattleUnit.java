package com.ifmo.jjd.Lesson7;

// класс BattleUnit наследует от класса Unit
// класс BattleUnit - дочерний класс
// класс Unit - родительский класс
// дочерний класс получает доступ ко всем доступным свойстам и методам родительского класса

abstract public class BattleUnit extends Unit implements AttackAble{
    protected int attackPoints;


    public BattleUnit(int healthPoints, int agilityPoints, int attackPoints) {
        super(healthPoints, agilityPoints); // super обращение к конструктору родителя
        if (attackPoints <= 0)
            throw new IllegalArgumentException("attackPoints <= 0");
        this.attackPoints = attackPoints;
    }

    // класс BattleUnit реализует (имплементирует) интерфейс RestAble и AttackAble, в которых есть методы run
    // с реализацией. В такой ситуации мы обязаны явно указать, какой метод выбрать
    @Override
    public void run() {
        System.out.println("Реализация run BattleUnit");
    }
}
