package com.company;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {

    //Этот класс нужен для того, чтобы передать в коллекцию users типа PriorityQueue объект данного класса,
    //что в свою очередь позволяет расставлять элементы по приоритету.
    //ниже описан метод compare, который непосредственно выполняет сравнение
    @Override
    public int compare(User u1, User u2) {

        return u1.getMoney() - u2.getMoney();
    }

}
