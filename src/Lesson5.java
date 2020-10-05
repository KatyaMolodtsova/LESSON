import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;
import java.util.Objects;

public class Lesson5 {
    public static void main(String[] args) {

        // char - один 16 битный символ юникод
        // от 0 до 65536 / от '\u0000' до '\uffff'

        // можно задать
        char char1 = 'J'; // сам символ в одинарных кавычках
        char char2 = 74; // номер символа
        char char3 = '\u0044'; // шеснадцатиричное представление в escape последовательности
        System.out.println(char1); // J
        System.out.println(char2); // J
        System.out.println(char3); // D

        // строки
        // строка - упорядоченная последовательность символов, объекты (ссылочный тип) класс String
        // строки задаются
        //   ""
        //   используя new String(), использовать, только если создание через "" не подходит
        // строки нельзя изменить, можно только создать новую на основе существующей
        // все строковые литеры (например System.out.println("Строки"); реализованы как экземпляры String

        char[] jjdChars = {'\u004A', '\u004A', '\u0044'};
        String jjdString = new String(jjdChars);
        jjdString = "\u004A\u004A\u0044";
        System.out.println(jjdString);
        System.out.println(jjdString.length());

        char[] frogChars = {'\uD83D', '\uDC38'};
        String frogString = new String(frogChars);
        System.out.println(frogString);
        System.out.println(frogString.length()); // 2
        System.out.println(frogString.codePoints().count()); // 1

        // каждый символ Unicode может быть представлен
        // одним или парой (суррогатная пара) чаров

        // хранение строк до java 9: массив char[] в кодировке UTF-16
        // при этом каждый char был представлен двумя байтами

        // хранение строк с java 9 (компактные строки): массив byte[] + кодировка UTF-16 или LATIN1
        // длина строки при UTF-16 - деленная на 2, при LATIN1 - длина массива

        // Пул строк
        // пул строк (находится в heap памяти) хранит только одну копию каждого строкого латерала
        String string1 = "Строка"; // в "" - сразу в пул строк
        String string2 = "Строка";
        String string3 = new String("Строка"); //конструктор, создается вне пула строк, как объект

        System.out.println(string1 == string2); // проверка ссылки, на один и тот же объект? //true
        System.out.println(string1 == string3); // false

        // Метод intern()
        String internStr = string3.intern();
        System.out.println(string1 == internStr); // true
        System.out.println(string3 == internStr); // false
        System.out.println(string2 == internStr); // true
        //если есть, вернет ссылку на объект, если нет, то создаст и вернет ссылку. В пул строк не перенесет ничего

        // сравнение строк, метод equals()
        System.out.println(string1.equals(string2)); // true
        System.out.println("строка".equals(string1)); // false
        System.out.println("строка".equalsIgnoreCase(string1));

        // вариант "строка".equals(string1) лучше, чем string1.equals("строка")
        String nullString = null;
        System.out.println("строка".equals(nullString)); // false
//        System.out.println(nullString.equals("строка")); // java.lang.NullPointerException
        // нужно начинать с той строки, которая задана

        System.out.println(nullString == null); // true
        System.out.println(Objects.nonNull(nullString)); // false
        System.out.println(Objects.isNull(nullString)); // true

        // дан массив animals{"кот", "пес", "гусь"}
        // создать новый массив, больше чем в 2 раза
        // заполнить значения рандомно
        String[] animals = new String[]{"кот", "пес", "гусь"};
        String[] animals2 = new String[animals.length * 2];

        for (int i = 0; i < animals2.length; i++) {
           animals2[i] = animals[(int) (Math.random() * animals.length)];
        }
        System.out.println(Arrays.toString(animals2));

        // конкатенация строк
        string1 = "Java";
        string2 = "Python";

        // 1 вариант: +
        System.out.println(string1 + " :: " + string2);
        // 2 вариант: concat()
        String concatStr = string1.concat(" :: ").concat(string2);
        // 3 вариант: String.join(разделитель, строка1, .. , строкаN)
        concatStr = String.join(" :: ", string1, string2);

        // буферизированные строки
        //concatStr = "";
        //for (int i = 0; i < 10; i++) {
        //    concatStr += i + " ";
        //}
        // нельзя, тк будут создаваться новые объекты

        // вместо либо StringBuilder (работает быстрее) , но не является потокобезопасным
        // либо StringBuffer (работает медленнее), но потокобезопасен
        StringBuilder sb = new StringBuilder(string1);
        sb.append(" :: ").append(string2);
        System.out.println(sb.toString());

        concatStr = "";
        sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i).append(" ");
        }
        concatStr = sb.toString();
        System.out.println(concatStr);

        // сравнение строк
        System.out.println("строка".compareTo("строка")); // 0
        System.out.println("строка".compareTo("Строка")); // 32 первое больше (разница между номерами символа юникода)
        System.out.println("Строка".compareTo("строка")); // -32 первое меньше
        System.out.println("строка".compareToIgnoreCase("Строка")); // 0

        // start / end, результат boolean. регистр важен
        string1 = "JJD";
        System.out.println(string1.startsWith("JJ"));
        System.out.println(string1.startsWith("D", 2)); // работает со сдвигом
        System.out.println(string1.endsWith("JD"));

        // приведение к регистру, все символы, создание новой строки
        string1 = string1.toLowerCase(); // верхний регистр
        string1 = string1.toUpperCase(); // нижний регистр

        // замена
        // результат строка
        string1 = string1.replace("J", "!"); // принимает строку
        System.out.println(string1);
        string1 = string1.replaceAll("J", "!"); // принимает регулярное выражение, заменяет все
        System.out.println(string1);
        string1 = string1.replaceFirst("J", "!"); // принимает регулярное выражение, заменяет первое
        System.out.println(string1);

        // содержится ли в строке, результат boolean
        System.out.println(string1.contains("D"));

        // по разделителю делит на массив строк
        string1 = "Java Python PHP";
        String[] strings = string1.split(" "); // принимает регулярное выражение, возвращает массив
        System.out.println(Arrays.toString(strings));

        // убрать пробел trim / strip / stripLeading / stripTrailing
        System.out.println(string1.trim()); //"\u3000" "  "; "\u0020" " "
        // trim убирает пространство меньше или равно "\u0020"
        // strip (J11) убирает любое пространство
        // stripLeading (J11) убирает любое пространство (начало строки)
        // stripTrailing (J11) убирает любое пространство (конец строки)

        // форматированные строки
        System.out.printf("строка '%s'\n", "qwe   ".trim());
        System.out.printf("строка '%f'\n", 11.6);
        System.out.printf("строка '%d'\n", 566);
    }
}
