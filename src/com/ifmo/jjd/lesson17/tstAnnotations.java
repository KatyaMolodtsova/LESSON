package com.ifmo.jjd.lesson17;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class tstAnnotations {
    public static void main(String[] args) {
        Class<SomeClass> someClass = SomeClass.class;

        // получаем аннотации
        Annotation[] annotations = someClass.getAnnotations(); // аннотация для класса

        if (someClass.isAnnotationPresent(Config.class)) { // проверка на наличие конкретной аннотации
            System.out.println("Config.class");
            // ссылка на аннотацию someClass
            Config config = someClass.getDeclaredAnnotation(Config.class);
            System.out.println(config.desс());
            System.out.println(config.version());

            // создать объект someClass
        }

        Field[] fields = someClass.getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Required.class)) {
                System.out.println("Required.class");
                // stringData -> setStringData()
                // age -> setAge
            }
        }

        // если класс аннотирован @Config, создать экземпляр данного класса используя рефлексию
        // если поле аннотировано @Required, установить значение поля через сеттер для ранее созданного объекта
        // используя рефлексию
        // вызвать метод toString у ранее созданноого объекта используя рефлексию

    }
}
