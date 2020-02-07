package com.company;

public class MyClass {
    public int value;
    public int value2;

    //Синхронизация на уровне метода
    public synchronized void calc(int d) {   //synchronized () приводит к тому, что любой поток, который будет
        // обращаться к методу будет становиться в очередь и дожидаться окончания работы предыдущего потока
        this.value += d;
    }

    //Можно записать так:

    /*public void calc (int d){
        synchronized (this){
            this.value += d;
        }
    }*/

    public void calc2(int d, String c) {
        System.out.print(c);
        synchronized (this) {
            this.value2 += d;

        }
    }
}
