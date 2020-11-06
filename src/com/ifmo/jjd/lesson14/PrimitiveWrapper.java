package com.ifmo.jjd.lesson14;

import com.ifmo.jjd.Lesson7.Infantry;

public class PrimitiveWrapper {
    public static void main(String[] args) {
        // byte, int, float ...
        // byte - class Byte
        // short - class Short
        // int - class Integer
        // long - class Long
        // float - class Float
        // double - class Double
        // boolean - class Boolean
        // char - class Character

        // примитивы необходимо использовать всегда, за исключением случаев:
        // 1. когда использование примитивов невозможно
        // 2. когда необходимо воспользоваться методами классов оберток

        int num = 567;
        // Integer count = new Integer(54); данный вариант не используется,
        // принято использовать вариант:
        Integer count = 54;

        // автоупаковка и автораспаковка
        // автоупаковка - переменной класса обертки присваивается
        // значение примитива
        Integer age = 38; // автоупаковка
        age = num; // автоупаковка

        // автораспаковка - переменной примитивного типа
        // присваивается значение обертки
        double price;
        Double someDouble = 56.89; // автоупаковка
        price = someDouble; // автораспаковка

        // Правила автоупаковки и автораспаковки
        // 1. автоупаковка не работает если примитив не соответсвует
        // типу класса обертки
        // Byte byteObj = 500;
        // Byte byteObj = 400;
        byte one = 1;
        // Integer i = (Integer) one;
        Integer i = (int) one;

        // 2. на автораспаковку данное правило не распространяется
        Byte two = 2;
        int num2 = two; // автораспаковка + не явное приведение типов

        Integer three = 3;
        // byte num3 = three; // автораспаковка + необходимо
        // явное приведение типов, которое мы не можем выполнить,
        // тк типы Integer и Byte не совместимы
        // byte num3 = (Byte) three;
        // byte num3 = (Byte) ((Number) three);
        // System.out.println(num3);

        // 3. параметры (агрументы) методов подлежат
        // правилам автораспаковки и автоупаковки
        printSqrt(78);
        Integer integer = 45;
        printNum(integer);

        // 4. автораспаковка и автоупаковка не работают с массивами
        double[] doubles = {45.88, 123.701, 3.8};
        // метод, который принимает на вход массив типа Double
        // и выводит элементы этого массива в консоль
        // printDoubles(doubles); автоупаковка не работает

        // методы оберток
        // (Byte, Short, Integer, Long, Double, Float),
        // которые возвращают примитивы
        byte byteValue = integer.byteValue();
        int intValue = integer.intValue();
        long longValue = integer.longValue();
        float floatValue = integer.floatValue();
        double doubleValue = integer.doubleValue();

        // методы преобразивания строки с числом:
        // Обертка.parseXXX(строка_с_числом) возвращает примитив
        // Обертка.valueOf(строка_с_числом) возвращает объект

        System.out.println(Byte.parseByte("4")); // вернет примитив byte
        System.out.println(Byte.valueOf("4")); // вернет объект типа Byte

        System.out.println(Integer.parseInt("43")); // вернет примитив int
        System.out.println(Integer.valueOf("43")); // вернет объект типа Integer

        // если строка содержит не только число, мы получим NumberFormatException

        System.out.println(Double.parseDouble("4.5"));
        // System.out.println(Double.parseDouble("4,5")); NumberFormatException

        Integer first = 34;
        Integer second = 34;
        System.out.println(first.equals(second));
        System.out.println(Integer.compare(first, second));

        // first и second ссылаются на один объект,
        // тк значения в диапазоне [-128; 127]
        System.out.println(first == second); // true

        first = 200;
        second = 200;
        // first и second ссылаются на разные объекты,
        // тк значения вне диапазон [-128; 127]
        System.out.println(first == second); // false

        // для сравнения целочисленных значений с диапазоне
        // от [-128; 127] можно использовать ==

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.out.println(Double.NEGATIVE_INFINITY);
        System.out.println(Double.POSITIVE_INFINITY);

        Integer x = 89;
        Integer y = 99;
        int k = 9990;
        int z = 6;
        get(x, y);
        get(x, k);
        get(k, x);
        // get(k, z);
    }

    public static void get(Integer i, int i1){
        System.out.println("Integer i, int i1");
    }
    public static void get(Integer i, Integer i1){
        System.out.println("Integer i, Integer i1");
    }
    public static void get(int i1, Integer i){
        System.out.println("int i1, Integer i");
    }


    public static void printDoubles(Double[] doubles){
        for (Double aDouble : doubles) {
            System.out.println(aDouble);
        }
    }

    public static void printSqrt(Integer i){
        Integer res = i * i;
        System.out.println(res);
    }
    public static void printNum(int i){
        System.out.println(i);
    }

}
