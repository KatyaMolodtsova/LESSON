package com.ifmo.jjd.lesson11;

import com.ifmo.jjd.Lesson7.AttackAble;
import com.ifmo.jjd.Lesson7.BattleUnit;
import com.ifmo.jjd.Lesson7.Unit;
import com.homework.lesson7.Pupil;

import java.util.Arrays;

public class EnumLesson {
    public static void main(String[] args) {
        Article article = new Article("Путешествие в Австралию");
        article.setText("Text");
        // обращение к элементу перечисления:
        // ИмяПеречисления.ЭЛЕМЕНТ
        article.setCountry(Country.AUSTRALIA);

        Article uk = new Article("Путешествие в Британию");
        article.setText("текст");
        article.setCountry(Country.UK);

        // методы enum
        Country[] countries = Country.values();
        System.out.println(Arrays.toString(countries));

        // индекс элемента в массиве перечисления
        System.out.println(Country.AUSTRALIA.ordinal());
        // iter + Enter
        for (Country country : countries) {
            System.out.println("country: " + country);
        }

        // получение элемента перечисления по строке
        // метод чувствителен к регистру
        // метод выбросит исключение, если элемент не будет найден
        Country byString = Country.valueOf("USA"); // Country.USA

        String countryName = Country.AUSTRALIA.toString();
        countryName = Country.AUSTRALIA.name();
        System.out.println(countryName);

        // enum (перечисление) Priority
        int highCode = Priority.HIGH.getCode();
        System.out.println(100);

        Priority.LOW.setCode(12);
        System.out.println(Priority.LOW.getCode());

        System.out.println(Priority.MIDDLE.getCode());

        // enum Operation
        System.out.println(Operation.MULTI.action(34, 78));
        System.out.println(Operation.SUM.action(34, 78));

        // обращение к enum, которые объявлениы внутри класса
        // ИмяКласса.ИмяПеречисления.ЭЛЕМЕНТ
        System.out.println(SomeClass.EnumInClass.ONE);

        SomeClass someClass = new SomeClass(SomeClass.EnumInClass.TREE);
    }
}
// если перечисление используется несколькими классами
// в программе, то правильно вынести его в отдельный класс
// с модификатором public (например, enum Month)
class SomeClass {
    private EnumInClass enumInClass;

    public SomeClass(EnumInClass enumInClass) {
        this.enumInClass = enumInClass;
    }

    // private - не позволит обратиться к EnumInClass вне класса
    // default - сможем обратиться к EnumInClass внутри пакета
    // protected - сможем обратиться к EnumInClass из дочерних классов
    // public - сможем обратиться к EnumInClass из любого участка программы
    public enum EnumInClass {
        ONE, TWO, TREE
    }

}

// enum перечисление - набор логически связанных констант
// объявление перечислений enum ИмяПеречисления {
//      элементы перечисления через запятую
//      если в enum только элементы перечисления, по после
//      последнего точку с запятой можно опустить
// }
enum Country {
    UK, USA, AUSTRALIA // объекты типа Country
}

enum Priority {
    HIGH(100), MIDDLE(50), LOW(0);

     private int code;

    Priority(int code) {
        this.code = code;
    }

    // метод доступен всем элементам перечисления Priority
    public int getCode() {
        return code;
    }

    // метод доступен всем элементам перечисления Priority
    public void setCode(int code) {
        this.code = code;
    }
}

enum Operation {
    SUM {
        @Override
        public int action(int a, int b) {
            return a + b;
        }
    },

    MULTI {
        @Override
        public int action(int a, int b) {
            return a * b;
        }
    };
    abstract public int action(int a, int b);

    /*public int action(int a, int b) {
        if (this.equals(MULTI)) {
            return a * b;
        } else if (this == SUM) {
            return a + b;
        }
        return 0;
    }*/
}
