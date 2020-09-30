import java.util.Arrays;

public class Lesson3 {
    public static void main(String[] args) {
    //объявление массива
        // объявление массива
        int[] array1;
        //int arrayInt []; //нежелательно

        // создание массива
        array1 = new int[5];
        // заполнен значениями по умолчанию
        // для целых чисел 0
        // для чисел с плавающей точкой 0.0
        // для boolean false
        // для char '\u0000' нулевой символ
        // для ссылочных типов null

        int[] array2 = {45, 67, 78, 34, 900, 55};

//        array2 = {45, 67, 78, 34, 900, 55}; //нельзя
        array2 = new int[]{45, 67, 78, 34};

        // доступ к элементам
        System.out.println(array2[3]);

        // изменение элеманта
        array2[3] = 67;

        // длина массива
        System.out.println(array2.length); //тип int

        // вывод в консоль
        System.out.println(Arrays.toString(array2));

        // перебор элементов
        for (int i : array2) { //iter
            System.out.println("i = " + i); // доступа к элементам массива нет
        }

        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }

        // сравнение массива
        array1 = new int[]{45, 67, 78, 34, 900, 55};
        array2 = new int[]{45, 67, 78, 34, 900, 55};

        System.out.println(Arrays.equals(array1, array2)); // результат boolean

        //compare, compareUnsigned, mismatch что делают

        // сортировка массива
        Arrays.sort(array1); // Arrays.sort(array1, [from, to));
        Arrays.parallelSort(array1);

        // поиск в отсортированном массиве
        array1 = new int[]{45, 67, 78, 900};
        System.out.println(Arrays.binarySearch(array1, 67));
    }
}
