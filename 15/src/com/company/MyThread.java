package com.company;

public class MyThread extends Thread {
    //Переопределение run на уровне класса


    @Override
    public void run() {
        for (int i = 5000000; i < 10000000; i++){
            double x = Math.atan2(1553.34,655435.15) * Math.sqrt(156843.125364153) / Math.hypot(15355.23, 563531.8);
        }
    }
}
