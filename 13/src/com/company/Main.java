package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Коллекция Set
        //Данная коллекция хранит элементы, которые не могут повторяться (регистр учитывается).
        //В случае добавления одинакового элемента ничего не происходит.
        //Как и в любой коллекции нужно указывать тип хранимых данных внутри <>.
        //Набор методов аналогичен ArrayList
        //Порядок размещения элементов случайный и может изменяться в ходе работы программы
        //Получение элементов методом get невозможно, единственный вариант - метод iterator

        /*HashSet <String> set = new HashSet<>();

        set.add("string 1");
        set.add("string 2");
        set.add("string 3");
        set.add("string 4");

        System.out.println(set);

        set.add("string 2");

        System.out.println(set);

        set.remove("string 4");

        System.out.println(set);

        //Коллекция Map
        //Хранит элементы по принципу "Ключ-значение".
        //Map - интерфейс, от которого наследуются все коллекции типа Map
        //При создании коллекции внутри <> указываются 2 типа значения: ключа и элементов
        //Ключи повторяться не могут, значения могут

        HashMap <String, Integer> map = new HashMap<>();
        map.put("Ivanov", 1000);    //Метод map для добавления элементов. Принимает ключ, а затем сам элемент
        map.put("Petrov", 2500);
        map.put("Sidorov", 500);

        System.out.println(map);

        //способы получения элементов из коллекции

        map.get("Petrov"); //по ключу

        map.keySet();   //метод возвращает коллекцию типа set, содержащую все ключи

        map.values();  //метод возрващает коллекцию типа set, содержащую все элементы

        //удаление элементов
        //По ключу либо 2 перегрузка по ключу и элементу
        map.remove("Sidorov");
        map.entrySet();
        System.out.println(map);

        //РАБОТА С ДАТАМИ

        Date d = new Date();
        System.out.println(d.getTime()); //возвращает время в мс

        Date d2 = new Date(-9999999999999999l);

        if (d.after(d2)) { //проверяет является ли дата ранее чем передаваемая в качестве аргумента
            System.out.println("d > d2");
        }


        if (d.before(d2)) { //проверяет является ли дата позднее чем передаваемая в качестве аргумента
            System.out.println("d < d2");
        }

        d.compareTo(d2); //сравнение двух дат. Возвращает -1,0,1 в зависимости от результата

        //ФОРМАТИРОВАНИЕ ДАТЫ
        SimpleDateFormat df = new SimpleDateFormat("'сегодня 'dd MMMM yyyy"); // в скобках передается паттерн, обозначающий вид представления даты (есть в интернете)
        //в одинарных кавычках можно вписывать любой текст вместе с паттерном даты

        System.out.println(df.format(d2));

        SimpleDateFormat df2 = new SimpleDateFormat("MM/dd/yyyy");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату");
        String date = sc.nextLine();

        try {
            Date d3 = df2.parse(date); //преобразование строки в дату
            System.out.println(d3.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        //CALENDAR

        GregorianCalendar calendar = new GregorianCalendar(); //по умолчанию при создании объекта ему присваивается начальное время (1,01,1970)

        GregorianCalendar cal = (GregorianCalendar)GregorianCalendar.getInstance(); //так можно присвоить текущее время компьютера

        System.out.println(cal.get(Calendar.YEAR)); //метод при помощи которого можно получить необходимую информацию чере константы

        cal.set(Calendar.MONTH, Calendar.JULY); //метод, при помощи которого можно поменять какой либо из параметров календаря
        cal.set(Calendar.MINUTE, 25);

        System.out.println(cal);

        cal.add(Calendar.DAY_OF_MONTH, 28); //прибавление к дате (либо вычитание, если указать отрицательное число)
        System.out.println(cal);

        cal.roll(Calendar.DAY_OF_MONTH, 30); //метод добавляет к указанному параметру, но не меняя остальные параметры

        cal.getTime(); //преобразовывает объект в формат даты

    }

}
