package com.ifmo.jjd.lesson17;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Config {
    // параметры аннотации
    // String, примитивы, перечисления (enum). Обертки нельзя использовать
    String desс(); // без значения по умолчанию
    int version() default  1; // со значением по умолчанию
}
