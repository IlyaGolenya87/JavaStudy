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


        try {
            System.out.println(linkedList.get(10));
        } catch (Exception e) {
            e.getMessage();
        }
        try {
            System.out.println(linkedList.get(4));
        } catch (Exception e) {
            e.getMessage();
        }
        try {
            System.out.println(linkedList.get(2));
        } catch (Exception e) {
            e.getMessage();
        }


        try {
            linkedList.remove(2);
        } catch (Exception e) {
            e.getMessage();
        }
        linkedList.print();

        try {
            linkedList.remove(-1);
        } catch (Exception e) {
            e.getMessage();
        }

        linkedList.print();

        linkedList.add(60);
        linkedList.print();


    }
}



