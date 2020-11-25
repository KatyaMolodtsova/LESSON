package com.ifmo.jjd.lesson22;

import java.util.function.*;

public class JavaFunctionalInterfaces {
    public static void main(String[] args) {
        // в java есть определенный набор готовых функциональных интерфейсов
        // Predicate<T>: boolean test(T t); принимает дженерик, возвращает boolean
        // Function<T, R>: R apply(T t); принимает T, возвращает R, T и R могут быть одного типа, любые типы данных
        // UnaryOperator<T> T apply(T t); принимает T, возвращает T
        // BiFunction<T, U, R>: R apply(T t, U u);
        // BinaryOperator<T> T apply(T t1, T t1); принимает два аргумента типа T, возвращает T
        // Consumer<T>: void accept(T t); принимает T, ничего не возвращает, преобразование T по ссылке
        // меняется значение свойств, выводится в консоль и тд и тп

        Predicate<Integer> isEven = integer -> integer % 2 == 0;
        Predicate<Integer> pos = integer -> integer > 0;

        System.out.println(isEven.test(78));
        System.out.println(pos.test(78));

        // положительное и четное
        System.out.println(pos.and(isEven).test(56));
        System.out.println(pos.or(isEven).test(56));

        Function<Integer, Integer> s = x -> x * x;
        Function<Integer, Integer> add = x -> x * 2;

        int result = add // 3
                .compose(s) // 1
                .andThen(s) // 4
                .compose(s) // 2
                .apply(3);
    }
}
