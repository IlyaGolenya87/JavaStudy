package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.add(7);
        linkedList.add(10);
        linkedList.add(-1);
        linkedList.add(20);

        linkedList.print();

        System.out.println(linkedList.get(10));
        System.out.println(linkedList.get(4));
        System.out.println(linkedList.get(2));

        linkedList.remove(2);
        linkedList.print();

        linkedList.remove(-1);
        linkedList.print();

        linkedList.add(60);
        linkedList.print();


    }
}



