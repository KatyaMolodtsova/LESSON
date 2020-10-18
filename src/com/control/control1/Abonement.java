package com.control.control1;

import java.time.LocalDate;
import java.time.LocalTime;

public class Abonement {
    private LocalDate dateReg, dateEnd;
    private Visitor visitor;
    private String tipeAb, number;
    private String[] zones;

    public Abonement(Visitor visitor, String tipeAb, String number) {
        LocalDate dateNow = LocalDate.now();
        this.dateReg = dateNow;
        setTipeAb(tipeAb, dateNow);
        setVisitor(visitor);
        this.number = number;
    }

    public LocalDate getDateReg() {
        return dateReg;
    }

//    private void setDateReg(LocalDate dateReg, LocalDate dateNow) {
//        if (dateReg == null) throw new IllegalArgumentException("Не указана дата начала регистрации абонемента");
//        if (dateReg.isBefore(dateNow)) throw new IllegalArgumentException("Дата начала регистрации абонемента не может быть ранее текущей даты");
//        this.dateReg = dateReg;
//    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

//    private void setDateEnd(LocalDate dateEnd, LocalDate dateReg) {
//        if (dateEnd == null) throw new IllegalArgumentException("Не указана дата завершения абонемента");
//        if (dateEnd.isBefore(dateReg)) throw new IllegalArgumentException("Дата завершения абонемента не может быть ранее даты начала регистрации абонемента");
//        this.dateEnd = dateEnd;
//    }

    public Visitor getVisitor() {
        return visitor;
    }

    private void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public String getTipeAb() {
        return tipeAb;
    }

    public void setTipeAb(String tipeAb, LocalDate dateNow) {
        if (tipeAb == null) throw new IllegalArgumentException("Не указана тип абонемента");
        switch (tipeAb){
            case Constants.ONETIPE:
                this.tipeAb = tipeAb;
                this.dateEnd = dateNow;
                zones = new String[2];
                zones[0] = Constants.POOL;
                zones[1] = Constants.GYM;
                break;
            case Constants.TWOTIPE:
                this.tipeAb = tipeAb;
                this.dateEnd = dateNow.plusMonths(6);
                zones = new String[2];
                zones[0] = Constants.GROUP;
                zones[1] = Constants.GYM;
                break;
            case Constants.TRHEETIPE:
                this.tipeAb = tipeAb;
                this.dateEnd = dateNow.plusMonths(6);
                zones = new String[3];
                zones[0] = Constants.POOL;
                zones[1] = Constants.GYM;
                zones[1] = Constants.GROUP;
                break;
        }
    }
}
