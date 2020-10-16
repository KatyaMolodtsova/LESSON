package com.ifmo.jjd.control1;

import java.time.LocalDate;

public class Abonement {
    private LocalDate dateReg, dateEnd;
    private Visitor visitor;
//    private String strDateReg, strDateEnd;

    public Abonement(LocalDate dateReg, LocalDate dateEnd, Visitor visitor) {
        LocalDate dateNow = LocalDate.now();
        this.dateReg = dateReg;
        this.dateEnd = dateEnd;
        this.visitor = visitor;
    }

    public LocalDate getDateReg() {
        return dateReg;
    }

    private void setDateReg(LocalDate dateReg, LocalDate dateNow) {
        if (dateReg == null) throw new IllegalArgumentException("Не указана дата начала регистрации абонемента");
        if (dateReg.isBefore(dateNow)) throw new IllegalArgumentException("Дата начала регистрации абонемента не может быть ранее текущей даты");
        this.dateReg = dateReg;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    private void setDateEnd(LocalDate dateEnd, LocalDate dateReg) {
        if (dateEnd == null) throw new IllegalArgumentException("Не указана дата завершения абонемента");
        if (dateEnd.isBefore(dateReg)) throw new IllegalArgumentException("Дата завершения абонемента не может быть ранее даты начала регистрации абонемента");
        this.dateEnd = dateEnd;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    private void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }
}
