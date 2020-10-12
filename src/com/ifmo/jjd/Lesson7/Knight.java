package com.ifmo.jjd.Lesson7;

public class Knight extends BattleUnit {

    private final int additionalAttack = 2;

    public Knight(int healthPoints, int agilityPoints, int attackPoints) {
        super(healthPoints, agilityPoints, attackPoints);
    }


    @Override
    public void attack(BattleUnit unit) {
        if (this.isAlive() && unit.isAlive() && unit.agilityPoints <= this.agilityPoints)
            unit.minusHealth(this.attackPoints + additionalAttack);
        if (unit.isAlive() && unit.agilityPoints >= this.agilityPoints)
            this.minusHealth(unit.attackPoints);
    }

    @Override
    public void rest() {
        this.plusHealth(3);
    }
}

// наследование
// конструкторы
// общий тип данных
// интерфейсы