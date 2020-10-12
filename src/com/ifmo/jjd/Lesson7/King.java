package com.ifmo.jjd.Lesson7;

public class King extends Unit {

    private int gold = 600;
    private BattleUnit[] army = new BattleUnit[20];

    public King(int healthPoints, int agilityPoints) {
        super(healthPoints, agilityPoints);
    }

    public void plusGold(int gold){
        if (gold <= 0) return;
        this.gold += gold;
    }

    public void minusGold(int gold){
        if (gold > 0 || this.gold >= gold) this.gold -= gold;
    }

    public boolean hasGold(){
        return gold > 0;
    }

    // создание армии
    public void generateArmy(){
        // первые 3 пехотинцы, остальные рыцари
        // можно BattleUnit battleUnit = new Infantry()
        // не будут доступны собственные методы, переопределенные методы будут доступны
        if (this.gold < Price.ARMY) return;
            for (int i = 0; i < army.length; i++) {           // создавать объекты тут - плохо
                army[i] = BattleUnit.unitFactory();
            }
        minusGold(Price.ARMY);
    }

    // добавление юнита
    public void addUnits(){
        for (int i = 0; i < army.length; i++) {
            if (this.gold >= Price.UNIT && !army[i].isAlive()){
                army[i] = BattleUnit.unitFactory();
            }
            minusGold(Price.UNIT);
        }
    }

    // атака на другого короля
    public void starAttack(King enemy){
        for (int i = 0; i < this.army.length; i++) {
            int randUnit = (int) (Math.random() * (this.army.length));
            this.army[randUnit].attack(enemy.army[(int) (Math.random() * (enemy.army.length))]);
            this.army[randUnit].rest();
        }
    }

    // сколько живых в армии
    public int getAttackResult(){
        int alive = 0;
        for (BattleUnit unit : army) {
            if (unit.isAlive()) alive ++;
        }
        return alive;
    }

    @Override
    public void rest() {
        minusGold(20);
    }
}
