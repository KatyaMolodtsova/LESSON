package com.ifmo.jjd.lesson16;

import java.lang.ref.WeakReference;
import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        User cbf = new User("cbf", "12443", Role.USER);
        User asd = new User("asd", "2625", Role.ADMIN);
        User rty = new User("rty", "8734", Role.USER);
        User bnm = new User("bnm", "2688", Role.ADMIN);

        //  особенности
        // 1. ключи уникальны
        // 2. каждому ключу соответствует одно значение
        // 3. не являются коллекциями

        // наиболее популярные HashMap<K, V> и TreeMap<K, V>

        // особенности HashMap:
        // 1. хранит ключи в hash таблице (на основе hash кода)
        // 2. обладает хорошей производительностью
        // 3. в качестве ключа можно использовать null
        // 4. порядок хранения элементов может отличаться от порядка добавления

        // в <> сначала указывается тип данных ключей, затем тип данных значений
        HashMap<String, User> userHashMap = new HashMap<>();

        // добавление элементов
        userHashMap.put(asd.getLogin(), asd);
        userHashMap.put(cbf.getLogin(), cbf);
        userHashMap.put(rty.getLogin(), rty);
        userHashMap.put(null, null);

        System.out.println(userHashMap);

        // удаление
        userHashMap.remove("asd");
        userHashMap.remove("rty", cbf);

        // замена
        userHashMap.replace("try", null);
        userHashMap.replace("try", null, rty);

        // получение по ключу
        System.out.println(userHashMap.get("rty"));
        System.out.println(userHashMap.getOrDefault("uuu", cbf));

        // метод проверки, содержится или нет
        System.out.println(userHashMap.containsKey("uuu"));
        System.out.println(userHashMap.containsValue(cbf));

        // перебор map
        for (Map.Entry<String, User> pair: userHashMap.entrySet()){ // класс Map, тип данных Entry
            System.out.println("ключ: " + pair.getKey()); // переборо значений entrySet()
            System.out.println("значение: " + pair.getValue());
        }

        // особенности EnumMap
        // 1. использует перечисления в качестве ключей
        // 2. нельзя использовать null в качестве ключа
        // 3. все ключи должны быть одного типа перечисления
        // 4. все значение содержит в массиве (размер массива - количество элементов перечисления)
        // 5. порядок хранения элементов соответствует порядку элементов enum
        // 6. для извлечения значений использует индекс ключа: vals[key.ordinal()]

        // при создании объекта в конструктор необходимо передать ссылку на класс перечисления
        EnumMap<Role, ArrayList<User>> enumMap = new EnumMap<>(Role.class);// список, который хранит элементы типа User
        // Arrays.asList(cbf, rty) формирование списка из объектов, вернет List с obj1 И obj2
        enumMap.put(Role.USER, new ArrayList<>(Arrays.asList(cbf, rty)));
        enumMap.put(Role.ADMIN, new ArrayList<>(Arrays.asList(asd, bnm)));

        // получение по ключу
        System.out.println(enumMap.get(Role.USER)); // получим ArrayList, список всех пользователей

        // вывести в консоль логины всех пользователей с ролью admin
        for (User user: enumMap.get(Role.ADMIN)){
            System.out.println(user.getLogin());
        }

        User newUser = new User("newUser", "111", Role.USER);
        // добавить объект в enumMap, учитывая, что роль объекта может быть неизвеста
        enumMap.get(newUser.getRole()).add(newUser);

        User someUser = new User("some", "9090", Role.USER); // сильная ссылка
        WeakReference<User> weakUser = new WeakReference<>(someUser); // слабая ссылка
        // если остались только слабые ссылки и памяти мало, то сборщик мусора может удалить это из памяти
        someUser = null; // ссылки больше нет

        // WeakHashMap основанная на слабых ссылках
        WeakHashMap<Object, String> weakMap = new WeakHashMap<>();
        Object weakKey = new Object();
        String weakVal = "String";
        weakMap.put(weakKey, weakVal);

        System.out.println(weakMap);
        System.out.println(weakMap.size());

        weakKey = null; // обнуление ссылок
        weakVal = null;
        System.gc();

        System.out.println(weakMap);
        System.out.println(weakMap.size());

        // особенности TreeMap
        // 1. хранит элементы в отсортированном по ключам порядке
        // 2. основан на красно-черном дереве
        // 3. null нельзя использовать в качестве ключей
        // 4. класс, объекты которого будут использоватся в качестве ключей должен реализовывать
        // интерфейс Comparator или в конструктор map необходимо передать Comparator

        userHashMap.remove(null);

        TreeMap<String, User> userTreeMap = new TreeMap<>(userHashMap);
        userTreeMap.put("asd", asd);


    }
}