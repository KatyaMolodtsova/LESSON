import java.util.Scanner;

public class Lesson2_homework {
    public static void main(String[] args) {

//        //1
//        Scanner scanner = new Scanner(System.in);
//        int num, sr, l = 1, r = 100;
//        boolean firstCall = true;
//        do {
//            if (firstCall) {
//                System.out.println("Число меньше 1 или больше 100?");
//                num = scanner.nextInt();
//                if (num == 1) {
//                    System.out.println("Работа программы завершена. Загадано число меньше 1 или больше 100");
//                    break;
//                } else firstCall = false;
//            }
//            sr = (r + l) / 2;
//            System.out.println("Число равно " + sr + "?");
//            num = scanner.nextInt();
//            if (num == 1) {
//                System.out.println("Работа программы завершена. Загаданное число равно " + sr);
//                break;
//            } else {
//                System.out.println("Число меньше " + sr + "?");
//                num = scanner.nextInt();
//                if (num == 1) {
//                    r = sr;
//                } else {
//                    l = sr;
//                }
//            }
//       }
//        while (true);

//        Scanner scanner = new Scanner(System.in);
//        int rnd, xx, yesNo = 0, min = 1, max = 100;
//        rnd = (int) ((min + max + 1) / 2);
//        while (yesNo == 0){
//            System.out.println("ono " + rnd);
//            yesNo = scanner.nextInt();
//            if (yesNo == 1) {
//                System.out.println("ok");
//            } else {
//                System.out.println("> x");
//                xx = scanner.nextInt();
//                if (xx == 1) min = rnd;
//                else max = rnd;
//                rnd = (int) ((min + max + 1) / 2);
//            }
//        }

//        // 2
//        int n = 0;
//        for (int i = 1; n < 20; i = i * 2) {
//            if (i % 2 == 0) {
//                System.out.println(i);
//                n++;
//            }
//        }

//        int num1 = 2;
//        for (int num2 = 1; num2 < 20; num2++) {
//            System.out.println(num1);
//            num1 = num1 * 2;
//        }

//        //3
//        for (int i = 90; i > 0; i = i - 5) { //входит ли 0 или нет
//            System.out.println(i);
//        }

//        //4
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите целое число");
//        int num = scanner.nextInt();
//        if (num > 25 && num < 200) //крайние значения не входят в промежуток
//            System.out.println("Число " + num + " содержится в интервале (25;200)");
//        else
//            System.out.println("Число " + num + " не содержится в инте6рвале (25;200)");

//        int min = 10;
//        int max = 500;
//
//        int i = 1;
//        while (i <= 5){
//            int ch = min + (int) (Math.random() * (max - min) + 1);
//            System.out.println("Сгенерированное число " + ch);
//
//            if (ch >25 && ch <= 200){
//                System.out.println("Число " + ch + " в интервале");
//            } else System.out.println("Число " + ch + " не в интервале");
//        }

//        //5
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите номер билета");
//        int num = scanner.nextInt();
//        switch (num){
//            case 111:
//            case 222:
//            case 333:
//                System.out.println("Вы получили книгу");
//                break;
//            case 444:
//            case 555:
//                System.out.println("Вы получили телефон");
//                break;
//            case 777:
//                System.out.println("Вы получили ноутбук");
//                break;
//            default:
//                System.out.println("Вы не получили приз");
//        }

//        int ticketNumber = 444;
//        String text;
//
//        switch (ticketNumber){
//            case 111:
//            case 222:
//            case 333:
//                text = "Вы получили книгу";
//                break;
//            case 444:
//            case 555:
//                text = "Вы получили телефон";
//                break;
//            case 777:
//                text = "Вы получили ноутбук";
//                break;
//            default:
//                text = "Вы не получили приз";
//        }
//        System.out.println(text);

//        //6
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Необходимо угадать число в диапазоне [1;9]");
// //       int num = scanner.nextInt();
//        int a = 1, b = 9;
//        int x = a + (int) (Math.random() * b);
//        do {
//            if (num == 0) {
//                System.out.println("Введен 0. Программа завершила работу");
//                break;
//            } else if (num % x == 0) {
//                System.out.println("Вы угадали");
//                break;
//            } else if (x - num < 0) {
//                System.out.println("Загаданное число меньше");
//                System.out.println("Введите число в диапазоне [1;9]");
//                num = scanner.nextInt();
//            } else if (x - num > 0) {
//                System.out.println("Загаданное число больше");
//                System.out.println("Введите число в диапазоне [1;9]");
//                num = scanner.nextInt();
//            }
//
//        }
//        while (true);
    }
}
