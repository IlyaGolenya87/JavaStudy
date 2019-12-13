package com.company;

//наследование класса Dog от класса Animal
//наследуются свойства или методы, с модификатором public
//private не наследуется
//protected наследуется и доступен в пределах иерархии классов
public class Dog extends Animal{

    public String breed; //порода

    public void bark (){

        System.out.println("Гав!");

    }

    @Override
    public void sleep (){
        // если нужно внутри метода добавить код не меняя родительский можно делать так:
        super.eat();  // указатель на объект родителя, позволяет обращаться к любому свойству или методу объекта родителя
        //т.о можно не копировать код из родительского метода
        System.out.println("Dog isn't hungry anymore");
        super.sleep(); //можно вкинуть код из другого метода родительского класса
    }

    @Override
    public void sleep (int hours){
        System.out.print("Dog is sleeping ");
        System.out.print(hours);
        System.out.println(" hours");

    }

    @Override
    public void sleep (int h, int m){
        System.out.print("Dog is sleeping ");
        System.out.print(h);
        System.out.print(" hours and ");
        System.out.print(m);
        System.out.println(" minutes");

    }

    @Override
    public void eat (){
        System.out.println("Dog is eating");
    }



}
