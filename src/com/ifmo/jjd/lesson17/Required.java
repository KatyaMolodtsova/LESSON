package com.ifmo.jjd.lesson17;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // только для полей класса
//@Target({ElementType.FIELD, ElementType.METHOD}) // для нескольких
@Retention(RetentionPolicy.RUNTIME) // Должна сохранится на момент выполнения программы
public @interface Required {
}
