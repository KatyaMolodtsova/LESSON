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
        if (this.gold < 250) return;
            for (int i = 0; i < 3; i++) {
                army[i] = new Infantry(
                        (int) ((Math.random() * 41) + 20),
                        (int) ((Math.random() * 11) + 5),
                        (int) ((Math.random() * 1) + 5));
            }
            for (int i = 3; i < army.length; i++) {
                army[i] = new Knight(
                        (int) ((Math.random() * 41) + 10),
                        (int) ((Math.random() * 11) + 5),
                        (int) ((Math.random() * 11) + 8));
            }
        minusGold(250);
    }

    // добавление юнита
    public void addUnits(){
        for (int i = 0; i < army.length; i++) {
            if (this.gold >= 20 && !army[i].isAlive()){
                army[i] = new Knight(
                        (int) ((Math.random() * 41) + 10),
                        (int) ((Math.random() * 11) + 5),
                        (int) ((Math.random() * 1) + 8));
            }
            minusGold(20);
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
