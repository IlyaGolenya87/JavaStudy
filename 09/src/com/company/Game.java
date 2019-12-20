package com.company;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private int number;
    private int nCount;

    public Game(){
        //Генерация случайных чисел
        //1 способ
        /*double r = Math.random(); //r(0;1)*/

        //2 способ
        Random rand = new Random();
        this.number = rand.nextInt(100)+1;

    }

    public void start (){
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Enter the number");
            int user;

            //Пытаемся поймать исключение, если пользователь ввел не int
            try {
                user = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Enter the correct number");
                sc = new Scanner(System.in); // в случае исключения сканер переинициализируется
                continue;
            }

            this.nCount++;

            if (this.number == user){
                System.out.println("Congratulation!!!");
                System.out.print("You guessed the number with ");
                System.out.print(this.nCount);
                System.out.print(" attempts!");
                break;
            }

            if (this.number > user){
                System.out.println("Guessed number is bigger!");
            }

            if (this.number < user){
                System.out.println("Guessed number is less!");
            }

        }
    }


}
