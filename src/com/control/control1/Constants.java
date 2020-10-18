package com.control.control1;

import java.time.LocalDate;
import java.time.LocalTime;

public class Constants {
    // open fitness
    static final LocalTime openF = LocalTime.of(8,00);
    static final LocalTime closeF = LocalTime.of(22,00);
    // zone
    static final String POOL = "бассейн";
    static final String GYM = "тренажерный зал";
    static final String GROUP = "групповые занятия";
    // tipe abonement
    static final String ONETIPE = "разовый абонемент";
    static final String TWOTIPE = "дневной абонемент";
    static final String TRHEETIPE = "полный абонемент";
    // time abonement
    static final LocalTime timeDay = LocalTime.of(16, 00);
    // gender
    static final String MAN = "мужчина";
    static final String WOMAN = "женщина";
}
