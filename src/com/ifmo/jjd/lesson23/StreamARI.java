package com.ifmo.jjd.lesson23;

import com.ifmo.jjd.lesson22.Course;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.String;

public class StreamARI {
    public static void main(String[] args) {
        /*
             Stream API - набор методов для работы с данными, как с потоком.
             Позволяет представить различные наборы данных в виде потока,
             а далее: сортировать их, фильтровать, осуществлять поиск по различным критериям,
             кроме этого позволяет создавать новые потоки, создавать коллекции и мапы из потока данных и тд
         */
         /*
             Stream никогда НЕ ХРАНИТ ДАННЫЕ.
             Для сохранения данных из Stream нужно использовать специальные методы.
             Stream никогда НЕ ИЗМЕНЯЕТ ИСТОЧНИК (коллекцию, массив и тд), из которого он создан, все преобразования происходят только в потоках.
             В своей работе методы stream используют лямбда выражения.
         */

         /*
             Для работы с потоками данных необходимо:
             1. получить данные в виде потока - объект типа Stream
             2. выполнить промежуточные операции с потоком данных
             (промежуточные операции обрабатывают данные и возвращают Stream объект)
             3. выполнить терминальную (конечную) операцию
             (терминальная операция обрабатывает данные и завершает работу потока)
             Без терминальной операции промежуточные операции не начнут выполняться!!!
         */

        // все операции деляться на промежуточные и конечные (терминальные). Промежуточных может быть несколько,
        // терминальная только одна, всегда после промежуточных
        // терминальная операция:
        //      возвращает массив, коллекцию или мапу
        //      из набора возвращает один объект или набор, в зависимости от метода
        //      возвращает информацию по этому набору
        //      никогда не вернет объект stream
        // когда терминальная операция отработала, stream закрыт


        /*
             Например, получили объект stream, далее выполняем
             промежуточные операции
             stream.операция1() - вернет преобразованный объект stream
                   .операция2() - вернет преобразованный объект stream
                   .операция3()  - вернет преобразованный объект stream
                   .терминальнаяОперация(); // запускает промежуточные операции, данные обрабатываются, стрим закрывается
             основные терминальные операции: forEach / findFirst / findAny / xxxMatch / min / max / collect
         */

         /*
            Методы получения Stream объектов:
             * из коллекций collection.stream();
             * из массива Arrays.stream(arr);
             * из файла Files.lines(path_to_file);
             * из строки string.chars();
             * используя builder:
             * Stream.builder().add(obj1).add(obj2).add(objN).build();
             * Stream.of(1, 4, 7); любой набор данных
         */
         /*
         Распространенные промежуточные операции:
             * filter принимает на вход Predicate, возвращает поток (Stream) с теми объектами, которые удовлетворяют условию
             * map принимает на вход Function, возвращает новый поток (Stream), состоящий из обработанных функцией объектов
             исходного Stream
             * limit принимает на вход int, возвращает новый поток (Stream), состоящий из указанного количества первых объектов
             * skip принимает на вход int, убирает из потока указанной количество первых элементов,
             возвращает новый поток (Stream), состоящий из оставшихся элементов (или пустой Stream)
             * distinct возвращает поток (Stream), состоящий из уникальных объектов
             * sorted возвращает поток (Stream) отсортированных объектов, можно передать компаратор
             * peek принимает на вход Consumer, обрабатывает каждый элемент потока (Stream), возвращает новый поток (Stream)
         */
        /*
        Распространенные терминальные операции:
             * forEach принимает на вход Consumer, применяет переданный метод к каждому объекту потока (Stream),
             порядок Обработки при параллельном выполнении не гарантируется
             * anyMatch принимает на вход Predicate, возвращает true,  если хотя бы один элемент потока соответствует условию
             * allMatch принимает на вход Predicate, возвращает true,  если все элементы потока соответствуют условию
             * noneMatch принимает на вход Predicate, возвращает true,  если ни один элемент потока соответствует условию
             * findFirst возвращает первый элемент потока в Optional контейнере
             * findAny возвращает случайный элемент потока в Optional контейнере
             * min | max принимают на вход компаратор, возвращают минимальный / максимальный элемент потока в Optional контейнере
             * collect принимает на вход Collector, возвращает коллекцию или мапу
         */

        // создание потока
        Stream<Integer> integerStream = Stream.of(908, 478, -973, 811, 11, 0, 3874, 2981, -94735);
        // Stream.of принимает на вход переменное количество аргументов, формирует поток

        // промежуточные операции

        // filter принимает предикат
        // каждый элемент потока обработает с помощью предиката
        // если возвращает true - элемент остается в потоке, если false - то элемент удаляется из потока
        integerStream.filter(num -> num < 0) // останутся отрицательные

        // map принимает на вход функцию, на основе указанной функции изменяет элементы stream
        // функция может работать с разными типами данных, может принять один, а вернуть другой
                .map(num -> num * num) // полученные результат сохраняется в новый stream

        // limit принимает на вход long, и оставит в stream заданное количество элементов
                .limit(3) // оставит 3 элемента

        // forEach просто что-то делает с элементами stream, ничего не возвращает
        // принимает на вход метод, терминальная операция
                .forEach(System.out::println);

        // все операции выполняются последовательно, forEach запускает промежуточные операции



        integerStream = Stream.of(908, 478, -973, 811, 11, 0, 3874, 2981, -94735);

        // distinct возвращает объект типа stream, в который входят только уникальные элементы из предыдущего stream
        // сравниваются по equals
        integerStream.distinct()

        // позволяет передать компоратор, с методами сортировки, сортирует в натуральном порядке
                .sorted()
                .forEach(System.out::println);



        // anyMatch - хотя бы один| allMatch - каждый | noneMatch - ни один
        // все три метода терминальные, возвращают true / false, принимают на вход предикат

        integerStream = Stream.of(908, 478, -973, 811, 11, 0, 3874, 2981, -94735);
        // хотя бы один из элементов соответствует условию, то возвращает true
        System.out.println(integerStream.anyMatch(num -> num == 0));

        integerStream = Stream.of(908, 478, -973, 811, 11, 0, 3874, 2981, -94735);
        // все из элементов соответствует условию, то возвращает true
        System.out.println(integerStream.allMatch(num -> num > 300));

        integerStream = Stream.of(908, 478, -973, 811, 11, 0, 3874, 2981, -94735);
        // ни одни из элементов не соответствует условию, то возвращает true
        System.out.println(integerStream.noneMatch(num -> num > 1000));

        // findFirst - вернет первый элемент в Optional контейнер
        // findAny - вернет произвольный элемент в Optional контейнер
        // обе терминальные операции

        // Optional - null safe container

        String[] colors = {"white", "black", "green", "yellow", "brown"};

        String firstColors = Arrays.stream(colors) // получаем stream из элементов массива
                .skip(1) // создает новый поток, у существующего пропускает заданное количество первых
                        // элементов, остальные добавляет в новый поток
                .filter(sim -> sim.startsWith("b")) // начинается на b
                .findFirst() // Optional -> String - внутри контейнера находится элемент из потока
                //.get() // получить элемент. если будет null на месте элемента, то будет ошибка
                .orElse("default"); // возвращает дефолтное значение

        // если null - то false, если строка - то true
        boolean isPresent = Arrays.stream(colors).findFirst().isPresent();

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());

        System.out.println(courses);

        // из потока получим минимальный и максимальный
        // методы являются конечными, Optional контейнер

        Course minByPrice = courses.stream() // получаем поток из элементов коллекции
                .min(Comparator.comparing(Course::getPrice)) // минимальный по стоимости
                .orElse(Course.getInstance());

        // max по продолжительности
        Course maxDuration = courses.stream() // получаем поток из элементов коллекции
                .min(Comparator.comparing(Course::getDuration).reversed()) // минимальный по стоимости
                .orElse(Course.getInstance());

        // получим массив курсов дороже 20 000
        Course[] coursesArr = courses.stream()
                .filter(course -> course.getPrice() > 20000)
                .toArray(Course[]::new); // ссылка на конструктор массива
                // .toArray() Object[]

        // увеличим стоимость курсов продолжительностью < 3 на 5000, получим List
        List<Course> courseList = courses.stream()
                .filter(course -> course.getDuration() < 3)
                .peek(course -> course.setPrice(course.getPrice() + 5000)) // Изменение
                .collect(Collectors.toList()); // collect(Collectors.toSet()

        ArrayList<Course> courseArrayList = courses.stream()
                .distinct()
                .sorted(Comparator.comparing(Course::getName))
                .collect(Collectors.toCollection(ArrayList::new)); // ссылка на конструктор любой коллекции

        // получим мапу
        colors = new String[] {"white", "black", "green", "yellow", "brown"};
        Map<String, Integer> mapFromArr = Arrays.stream(colors) // возвращает мапу
                .collect(Collectors.toMap(
                        Function.identity(), // Function: если указывается сам элемент // указываем, как формировать ключи, возвращает ключ
                        String::length, // Function: s -> s.length // как формировать значения, возвращает значение
                        (item1, item2) -> item1 // BinaryOperator: делаеть все, что угодно // что делать, если ключи одинаковые
                ));

        // flatMap | map
        String[][] strings = {
                {"45", "-7", "89", "10"},
                {"12", "65", "122"},
                {"67", "-1", "200", "3"}
        };

        String[][] stringsMap = Arrays.stream(strings) // получили поток из элементов массива
                // каждый из элементов преобразовываем в поток, получили массив с уникальными элементами и отсортированными
                .map(arr -> Arrays.stream(arr).distinct().sorted().toArray(String[]::new))
                .toArray(String[][]::new);

        String[] strings1FlatMap = Arrays.stream(strings) // получили поток из элементов массива
                // каждый массив -> создаем поток, элементы сливаем в общий поток
                // получаем один общий поток
                .flatMap(arr -> Arrays.stream(arr).distinct().sorted())
                .toArray(String[]::new);

    }
}
