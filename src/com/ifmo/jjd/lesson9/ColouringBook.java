package com.ifmo.jjd.lesson9;

import java.util.Objects;

public class ColouringBook extends Book{

    private int picsCount;

    public ColouringBook(String title, int pageCount, int picsCount) {
        super(title, pageCount);
        this.picsCount = picsCount;
    }

    public int getPicsCount() {
        return picsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColouringBook)) return false;
        ColouringBook that = (ColouringBook) o;
        return picsCount == that.picsCount &&
                Objects.equals(this.getTitle(), that.getTitle()) &&
                Objects.equals(this.getPageCount(), that.getPageCount()) &&
                Objects.equals(this.getAuthor(), that.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(picsCount);
    }

    @Override
    public String toString() {
        return "ColouringBook{" +
                "picsCount=" + picsCount + '\'' +
                "pageCount=" + getPicsCount() + '\'' +
                "title=" + getTitle() + '\'' +
                "Author=" + getAuthor() +
                '}';
    }

    @Override
    protected Object clone() {
        ColouringBook newColoringBook = new ColouringBook(this.getTitle(), this.getPageCount(), picsCount);
//        newColoringBook.setAuthor(this.getAuthor()); // ссылка на автора
        newColoringBook.setAuthor(new Author(
                this.getAuthor().getName(),
                this.getAuthor().getSurname()
                ));
        return newColoringBook;
    }
}