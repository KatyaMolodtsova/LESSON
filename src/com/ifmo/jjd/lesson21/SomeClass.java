package com.ifmo.jjd.lesson21;

public class SomeClass {
    public static void main(String[] args) {
        // побитовые операторы | (или) & (и) ~ (не) << (смещение)
        // все побитовые операторы работают с битами
        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(2));

        // 1000 | 0100
        // 1000
        // 0100
        // 1100 - итог
        // сравнивает побитно
        // возвращает 1, если есть хотя бы одна 1

        // 1000 & 0100
        // 1000
        // 0100
        // 0000 - итог
        // возвращает 1, если обе 1

        // ~1000 - > 0111
        // меняет значение каждого на противоположный

        User user = new User();
        // установить разрешение на файлы (0001) и видео (1000)
        user.setPerm(Permissions.FILE | Permissions.VIDEO); // 1001
        // побитовой или используется для объединения масок

        // проверить разрешение на работу с аудио (0100)
        // пересечение масок
        // 1001 & 0100 -> 0000 != 0100
        if ((user.getPerm() & Permissions.AUDIO) != Permissions.AUDIO){
            System.out.println("Доступ закрыт");
        } else {
            System.out.println("Доступ открыт");
        }

        // удаление разрешения на работу с файлами 0001
        // 1001 & ~0001 -> 1001 & 1110 -> 1000
        user.setPerm(user.getPerm() & ~Permissions.FILE);

    }
}

class  User{
    private int perm;
    // если проставим 0000, то не может работать ни с чем
    // если проставим 0101, то может работать с файлами и аудиофайлами
    // если проставим 1111, то может работать со всем
    // называется битовыми масками
    // проверить, установить, запретить


    public int getPerm() {
        return perm;
    }

    public void setPerm(int perm) {
        this.perm = perm;
    }
}

class Permissions{
    // сдвиг, сравнение на уровне бит
    // сдвиг - умножение на 2
    // разрешение на работу с файлами - 1 бит
    public static final int FILE = 1; // 1 - 0001
    // разрешение на работу с фото - 2 бит
    public static final int PHOTO = 1 << 1; // 2 - 0010
    // разрешение на работу с аудиофайлами - 3 бит
    public static final int AUDIO = 1<< 2; // 4 - 0100
    // разрешение на работу с видеофайлами - 4 бит
    public static final int VIDEO = 1 << 3; // 8 - 1000
}