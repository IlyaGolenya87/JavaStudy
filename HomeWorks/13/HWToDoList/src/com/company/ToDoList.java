package com.company;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ToDoList implements ToDoListImpl {
    Scanner scanner = new Scanner(System.in);
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    ArrayList<Task> list = new ArrayList<>();       //Коллекция, в которой будут храниться все задачи


    public void start() throws IOException, ParseException {
        File save = new File("SaveList.txt");
        if (save.exists()) {
            FileReader reader = new FileReader("SaveList.txt");
            int c = reader.read();
            if (c != -1) {
                this.loadFromFile();
            }
        } else {
            //System.out.println("Нет файла");
            save.createNewFile();
        }
    }

    public void addTask() throws ParseException {
        ArrayList<Task> currentList = new ArrayList<>();   //Коллекция будет хранить задачи на выбранную дату, для проверки наличия одинаковых заданий
        System.out.println("Enter the date in the format day/month/year");
        Date date = df.parse(scanner.nextLine());
        System.out.println("Enter the description of your task");
        String descr = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {     //При помощи цикла ищем задачи на дату, введенную пользователем
            if (list.get(i).getDate().equals(date)) {
                currentList.add(list.get(i));
            }
        }
        if (!currentList.isEmpty()) {
            for (int i = 0; i < currentList.size(); i++) {
                if (list.get(i).getDescription().equals(descr)) {
                    System.out.println("The task is already exists\n");
                    return;
                }
            }
        }
        Task task = new Task(descr, date);
        list.add(task);
    }

    public void editTask() throws ParseException {
        //scanner.nextLine();       //КОСЯК СО СКАНЕРОМ!!!
        System.out.println("Enter the date in the format day/month/year");
        Date date = df.parse(scanner.nextLine());       //Принимаем пользовательскую дату
        ArrayList<Task> editList = new ArrayList<>();   //Коллекция будет хранить задачи на выбранную дату, для редактирования
        ArrayList<Integer> indexes = new ArrayList<>();   //Коллекция будет хранить индексы элементов в коллекции list, которые пользователь выбрал для редактирования
        for (int i = 0; i < list.size(); i++) {     //При помощи цикла ищем задачи на дату, введенную пользователем
            if (list.get(i).getDate().equals(date)) {
                editList.add(list.get(i));
                indexes.add(i);
            }
        }
        if (editList.isEmpty()) {
            System.out.println("There is no any tasks on this day\n");
            return;
        } else {
            for (int i = 0; i < editList.size(); i++) {
                System.out.printf("%d. ", i + 1);
                System.out.print(editList.get(i).getDescription());
                System.out.print(" Status - ");
                System.out.println(editList.get(i).getStatus());
            }
            System.out.println("Enter the number of task to edit it");      //Если на эту дату есть задачи - просим пользователя выбрать какую редактировать
        }
        int changeTask = scanner.nextInt();     //Переменная хранит номер задачи, которую выбрал пользователь для редактирования

        while (true) {      //Вывод меню редактирования
            System.out.printf("%d. Change description\n%d. Delete\n%d. Mark as completed\n%d. Mark as uncompleted\n%d. Cancel\n", 1, 2, 3, 4, 5);
            int changeAction = scanner.nextInt();
            scanner.nextLine();
            switch (changeAction) {
                case 1:
                    System.out.println("Enter the new description:");
                    String newDescr = scanner.nextLine();
                    if (newDescr.equals(editList.get(changeTask - 1).getDescription())) {
                        System.out.println("The new description must be different!\n");
                    } else {
                        editList.get(changeTask - 1).setDescription(newDescr);
                    }
                    break;
                case 2:
                    System.out.println("Do you really want to delete this task? (y/n)");
                    if (scanner.nextLine().equals("y")) {
                        int index = indexes.get(changeTask - 1);    //Получение индекса, удаляемого элемента из коллекции indexes
                        list.remove(index);
                        System.out.println("The task was removed successfully\n");
                    }
                    return;
                case 3:
                    editList.get(changeTask - 1).setStatus(status.COMPLETED);
                    return;
                case 4:
                    editList.get(changeTask - 1).setStatus(status.UNCOMPLETED);
                    return;
                case 5:
                    return;
            }
            //scanner.nextLine();
        }
    }

    public void showList() {
        if (list.isEmpty()) {
            System.out.println("The to do list is empty\n");
            return;
        }
        while (true) {
            System.out.printf("%d. On today\n%d. On this week\n%d. On the specified date\n%d. Show full to do list\n%d. Back\n", 1, 2, 3, 4, 5);
            int changeAction = scanner.nextInt();
            scanner.nextLine();
            switch (changeAction) {     //НУЖНО ДОПИСАТЬ ДЛЯ ПП. 1,2,3,5
                case 4:
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(df.format(list.get(i).getDate()));
                        System.out.print(list.get(i).getDescription());
                        System.out.print("\nStatus - ");
                        System.out.println(list.get(i).getStatus());
                        System.out.println("");
                    }
                    return;
            }
        }
    }

    public void saveInFile() throws IOException {
        FileWriter fileWriter = new FileWriter("SaveList.txt");
        for (int i = 0; i < list.size(); i++) {
            fileWriter.write(df.format(list.get(i).getDate()));
            fileWriter.write((char) 174);
            fileWriter.write(list.get(i).getDescription());
            fileWriter.write((char) 174);
            fileWriter.write(list.get(i).getStatus());
            fileWriter.write((char) 174);
        }
        fileWriter.close();

    }


    public void loadFromFile() throws IOException, ParseException {
        FileReader fileReader = new FileReader("SaveList.txt");
        String fromSaveList = "";     //переменная для сохранения содержимого из сэйв-файла
        int c = fileReader.read(); //возвращает значение -1 когда метод завершается, т.е. файл прочитан
        while (c != -1) {        //чтение содержимого файла и запись в переменную fromSaveList
            fromSaveList = fromSaveList + (char) c;
            c = fileReader.read();
        }
        fileReader.close();

        String[] chunks = fromSaveList.split(String.valueOf((char) 174));       //массив содержит строки с параметрами задач, полученные из файла fromSaveList
        for (int i = 0; i < chunks.length; i += 3) {       //передача строк из массива chunks в конструктор Task и добавление полученных задач в основную коллекцию
            Task task = new Task(df.parse(chunks[i]), chunks[i + 1], chunks[i + 2]);
            list.add(task);
        }
    }

}
