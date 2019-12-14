package com.company;

public abstract class CoffeeMachine implements CoffeeMachineImpl {
    String brand;
    float fullCoffee;
    float fullWater;
    float coffee;
    float water;

    public float[] showRes() {

        return new float[]{coffee, water};

    }

    public void americano() {
        if (coffee < 11.0 || water < 0.25) {
            if (coffee < 11.0) {
                System.out.println("Fill the container of coffee");
            }
            if (water < 0.25) {
                System.out.println("Fill the container of water");
            }
        }else {
            coffee -= 11.0;
            water -= 0.25;
            System.out.println("Your coffee is ready");
        }
    }

    public void espresso() {
        if (coffee < 7.0 || water < 0.035) {
            if (coffee < 7.0) {
                System.out.println("Fill the container of coffee");
            }
            if (water < 0.035) {
                System.out.println("Fill the container of water");
            }
        }else {
            coffee -= 7.0;
            water -= 0.035;
            System.out.println("Your coffee is ready");
        }
    }

    public void doubleEspresso() {
        if (coffee < 14.0 || water < 0.07) {
            if (coffee < 14.0) {
                System.out.println("Fill the container of coffee");
            }
            if (water < 0.07) {
                System.out.println("Fill the container of water");
            }
        }else {
            coffee -= 14.0;
            water -= 0.07;
            System.out.println("Your coffee is ready");
        }
    }

    public void pourWater(){
        water = fullWater;
        System.out.println("The container of water is full");
    }

    public void pourCofee(){
        coffee = fullCoffee;
        System.out.println("The container of coffee is full");
    }

    public void info (){
        System.out.println(brand);
        System.out.print("The volume of container with water is ");
        System.out.print(fullWater);
        System.out.println(" l");
        System.out.print("The volume of container with coffee is ");
        System.out.print(fullCoffee);
        System.out.println(" g");
    }

    public void finish (){
        System.out.println("Goodbye! :)");
    }

}
