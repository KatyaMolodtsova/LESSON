public class Lesson1 {
    //    //
    /**/

    public static void main(String[] args) {
//        System.out.println("Hello World!");

        //примитивные типы данных
        //ссылочные типы данных

        //объявление переменных, в имя закладывать смысл, в любом месте кода
        //тип_данных имя_переменной;

        byte byteVar;

        byteVar = 35; //присвоили значение
        byteVar = 12; //переопределили значение

        byte byteVar2 = 10;

        byte byteVar3, byteVar4;
        byte byteVar5 = 12, byteVar6 = 22;

        short shortVar = -155;

        int intVar = 6750;
        int intVar2 = 1_000_000; //не влияет на код
        int intVar3 = 1000000;

        long longVar = 3_000_000_000L; //добавление L, когда запись воспринимается как int

        float floatVar = 15.56f;

        double doubleVar = 78.9;

        boolean trueVar = true;
        boolean falseVar = false;

        //автоматическое приведение типов
        byte someByte = 100;
        int someInt = someByte;

        //явное приведение типов
        someInt = 200;
        someByte = (byte) someInt; //непредсказуемое поведение

        //операторы

        //операторы присваивания
        // = | += | -= | *= | /= | %=
        someByte = 3;
//        someByte = someByte * 7;
        someByte *= 7;

        someInt = 10;
        someInt = someInt + 20;
        someInt += 20;


        //арифметические операторы
        // + | - | * | / | %
        int a = 33;
        int b = 77;

        short x = 56, y = 77;
        int res = x + y;//или long
        short z = (short) (x + y);//автоматически приводит к int

        //деление на 0
        int n = 100;
        double m = 200.6;

//        int zeroDiv = n / 0; //невозможно
//        System.out.println(zeroDiv);

        double zeroDiv2 = m / 0;
//        System.out.println(zeroDiv2);

        //операторы сравнения
        // < | > | <= | >= | != | ==

        //тернарный оператор
        //переменная = (условие) ? выражение_1 : выражение_2;
        int k = 4, l = 8;
        int result = (k < l) ? k + l : k - l;
//        System.out.println(result);

        int perem = 11;
        int ost = perem % 2;
        result = (ost == 0) ? perem / 2 : perem * 2;
//        System.out.println(result);

        int h = 2, p = 2;
        h = h++;
        p = ++p;
        System.out.println(h);
        System.out.println(p);

        //описание процесса
        //зачем нужна виртуальая машина
        //что включает в себя JDK
        //что включает JRE
        //чем отличаются друг от друга
        //последовательность наполнения программы
        //примитивные типы
        //приведение типов, явное и не явное
        //операторы
    }
}
