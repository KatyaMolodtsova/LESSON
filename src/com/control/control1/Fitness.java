package com.control.control1;

import java.time.LocalTime;

public class Fitness {
    final private int maxCount = 20;

    public void startDay() {
    if (LocalTime.now().isBefore(Constants.openF)) System.out.println("Фитнесс-клуб еще не открыт");

    if (LocalTime.now().isAfter(Constants.closeF)) System.out.println("Фитнесс-клуб уже закрыт");
    }
}
