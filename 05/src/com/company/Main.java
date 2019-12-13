package com.company;

public class Main {
    /*Основные принципы ООП:
    * 1- Инкапсуляция
      2- Полиморфизм:
      -- перегрузка методов - изменение параметров, которые принимает метод;
      -- переопределение метода - изменение самого кода внутри метода (используется при наследовании)
      -- перед перегруженным методом нужно напмсать @Owerride

      3- наследование
      4- Абстракция - философия написания кода
    * */
    public static void main(String[] args) {

        Animal animal = new Animal();

        animal.weight = 15.5f;
        animal.color = "Wite";

        animal.eat();
        animal.sleep();
        animal.sleep(12);
        animal.sleep(10,15);

        System.out.println(animal.color);
        System.out.println(animal.weight);

        Animal animal1 = animal;
        animal1.color = "blue";

        System.out.println(animal.color);
        System.out.println(animal1.color);

        test(animal);
        System.out.println(animal.color);

        Dog dog = new Dog();
        dog.age = 10;
        dog.breed = "Овчарка";
        System.out.println(dog.age);
        System.out.println(dog.breed);
        dog.eat();
        dog.bark();
        dog.sleep();

        //полиморфизм
        Animal animal3 = new Dog(); //неявное преобразование

        sleeping(animal);
        sleeping(dog);
        sleeping(animal3);

    }

    public static void sleeping (Animal a){ //обобщенный метод для всех объектов типа Animal и которые наследуются от него
        a.sleep(10);
    }

    public static void test (Animal a){
        a.color = "red";
    }


}
