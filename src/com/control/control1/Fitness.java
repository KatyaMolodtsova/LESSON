package com.control.control1;

import java.time.LocalTime;

public class Fitness {
    final private int maxCount = 20;
    Abonement[] abonements = new Abonement[100];
    Abonement[] zonePool = new Abonement[maxCount];
    Abonement[] zoneGym = new Abonement[maxCount];
    Abonement[] zoneGroup = new Abonement[maxCount];
    Visitor visitor;

    public void startDay() {
        if (LocalTime.now().isBefore(Constants.openF)) System.out.println("Фитнесс-клуб еще не открыт");
        if (LocalTime.now().isAfter(Constants.closeF)) System.out.println("Фитнесс-клуб уже закрыт");

        // заводим абонементы
        for (int i = 0; i < abonements.length; i++) {
            abonements[i] = Logger.addAboment();
        }

        // запускаем на тренировку
        String[] ab = Logger.training();

    }
}
