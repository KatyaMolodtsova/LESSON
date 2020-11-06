package com.ifmo.jjd.lesson17;

@Config(desс = "Описание класса") // параметры с дефолтными означениями можно не указывать
public class SomeClass {

    @Required
    private String stringData;

    public String getStringData() {
        return stringData;
    }

    public void setStringData(String stringData) {
        this.stringData = stringData;
    }
}
