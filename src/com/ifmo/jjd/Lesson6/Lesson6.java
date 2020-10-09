package com.ifmo.jjd.Lesson6;

// полное имя пакета
// com.ifmo.jjd.Lesson6.Lesson6

public class Lesson6 {
    public static void main(String[] args) {
        // создание объекта: тип_данных имя_переменной = new конструктор();
        ColoringBook dogs =  new ColoringBook();
        ColoringBook flowers = new ColoringBook();

        // обращение к свойству
        // dogs.title = "Собаки";

        // напрямую обращение к свойствам не должно быть, нужна проверка на входящие данные
        // в свойства могут попасть любые данные, в том числе и не корректные
        // dogs.title = "";
        // dogs.title = null;
        // в классе прописать у свойства private

        dogs.setTitle("Собаки");
        flowers.setTitle("Цветы");

        // получение свойства у объекта
        String dogsTitle = dogs.getTitle();
        System.out.println(dogsTitle);
        System.out.println(flowers.getTitle());

        Author ivan = new Author("Иван");
        //ivan.setName("Иван");
        ivan.setSurname("Петров");

        System.out.println(ivan.getFullName());
        dogs.setAuthor(ivan);
        System.out.println(dogs.getAuthor().getFullName());

        System.out.println(dogs);

        ColoringShelf shelf = new ColoringShelf(12, "белый");
        System.out.println(shelf);

        shelf.addColoring(dogs);
        shelf.addColoring(flowers);

        shelf.addColoring(dogs, flowers);

        System.out.println(shelf.getIBooksInfo());

    }
}
