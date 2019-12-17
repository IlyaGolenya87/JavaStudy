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
            System.out.println("Your americano is ready");
            System.out.println("Take the glass with coffee");
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
            System.out.println("Your espresso is ready");
            System.out.println("Take the glass with coffee");
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
            System.out.println("Your double espresso is ready");
            System.out.println("Take the glass with coffee");
        }
    }

    public void pourWater(){
        if (water == fullWater){
            System.out.println("The container with water is already full");
        }else {
            water = fullWater;
            System.out.println("The container with water is filled successfully");
        }
    }

    public void pourCofee() {
        if (coffee == fullCoffee) {
            System.out.println("The container with coffee is already full");
        } else {
            coffee = fullCoffee;
            System.out.println("The container with coffee is filled successfully");
        }
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
