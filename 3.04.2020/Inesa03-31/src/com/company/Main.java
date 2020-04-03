package com.company;

public class Main {

    public static void main(String[] args) {
      /*  Object o = new Object()
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println();

            }
        });

        System.out.print("Объект потока создан: ");
        System.out.println(t.getState());
        t.start();
        System.out.print("Поток запущен: ");
        System.out.println(t.getState());
        t.interrupt();
        System.out.print("Поток приостановлен: ");
        System.out.println(t.getState());
        */

      Lambda l = new Lambda();
    // без использования лямбда выражений
        l.setOnWorkListener(new Lambda.doSomething() { //ctrl =+ пробел
            @Override
            public void doWork(String name) {
                System.out.println(name);
            }
        });
        // с использованием лямбда выражений

        l.setOnWorkListener((String s) ->{ // this - указатель на main
            System.out.println(s);

        });

    }
}
