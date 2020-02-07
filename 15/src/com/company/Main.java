package com.company;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        //МНОГОПОТОЧНОСТЬ

        long temp = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++){
            double x = Math.atan2(1553.34,655435.15) * Math.sqrt(156843.125364153) / Math.hypot(15355.23, 563531.8);
        }
        System.out.println(System.currentTimeMillis() - temp);

        //создаем отдельный поток
        //если поведение потоков должно быть разным - переопределение метод run на уровне объекта
        //если потоки делают одно и то же - можно переопределять run на уровне класса


        Thread t1 = new Thread(new Runnable() {     //Переопределение метода на уровне объекта без использования класса
            @Override
            public void run() {
                for (int i = 0; i < 5000000; i++){
                    double x = Math.atan2(1553.34,655435.15) * Math.sqrt(156843.125364153) / Math.hypot(15355.23, 563531.8);
                }
            }
        });

        MyThread t2 = new MyThread();

        long temp1 = System.currentTimeMillis();
        t1.start();
        t2.start();

        try {
            t1.join(); //нужно для того, чтобы основной процесс (выполнение команды main) не завершился раньше чем завершатся потоки.
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - temp1);


        //ОБА ПОТОКА РАБОТАЮТ С ОДНОЙ ПЕРЕМЕННОЙ
        //это приводит к искажению результата
        //чтобы избежать этого нужно синхронизировать потоки

        MyClass m = new MyClass();
        Thread tt1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    m.calc(1);
                    m.calc2(1, "A");
                }
            }
        });

        Thread tt2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    m.calc(-1);
                    m.calc2(-1, "B");
                }
            }
        });

        tt1.start();
        tt2.start();

        try {
            tt1.join();
            tt2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(m.value);
        System.out.println(m.value2);





    }

}
