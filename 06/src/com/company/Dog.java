package com.company;

public class Dog extends Animal {
    /*если класс наследуется от другого класса, в котором используется недефолтный конструктор,
    то у класса наследника нужно вызывать родительский конструктор при помощи super()
    super() должен быть в самом начале конструктора*/

    public String name;
    public static int footCount; //свойство static привязывает поле не к каждому объекту, а к классу, при этом она общая для всех объектов данного класса
    // Память для статического поля выделяется отдельно от объектов. Это свойство записывается в память один раз, но доступ к нему емеют все объекты данного класса

    public Dog (){
        super("red", 7); //вызов родительского конструктора

    }

    public Dog (String color, int age, String name){
        super(color, age); //вызов раодительского конструктора
        this.name = name;
        Cat cat = new Cat();
    }

    public void say (String voice){ //реализация родительского абстрактного метода "say"
        System.out.println(voice);
    }

    //внутри public классов можно создать private класс, называется внутренний (или inner) класс
    public static class Cat { // для того, чтобы класс был доступен извне необходимо писать слово static
        public String name;

        Cat (){

            this.name = "Tom"; //name относится к классу Cat
            name = "Billy"; //name относится к классу Dog

        }

    }

    private class Mouse {
        Mouse (){

        }
    }


    public static void bark (String name) {   // для статического метода недоступны свойства класса
        // слово this недоступно, т.к. метод существует сам по себе независимо от класса

        System.out.println("bark");

        sleep();
    }
    // из статического метода можно вызвать только другие статические методы данного класса.
    //динамические методы данного класса недоступны внутри статического класса
    public static void sleep() {
        System.out.println("z-z-z-z-z-z");
    }
}
