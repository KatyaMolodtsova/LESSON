package com.ifmo.jjd.Lesson6;

// название
// количество картинок
// автор (имя, фамилия)
public class ColoringBook {
    // свойства / поля / атрибуты
    private String title; // название, значение по умолчанию null
    private int pageCount; // количество страниц, значение по умолчанию 0
    private Author author; // автор, значение по умолчанию null

    // значение свойств по умолчанию
    // boolean - false
    // целочисленные типы - 0
    // числа с плавающей точкой - 0.0
    // char - u0000
    // ссылочные типы - null

    // модификаторы
    // private - доступно только в рамках текущего класса
    // public - доступно из любого участка программы
    // package-private / default (если не установлен) - модификатор по умолчанию - доступно в рамках пакета
    // protected - доступно в рамках пакета + в рамках дочерних классов

    // создаем метод для обращения к свойству
    // сеттер - метод, который позволит выпонить проверку входящих данных и установить значение свойства объекта
    // void - метод ничего не возвращает
    // String title - аргументы метода, бесконечное количество аргументов "..." и соберуться в массив

    public void setTitle(String title){
        // this ссылка на текущий объект
        if (title == null || title.trim().length() < 3)
            // искуственно создаем ошибку
            throw new IllegalArgumentException("title должен быть не меньше 3");
        this.title = title;

        // this можно не использовать, если аргумент отлично от свойства
    }

    // геттер - метод, котоырй возвращает значение свойства
    // String - тип возвращаемого значения
    public String getTitle(){
        // return - возвращает результат работы метода
        // прерывает работу метода
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        if (pageCount < 5)
            throw new IllegalArgumentException("pageCount должен быть не меньше 5");
        this.pageCount = pageCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        if (author == null)
            throw new IllegalArgumentException("author не должен быть null");
        this.author = author;
    }

    @Override
    public String toString() {
        return "ColoringBook{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                ", author=" + author +
                '}';
    }
}
