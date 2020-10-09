package com.ifmo.jjd.Lesson6;

import java.util.Arrays;

public class ColoringShelf {
    private ColoringBook[] colouring;
    private String color = "красный";

    public ColoringShelf(int count) {
        if (count < 10)
            throw new IllegalArgumentException("count не должен быть менее 10");
        colouring = new ColoringBook[count];
    }

    public ColoringShelf(int count, String color) {
        this(count); // вызов контруктора внутри класса
        setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.trim().length() < 3)
            throw new IllegalArgumentException("color должен быть не меньше 3");
        this.color = color;
    }

    public void addColoring(ColoringBook book){
        for (int i = 0; i < colouring.length; i++) {
            if (colouring[i] == null){
                colouring[i] = book;
                return;
            }
        }
    }

    public void addColoring(ColoringBook... books){ // неограниченно количество книг
        System.out.println(Arrays.toString(books)); // собираются в массив

    }

    public String getIBooksInfo(){
        StringBuilder sb = new StringBuilder();
        for (ColoringBook book : colouring) {
            if (book != null)
            sb.append(book.getTitle()).append(" ").append(book.getPageCount()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "ColoringShelf{" +
                "colouring=" + Arrays.toString(colouring) +
                ", color='" + color + '\'' +
                '}';
    }
}
