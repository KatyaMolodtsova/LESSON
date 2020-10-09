package com.ifmo.jjd.Lesson7;

public class Infantry extends BattleUnit{

    public Infantry(int healthPoints, int agilityPoints, int attackPoints) {
        super(healthPoints, agilityPoints, attackPoints);
    }

    // реализация метода attack(BattleUnit unit) интерфейса AttackAble
    @Override
    public void attack(BattleUnit unit) {
        // 1 если this жив и ловкость unit меньше this
        // unit.health -= this.attack
        // 2 если unit выжил и его ловкость больше this
        // this.health -= unit.attack

        if (this.isAlive() && unit.isAlive() && unit.agilityPoints <= this.agilityPoints)
            unit.minusHealth(this.attackPoints);
        if (unit.isAlive() && unit.agilityPoints >= this.agilityPoints)
            this.minusHealth(unit.attackPoints);
    }

    // реализация метода rest() интерфейса RestAble
    @Override
    public void rest() {
        this.plusHealth(2);
    }
}
