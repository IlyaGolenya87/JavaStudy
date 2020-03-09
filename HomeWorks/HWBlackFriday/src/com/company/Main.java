package com.company;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class Main {

    public static void main(String[] args) {


        ArrayList <Buyer> queue = new ArrayList<>();

        SynchronousQueue


        for (int i = 0; i < 100; i++) {
            Buyer buyer = new Buyer(i);
            queue.add(buyer);
        }

        System.out.println(queue.size());
        System.out.println(queue.get(10).getToken());


    }
}
