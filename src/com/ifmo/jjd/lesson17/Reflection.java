package com.ifmo.jjd.lesson17;

import com.ifmo.jjd.lesson9.Book;

import java.lang.reflect.*;

public class Reflection {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<String> stringClass = String.class;
        System.out.println(stringClass);

        Class integerClass = int.class;
        System.out.println(integerClass);

        Class<TextMessage> textMessageClass = TextMessage.class;
        System.out.println(textMessageClass);

        TextMessage textMessage = new TextMessage("сообщение");
        textMessage.setText("рефлексия");

        Class<? extends TextMessage> tmClass = textMessage.getClass();
        System.out.println(tmClass);

        //
        String className = textMessageClass.getName(); // получить имя класса
        String packageName = tmClass.getPackage().getName(); // получить имя пакета

        // интерфейсы
        Class[] interfaces = tmClass.getInterfaces(); // получаем только интерфейсы данного класса

        System.out.println(tmClass.getSuperclass()); // возвращает ссылку на родителя

        // доступ к компонентам класса
        // доступ к public полям класса, включая родителя
        Field[] fields = tmClass.getFields();

        // доступ к полям класса, включая private и protected, не включая родителя
        Field[] declaredFields = tmClass.getDeclaredFields();

        // доступ к методам
        // доступ к public методам класса, включая методы родителя
        Method[] methods = tmClass.getMethods();

        // доступ к метода класса, включая private и protected, не включая методы родителя
        Method[] declaredMethods = tmClass.getDeclaredMethods();

        // доступ к конструкторам
        Constructor[] constructors = tmClass.getDeclaredConstructors();

        // поулчили ссылку на конструктор, который принимает на вход аргумент типа String
        Constructor<TextMessage> tmConstructor = textMessageClass.getDeclaredConstructor(String.class); // знать тип и последовательность аргументов
        Constructor<? extends TextMessage> tmConstructor2 = tmClass.getDeclaredConstructor(String.class);

        // создание объекта типа TextMessage
        TextMessage reflectMessage = tmConstructor2.newInstance("Reflect Message");

        Field field = tmClass.getDeclaredField("text");
        System.out.println(field.getType().getName()); // тип данных поля
        field.setAccessible(true); // можно обращаться к приватным полям

        // field.get() вернет значение поля для переданного объекта
        System.out.println(field.get(reflectMessage));
        // field.set() устанавливает значение поля для переданного объекта
        field.set(reflectMessage, "новое значение поля");
        System.out.println(reflectMessage.getText());

        Method method = tmClass.getDeclaredMethod("printInfo", String.class);
        method.setAccessible(true); // можно обращаться к приватным методам
        method.invoke(reflectMessage, "!!!"); // передаем объект, у которого вызываем, потом аргументы
        // method.getParameterTypes() массив методов

        // Class, Field, Method
        boolean isPrivate = Modifier.isPrivate(field.getModifiers()); // передаем набор модификаторов

        // классы приходят динамически в программу
    }

//    public static String toString(Object o){
//        // выводит имя поля и значение
//        Integer i = 6;
//        long l = 78;
//        Book b; // hashCode
//        String s = "str";
//        int[] ints = {3, 4, 5}; // hashCode
//    }
}
