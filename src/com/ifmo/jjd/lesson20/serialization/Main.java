package com.ifmo.jjd.lesson20.serialization;

import java.io.*;

public class Main  {
    public static void main(String[] args) {

        Pupil pupil1 = new Pupil();
        pupil1.setAge(7);
        pupil1.setName("pupil1");
        pupil1.setGroup(new Group("Химия", 12));
        pupil1.learn();

        Pupil pupil2 = new Pupil();
        pupil2.setAge(8);
        pupil2.setName("pupil2");
        pupil2.setGroup(new Group("Биология", 22));
        pupil2.learn();

        Director director = new Director("Super Speech");
        director.setAge(44);
        director.setName("director");
        director.setRating(2);

        System.out.println(pupil1);
        System.out.println(pupil2);
        System.out.println(director);

        File file = new File("school.bin");
        objectToFile(file, pupil1);

        // запись pupil2
        objectToFile(file, pupil2);

        Pupil pupilFromFile1 = (Pupil) objectFromFile(file);
        System.out.println(pupilFromFile1);
        System.out.println(pupil1.equals(pupilFromFile1));

        Pupil pupilFromFile2 = (Pupil) objectFromFile(file);
        System.out.println(pupilFromFile2);
        System.out.println(pupil2.equals(pupilFromFile2));


        // сериализация - объект, как последовательность байт
        // ObjectOutputStream
        // десериализация - последовательность байт в объект (получаем на выходе Object)
        // ObjectInputStream
        // ObjectOutputStream и ObjectInputStream - декораторы, соответственно
        // в конструктор ObjectOutputStream передается OutputStream
        // в конструктор ObjectInputStream передается InputStream

        // объект -> последовательность байт -> файл
        // файл -> последовательность байт ->объект

        // классы должны имплементировать интерфейс java.io.Serializable (интерфейс-маркер)
        // по умолчанию сериализуются все поля, есть возможность исключить поля из процесса сериализации
        // исключать прямо в классе, при описании
        // если у интерфейса нет методов, то интерфейс называется маркерным
        // если интрефейс есть, то делаем, если нет, то не делаем
        // если имплементация Serializable будет у дочернего класса, то полученные от родителя свойства
        // не участвуют в сериализации
        // при десериализации получатся значения по умолчанию по этим полям
        // если имплементация Serializable будет у родителя, то все его потомки будут Serializable классами
        // свойства, отмеченные transient не участвуют в сериализации

        // или java.io.Externalizable
        // по умолчанию не сериализуется ни одно поле, есть возможность указать, какие поля должны участвовать
        // в процессе сериализации
        // либо один, либо второй
        // если не соблюдается условие, то позникнет exception

        // что сохраняется: сам класс, родители, поля (строится граф объектов), версия класса

    }

    private static void objectToFile(File file, Object object){
        try (FileOutputStream fileStream = new FileOutputStream(file, true);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileStream)){ // сериализация
            objectOutput.writeObject(object); // запись в файл объекта
        } catch (FileNotFoundException e){
            System.out.println("FileNotFoundException");
        } catch (IOException io){
            System.out.println("IOException");
        }
    }

    // чтобы избежать кастования можно использовать дженерик класс
    //class Some<T>{
    //    public void write(T o){
    //
    //    }
    //    public T read(){
    //        return null;
    //    }
    //}
    private static Object objectFromFile(File file){
        Object o = null;
        try (FileInputStream fileInput = new FileInputStream(file); // чтение из файла
        ObjectInputStream objectInput = new ObjectInputStream(fileInput)){ // десериализация
            o = objectInput.readObject(); // ClassNotFoundException
        } catch (FileNotFoundException ignored){

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return o;
    }
}