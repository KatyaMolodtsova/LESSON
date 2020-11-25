package com.ifmo.jjd.lesson22;

import com.ifmo.jjd.lesson20.serialization.Pupil;

public class Lambda {
    public static void main(String[] args) {
        // лямбда - реализация абстрактного метода интерфейса
        // получаем объекта типа интерфейс
        // интерфейс физически должен существовать, должен быть функциональным
        // Функциональный интерфейс - интерфейс, у которого только один абстрактый метод,
        // количество дефолтных методов не имеет значение

        // Operation sum = аргументы -> тело метода;
        // синтаксис лямбда
        // принимаемые аргументы (): сколько в абстрактном методе, столько и в лямбда
        //      1. можно не заключать в (), если аргумент 1
        //      2. в остальных случаях () обязательны
        //      3. можно не указывать тип данных аргументов, типы беруться из контекста
        //      (будут соответствовать типам в методе интерфейса)
        // тело метода (реализация метода)
        //      1. если реализация метода состоит из 1-й инструкции, то тело метода не заключается в {},
        //      return по умолчанию
        //      2. если реализация метода состоит из нескольких инструкций, то тело метода необходимо
        //      заключить в {}, return необходимо указывать явно

        Operation sum = (a, b) -> a + b; // Double::sum лямбда выражение
        // Operation sum = Double::sum; // ссылка на метод
        sum = Double::sum; // статический метод
        // sum = Calculator::getSum; // ошибка, тк нет объекта, вызов не статического метода
        System.out.println(Calculator.calculate(56,78, sum));
        System.out.println(sum.execute(6,7));

        System.out.println(Calculator.calculate(4,7, (a, b) -> a - b)); // можно без сохранения в переменную

        Operation div = (first, second) -> {
            if (second == 0) throw new IllegalArgumentException("second не может быть равен 0");
            return first / second;
        };

        System.out.println(Calculator.calculate(56,78, div));
        System.out.println(div.execute(6,7));

        EditAble print = (txt) -> txt + "ку-ку";

        EditAble doubleText = text -> text + text;
        // дефолтные методы - вспомогательный функционал, должны возвращать тип данных интерфейс
        // сначала вызываем дефолтные методы, потом основной
        System.out.println(doubleText
                .addPrefix("((") // вернет объект типа EditAble
                .addPostFix("))") // вернет объект типа EditAble
                .edit("ky-ky")); // вернет объект типа String

    }
}

@FunctionalInterface // аннотация, подсказка компилятору
interface Operation{ // функциональный интерфейс с одним абстрактным методом execute
    double execute(double a, double b);
}

@FunctionalInterface
interface EditAble{
    String edit(String text);

    default EditAble addPrefix(String prefix){ // дефолтные методы возвращают тип интерфейс
        return text -> edit(prefix + " " + text);
    }

    default EditAble addPostFix(String postfix){
        return text -> edit(text + " " + postfix);
    }
}

class Calculator{
    public double getSum(double a, double b){
        return a + b;
    }
    public static double calculate(double a, double b, Operation operation){
        return operation.execute(a, b);
    }
}