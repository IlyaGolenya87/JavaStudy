package com.company;

/*//класс является абстрактным. Создать его экземпляр невозможно.
В абстрактном классе доступны "Чистые методы" т.е. метод без тела*/
public abstract class Animal {

    public String color;
    public int age;

    /*public Animal (){  //Конструктор
        color = "black";
        age = 1;
        System.out.println("Animal was created");

    }*/

    public Animal (String color, int age){

        this.color = color;  // this - указатель на текущий экземпляр объекта
        this.age = age;

    }

    public abstract void say (String voice); //абстрактный метод, присутствует в каждом наследнике и обязательно должен быть там реализован

}
