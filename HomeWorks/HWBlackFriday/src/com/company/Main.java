package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;

public class Main {


    static Queue<Buyer> queue;
    static Queue<Buyer> mainQueue;

    public static void main(String[] args) throws InterruptedException {
        mainQueue = new PriorityQueue<>();
        queue = new PriorityQueue<>();


        for (int i = 0; i < 100; i++) {
            Buyer buyer = new Buyer("Buyer" + i);
            mainQueue.add(buyer);
        }

        for (int i = 0; i < 20; i++) {
            queue.add(mainQueue.poll());
            //queue.
        }

       /* SynchronousQueue<Buyer> synchronousQueue = new SynchronousQueue<>();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable producer = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100 ; i++) {
                        synchronousQueue.put(mainQueue.poll());
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                try {
                    while (!mainQueue.isEmpty()) {
                        if (queue.size() < 20){
                            synchronousQueue.take().start();
                            System.out.println(queue.size());
                        }


                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        executor.execute(producer);
        executor.execute(consumer);*/
        //executor.awaitTermination(500, TimeUnit.MILLISECONDS);
        //executor.shutdown();


       /* System.out.println(mainQueue.size());
        System.out.println(queue.size());*/



        /*for (int i = 1; i <= 20; i++) {
            Buyer buyer = new Buyer("Buyer" + i);
            queue.add(buyer);
            buyer.start();
        }*/

        Thread seller = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!queue.isEmpty()) {
                        for (int i = 5; i > 0; i--) {
                            Thread.sleep(30);
                            queue.poll().interrupt();
                                if (!mainQueue.isEmpty()){
                                //queue.add(synchronousQueue.take());

                            } else {
                                return;
                            }
                        }
                        Thread.sleep(100);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        seller.start();


    }

}

class Buyer extends Thread implements Comparable {


    public Buyer(String name) {
        this.setName(name);
    }

    @Override
    public void run() {

        try {

            System.out.println(this.getName() + " is coming");
            sleep(5000);
            System.out.println(this.getName() + " I am going out!!! I am not happy!!!");
            Main.queue.remove(this);
            Main.queue.add(Main.mainQueue.poll());  //õç


        } catch (InterruptedException e) {
            System.out.println(this.getName() + " I am going out!!! I am happy!!!");
        }

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}


