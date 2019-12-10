package com.company;

public class Main {

    public static void main(String[] args) {
	/*// Конструкторы
        *//*Стадии жизни объекта:
        -конструктор
        -стадия жизни
        -сборщик мусора*//*

        Конструктор имеет вид : public Имя класса (){}*/

        //если класс является абстрактным (abstract) - создать его экземпляр невозможно

        /*Animal animal = new Animal("red",8);
        System.out.println(animal.color);
        System.out.println(animal.age);

        Animal animal1 = new Animal("white", 2);
        System.out.println(animal1.color);
        System.out.println(animal1.age);*/

        Dog dog = new Dog();
        System.out.println(dog.color);
        System.out.println(dog.age);

        Dog dog2 = new Dog("White", 9, "Bob");
        System.out.println(dog2.color);
        System.out.println(dog2.age);
        System.out.println(dog2.name);

        dog2.say("Haw!");

        Dog.Cat cat = new Dog.Cat();

        dog.footCount = 4; //обращение к статическим полям класса должно осуществляться через название класса, а не через название объекта (хотя Java это позволяет)

        System.out.println(dog.footCount);

        System.out.println(dog2.footCount);

        Dog.bark("Haw" ); //вызов статического метода bark() также нужно осуществлять через класс, а не через объект

    }
}
