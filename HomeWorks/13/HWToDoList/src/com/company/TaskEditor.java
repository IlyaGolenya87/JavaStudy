package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.company.ToDoList.mainList;
import static com.company.ToDoList.saveInFile;

public class TaskEditor {
    Scanner scanner = new Scanner(System.in);
    private int changeTask;     //Переменная хранит номер задачи из списка на выбранную пользователем дату

    public void showEditList(ArrayList<Task> editList, ArrayList<Integer> indexes) {
        if (editList.isEmpty()) {
            System.out.println("There is no any tasks on this day\n");
        } else {
            for (Task task : editList) {
                System.out.printf("%d. ", editList.indexOf(task) + 1);
                System.out.print(task.getDescription());
                System.out.print(" Status - ");
                System.out.println(task.getStatus());
            }

            while (true) {
                System.out.println("Enter the number of task to edit it");      //Если на эту дату есть задачи - просим пользователя выбрать какую редактировать
                changeTask = scanner.nextInt() - 1;
                if (changeTask > editList.size() - 1) {
                    System.out.println("Error. The entered index is incorrect. Try again");
                }else {
                    break;
                }
            }
        }
    }

    public void showMenu(ArrayList<Integer> indexes, ArrayList<Task> editList) throws IOException {
        while (true) {      //Вывод меню редактирования
            System.out.printf("%d. Change description\n%d. Delete\n%d. Mark as completed\n%d. Mark as uncompleted\n%d. Cancel\n", 1, 2, 3, 4, 5);
            int changeAction = scanner.nextInt();
            scanner.nextLine();
            switch (changeAction) {
                case 1:
                    changeDescription(editList);
                    saveInFile();
                    break;
                case 2:
                    deleteTask(indexes);
                    saveInFile();
                    return;
                case 3:
                    editList.get(changeTask).setStatus(Status.COMPLETED);
                    saveInFile();
                    break;
                case 4:
                    editList.get(changeTask).setStatus(Status.UNCOMPLETED);
                    saveInFile();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Enter the correct number");
            }
            //scanner.nextLine();
        }
    }

    public void changeDescription(ArrayList<Task> editList) {
        System.out.println("Enter the new description:");
        String newDescription = scanner.nextLine();
        if (newDescription.equals(editList.get(changeTask).getDescription())) {
            System.out.println("The new description must be different!\n");
        } else {
            editList.get(changeTask).setDescription(newDescription);
        }

    }

    public void deleteTask(ArrayList<Integer> indexes) {
        System.out.println("Do you really want to delete this task? (y/n)");
        if (scanner.nextLine().equals("y") || scanner.nextLine().equals("Y")) {
            int index = indexes.get(changeTask);    //Получение индекса, удаляемого элемента из коллекции indexes
            mainList.remove(index);
            System.out.println("The task was removed successfully\n");
        }

    }
}
