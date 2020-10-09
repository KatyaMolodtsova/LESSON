import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Lesson5_homework {
    public static void main(String[] args) {

//        // 1
//        String[] arrayString = new String[5];
//        Scanner scanner = new Scanner(System.in);
//        String allWord = "", word;
//        boolean proverka = true;
//
//        for (int i = 0; i < arrayString.length;) {
//            System.out.println("Введите элемент массива");
//            word = scanner.nextLine();
//            word.trim();
//            if ("exit".equals(word)) {
//                System.out.println("Остановка работы пользователем. Заполнение массива прервано");
//                break;
//            }
//            for (int j = 0; j < arrayString.length; j++) {
//                if (word.equals(arrayString[j])) {
//                    System.out.println("Такой значение уже перисутствует в массиве. Введите другое значение");
//                    proverka = false;
//                    break;
//                }
//                else proverka = true;
//            }
////            else if (allWord.contains(word)) {
////                System.out.println("Такой значение уже перисутствует в массиве. Введите другое значение");
////            } else {
////                arrayString[i++] = word;
////                allWord += word;
////            }
//            if (proverka)
//                arrayString[i++] = word;
//        }
//        System.out.println(Arrays.toString(arrayString));

//        // 2
//        String string, word;
//        int number = 0;
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Введите слово, количество вхождений которого необходимо определить");
//        word = scanner.nextLine();
//        System.out.println("Введите строчку с вхождениями слова " + word);
//        string = scanner.nextLine();

//        // 3
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите палиндром");
//        String word = scanner.nextLine();
//
//        String sim1, sim2;
//        int ind;
//        boolean proverka = true;
//        String[] arrayStr = word.split("");
//        for (int i = 0; i < word.length(); i++) {
//            ind = arrayStr.length - 1 - i;
//            if (arrayStr[i].equals(arrayStr[ind])) {
//                proverka = false;
//                System.out.println("нет");
//                break;
//            } else System.out.println("да");
//        }
//        if (proverka)
//            System.out.println("Слово " + word + " является палиндромом");
//        else System.out.println("Слово " + word + " не является палиндромом");

//        // 4
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите слово");
//        String word = scanner.nextLine();
//        String allWord = "", s;
//        String[] arrayStr = word.split("");
//        for (int i = 0; i < arrayStr.length; i++) {
//            if (i == 0)
//                allWord = allWord.concat(arrayStr[i].toUpperCase());
//            else  allWord = allWord.concat(arrayStr[i].toLowerCase());
//        }
//        System.out.println(allWord);

//        // 5
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите строку");
//        String string = scanner.nextLine();
//        String[] arrayStr = string.split(" ");
//        int max = 0;
//        String wordMax = "";
//        for (String s : arrayStr) {
//            if (s.length() > max) {
//                max = s.length();
//                wordMax = s;
//            }
//        }
//        System.out.println(wordMax);
    }
}
