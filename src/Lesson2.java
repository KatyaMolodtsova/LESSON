import java.util.Scanner;

public class Lesson2 {
    public static void main(String[] args) {
        //if else
        //if (условие1) {набор инструкций, если условие1 = true}
        // else if (условие2) {набор инструкций, если условие1 = false, а условие2 = true}
        // либо else {набор инструкций, если все предыдущие условия = false}
//        int state = 0;
//
//        if (state == 0)
//            System.out.println("Закрытие приложения");
//        else if (state == 1)
//            System.out.println("Запуск приложения");
//        else
//            System.out.println("Ошибка статуса");

        // логические операторы
        // всегда возвращают либо true либо false
        // &&  и                    (и то и то true)
        // ||  или                  (или одно или другое true)
        // !   не                   (инверсия)
        // ^   исключаюшее или      (один из true, но не оба)

//        int code = 60;
//        if (state == 0 && code > 100)
//            System.out.println("TRUE");
//        else
//            System.out.println("FALSE");

//        int count = 110;
//        // 100-90 - оценка 5
//        // 89-60 - оценка 4
//        // 59-40 - оценка 3
//        // 39-0 - оценка 2
//
//        if (count > 100 || count < 0)
//            System.out.println("Не корректное значение");
//        else if (count > 89 && count <= 100)
//            System.out.println("Оценка 5");
//        else if (count < 90 && count > 59)
//            System.out.println("Оценка 4");
//        else if (count < 60 && count > 39)
//            System.out.println("Оценка 3");
//        else
//            System.out.println("Оценка 2");

        // swith (переменна/выражение) {
        //      case значение1/выражение1:
        //      инструкции;
        //      break;
        //      case значение2/выражение2:
        //      инструкции;
        //      break;
        //      case значение3/выражение3:
        //      инструкции;
        //      break;
        //      default:
        //      инструкции;
        // }
        // выражение/переменна могут быть
        // byte (Byte - класс обертка), short (Short - класс обертка), char (Character - класс обертка)
        // int (Integer - класс обертка), String, enum (перечисление)

        // 4653 - 30%
        // 5698, 5111 - 20%
        // 6922, 6113, 6099 - 10%
        // 0%

        int sum = 10000;
        int code = 6923;
        double disc = 0;

        switch (code) {
            case 4653:
                disc = 0.30;
                break;
            case 5698:
            case 5111:
                disc = 0.20;
                break;
            case 6922:
            case 6113:
            case 6099:
                disc = 0.10;
                break;
        }
        System.out.println(sum - sum * disc);

        // инкремент увеличивает на 1
        // постфиксный х++ (возвращает значение, потом увеличивает)
        // префиксный ++х (увеличивает значение, потом возвращает)
        // декремент значение на 1
        // постфиксный х-- (возвращает значение, потом уменьшает)
        // префиксный --х (уменьшает значение, потом возвращает)

        int a = 2;
        int res = a++ - ++a + a++ + a++ + a;
        // 2 - 4 + 4 + 5  + 6
        System.out.println(res);

        // цикл while
        // while(условие) {
        // инструкция (тело цикла)
        //}

//        // вывести на экран числа из отрезка 55-78
//        int i = 55;
//        while (i < 79) {
//            System.out.println(i);
//            i++;
//        }

        // вводится целое чило. вывести увеличенное на 2. прервать когда 0
        Scanner scanner = new Scanner(System.in);

//        while (true) {
//            System.out.println("Введите целое число");
//            int num = scanner.nextInt();
//            if (num == 0)
//                break;
//        }

//        int num;
//        do {
//            System.out.println("Введите целое число");
//            num = scanner.nextInt();
//            if (num != 0)
//            System.out.println(num + 2);
//        } while (num != 0);
//
//        // for
//        for (int i = 0; i < 9; i++) {
//            if (i % 2 == 0) System.out.println(i);
//
//        }

        // 1 задача - двоичный поиск. деление отрезка на половину

        //Math.random(); // возвращает какое-то число double от 0 до 1 (не включает)
        // как задавать диапазон в рандом через []
    }
}
