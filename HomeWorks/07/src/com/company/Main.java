package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the brand of machine");
        System.out.println("1. Bosh");
        System.out.println("2. Siemens");
        System.out.println("3. Vitek");

        int brand = sc.nextInt();

        if (brand > 0 && brand < 4) {       // Выбор кофемашины
            switch (brand) {                // В зависимости от выбора пользователя ссылке coffeeMachine присваивается объект конкретной кофемашины
                case 1:
                    coffeeMachine = new Bosh();
                    break;
                case 2:
                    coffeeMachine = new Siemens();
                    break;
                case 3:
                    coffeeMachine = new Vitek();
                    break;
                default:
                    System.out.println("Enter 1 or 2 or 3");
                    break;
            }

            while (true) {      // Главное меню

                System.out.println("Main menu");
                System.out.println("1. Show current volume of water and coffee");
                System.out.println("2. Make Americano");
                System.out.println("3. Make Espresso");
                System.out.println("4. Make Double Espresso");
                System.out.println("5. To fill the container of water");
                System.out.println("6. To fill the container of coffee");
                System.out.println("7. Information");
                System.out.println("8. Turn off the coffee machine");

                int menu = sc.nextInt();

                switch (menu) {
                    case 1:
                        float res[] = new float[2];
                        res = coffeeMachine.showRes();
                        System.out.print("Volume of water is ");
                        System.out.print(res[1]);
                        System.out.println(" l");
                        System.out.print("Volume of coffee is ");
                        System.out.print(res[0]);
                        System.out.println(" g");
                        break;
                    case 2:
                        coffeeMachine.americano();
                        break;
                    case 3:
                        coffeeMachine.espresso();
                        break;
                    case 4:
                        coffeeMachine.doubleEspresso();
                        break;
                    case 5:
                        coffeeMachine.pourWater();
                        break;
                    case 6:
                        coffeeMachine.pourCofee();
                        break;
                    case 7:
                        coffeeMachine.info();
                        break;
                    case 8:
                        coffeeMachine.finish();
                        return;

                }

            }

        }
        System.out.println("Enter correct number ");
    }
}

