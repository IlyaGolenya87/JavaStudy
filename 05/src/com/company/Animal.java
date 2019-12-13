package com.company;

public class Animal {
    public float weight;
    public String color;
    private float height;
    protected int age;

    public void eat (){
        System.out.println("Animal is eating");
    }

    //Перегрузка метода sleep

    public void sleep (){
        System.out.println("Animal is sleeping");
    }

    public void sleep (int hours){
        System.out.print("Animal is sleeping ");
        System.out.print(hours);
        System.out.println(" hours");

    }

    public void sleep (int h, int m){
        System.out.print("Animal is sleeping ");
        System.out.print(h);
        System.out.print(" hours and ");
        System.out.print(m);
        System.out.println(" minutes");

    }

}
