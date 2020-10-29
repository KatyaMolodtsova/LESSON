package com.ifmo.jjd.lesson12.exceptions;

import com.ifmo.jjd.Lesson6.Author;

import java.io.IOException;

public class ExceptionLesson {
    public static void main(String[] args) {
        /*Error - ошибки, связанные с проблемами уровня JVM
        * Например, ошибка нехватри памяти.
        * Ошибки (все Error) не следует обрабатывать в программе */

        /* Exception - исключения. Все исключения можно предугать
        * и обработать. При этом некоторые из них разработчики
        * обязаны обработать в совей программе */

        /*Все исключения делятся на:
        * 1. Исключения времени выполнения (наследники RuntimeException)
        * unchecked / необрабатываемые / неотслеживаемые / неконтролируемые
        * Исключения данного типа можно обработать в программе, а можно
        * и не обрабатывать
        * 2. Все остальные исключения - исключения времени компиляции:
        * checked / обрабатываемые / отслеживаемые / контролируемые
        * Исключения данного типа разработчики обязаны! обработать
        * в программе
        * */
        // RuntimeExceptions:
        int a = 30;
        int b = 0;
        int res;
        // res = a / b; // java.lang.ArithmeticException

        int[] ints = new int[3];
        // ints[100] = 90; // java.lang.ArrayIndexOutOfBoundsException

        String s = null;
        // s.equals("data"); // java.lang.NullPointerException

        Object data = "123";
        // Integer integer = (Integer) data; // java.lang.ClassCastException

        // обработка исключений (checked и unchecked)
        // для обработки исключений используется try catch блок и блок finally

        try { // в блок try помещается потенциально опасный код,
            // который может привести к исключению
            res = a / b; // когда a / 0 приведет к ArithmeticException
            // управление перейдет в блок catch, остальной код в блоке try
            // выполнен не будет
        } catch (ArithmeticException e){ // перехватывает только то исключение,
            // которе указано в ().
            // В данном случае исключение типа ArithmeticException
            // ArithmeticException  - тип данных исключения
            // e - объект исключения

            // перечисляем инструкции, которые должны быть выполнены при
            // ArithmeticException
            System.out.println(e.getMessage()); // информация об исключении (сообщение)
            e.printStackTrace();

            res = 100;
        }

        System.out.println("после ArithmeticException " + res);

        // объединение catch блоков, если есть необходимость
        // обработать несколько исключений
        // 1. несколько блоков catch - позволяет обрабатывать разные
        // исключения разными способами
        try {
            if (System.currentTimeMillis() % 2 == 0) data = (Integer) data;
            else ints[100] = 90;
        } catch (ClassCastException e){ // перехватит ClassCastException
            // и всех его потомков
            System.out.println("Проблема с приведением");
        } catch (ArrayIndexOutOfBoundsException e) { // перехватит
            // ArrayIndexOutOfBoundsException и всех его потомков
            System.out.println("Проблема с массивом");
        }
        // 2. все исключения необходимо обработать одинаковым способом
        try {
            if (System.currentTimeMillis() % 2 == 0) data = (Integer) data;
            else ints[100] = 90;
        } catch (ClassCastException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Проблема с массивом или приведением");
        }
        // 3. через общего родителя
        try {
            if (System.currentTimeMillis() % 2 == 0) data = (Integer) data;
            else ints[100] = 90;
        } catch (RuntimeException e) {
            System.out.println("Проблема с чем-то в Runtime");
        }

        try {
            if (System.currentTimeMillis() % 2 == 0) data = (Integer) data;
            else ints[100] = 90;
        } catch (ClassCastException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Проблема с массивом или приведением");
        } catch (RuntimeException e) {
            System.out.println("Проблема с чем-то в Runtime");
        }
        // дополнительный блок finally
        finally {
            // код, который написан в блоке finally выполнится в случае
            // любого исключения, даже если оно не перехватывается
            // в блоке catch
            System.out.println("Закрытие ресурсов в блоке finally");
        }

        try {
            voidWithCheckedEx("file.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // переменная message объявлена в блоке {},
            // значит ее область видимости ограничена
            // данным блоком
            Message message = new Message("Т");

        } catch (ChatException e) {
            System.out.println(e.getMessage());
            try {
                throw new ChatException("in catch", e);
            } catch (Throwable e1){
                e1.getCause();
                e1.printStackTrace();
            }
        }

    }

    public static void voidWithCheckedEx(String fileName) throws IOException {
        if (fileName.endsWith("json"))
            // герегируем и выбрасываем обрабатываемое исключение
            throw new IOException("Проблема с файлом");
    }
}
