package com.ifmo.jjd.Lesson7;

public class Application {
    public static void main(String[] args) {
        King king1 = new King(100, 10);
        King king2 = new King(100, 15);

        king1.generateArmy();
        king2.generateArmy();

        king1.starAttack(king2);
        king2.starAttack(king1);

        System.out.println(king1.getAttackResult());
        System.out.println(king2.getAttackResult());

        king1.addUnits();
        System.out.println(king1.getAttackResult());

    }
}
