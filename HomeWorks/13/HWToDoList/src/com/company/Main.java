package com.company;

import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();
        System.out.println("\nWelcome to the \"To do list\" application!\n");

        try {
            toDoList.start();
        } catch (IOException e) {
            System.out.println("Error of reading from file");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        while (true) {
            System.out.println("Main menu:");
            System.out.printf("%d. Add new task\n%d. Choose the task\n" +
                    "%d. Show to do list\n%d. Complete the work\n", 1, 2, 3, 4);
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        toDoList.addTask();
                        ToDoList.saveInFile();
                        break;
                    case 2:
                        toDoList.editTask();
                        ToDoList.saveInFile();
                        break;
                    case 3:
                        toDoList.showList();
                        break;
                    case 4:
                        ToDoList.saveInFile();
                        return;
                    default:
                        System.out.println("Enter the number from 1 to 4 ");
                        System.out.println("");
                }

            } catch (InputMismatchException e) {
                System.out.println("ERROR! Enter the number from 1 to 4. Try again");
                System.out.println("");
                scanner.nextLine();
                //scanner.nextLine();
            } catch (ParseException e) {
                System.out.println("The entered date is incorrect. Try again");
                System.out.println("");
            } catch (IOException e) {
                System.out.println("Error of writing to file");
            } /*catch(IndexOutOfBoundsException e) {
            System.out.println("The entered index is incorrect. Try again");
        }*/

    }
}
}
