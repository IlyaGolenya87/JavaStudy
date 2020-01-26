package com.company;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ToDoList implements ToDoListImpl {
    Scanner scanner = new Scanner(System.in);
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    static ArrayList<Task> mainList = new ArrayList<>();       //Коллекция, в которой будут храниться все задачи
    Date todayDate = new Date();

    public void start() throws IOException, ParseException {
        File save = new File("SaveList.txt");
        if (save.exists()) {
            FileReader reader = new FileReader("SaveList.txt");
            int c = reader.read();
            if (c != -1) {
                loadFromFile();
            }
        } else {
            //System.out.println("Нет файла");
            save.createNewFile();
        }
    }

    public void addTask() throws ParseException, IOException {
        System.out.println("Enter the date in the format day/month/year");
        String userDate = scanner.nextLine();       //Принимаем пользовательскую дату
        String today = dateFormat.format(todayDate);
        if (dateFormat.parse(userDate).before(dateFormat.parse(today))){
            System.out.println("You cannot add a task with a past date\n");
            return;
        }
        String description = "";
        do {
            System.out.println("Enter the description of your task");
            description = scanner.nextLine();
            if (description.equals("")) {
                System.out.println("You cannot add a task without description\n");
            }
        } while (description.equals(""));       //цикл не позволяет создать задачу без описания

        for (Task task : mainList) {     //Проверяем наличие ранее добавленных задач с таким же описанием
            if (task.getDate().equals(dateFormat.parse(userDate))) {
                if (task.getDescription().equals(description)) {
                    System.out.println("The task is already exists\n");
                    return;
                }
            }
        }
        Task task = new Task(description, dateFormat.parse(userDate));
        mainList.add(task);
    }

    public void editTask() throws ParseException, IOException, IndexOutOfBoundsException {
        ArrayList<Task> editList = new ArrayList<>();   //Коллекция хранит задачи для редактирования на выбранную пользователем дату.
        ArrayList<Integer> indexes = new ArrayList<>();   //Коллекция хранит индексы элементов в коллекции MAIN_LIST, которые пользователь выбрал для редактирования
        System.out.println("Enter the date in the format day/month/year");
        Date userDate = dateFormat.parse(scanner.nextLine());       //Принимаем пользовательскую дату
        TaskEditor taskEditor = new TaskEditor();
        for (Task task : mainList) {     //При помощи цикла ищем задачи на дату, введенную пользователем и добавляем в колекцию для редактирования, а ее индекс в коллекцию индексов
            if (task.getDate().equals(userDate)) {
                editList.add(task);
                indexes.add(mainList.indexOf(task));
            }
        }
        taskEditor.showEditList(editList, indexes);
        taskEditor.showMenu(indexes, editList);
    }

    public void showList() throws ParseException {
        if (mainList.isEmpty()) {
            System.out.println("The to do list is empty\n");
            return;
        }
        while (true) {
            System.out.printf("%d. On today\n%d. On this week\n%d. On the specified date\n%d. Show full to do list\n" +
                    "%d. Back\n", 1, 2, 3, 4, 5);
            int changeAction = scanner.nextInt();
            scanner.nextLine();
            switch (changeAction) {
                case 1:
                    for (Task task : mainList) {
                        if (dateFormat.format(task.getDate()).equals(dateFormat.format(todayDate))) {
                            printTask(task);
                        }
                    }
                    break;
                case 2:
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.DAY_OF_MONTH, 7);
                    Date plusWeek = calendar.getTime();
                    for (Task task : mainList) {
                        if (task.getDate().before(plusWeek)) {
                            printTask(task);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter the date in the format day/month/year");
                    Date date = dateFormat.parse(scanner.nextLine());
                    for (Task task : mainList) {     //При помощи цикла ищем задачи на дату, введенную пользователем
                        if (task.getDate().equals(date)) {
                            printTask(task);
                        }
                    }
                    break;
                case 4:
                    for (Task task : mainList) {
                        printTask(task);
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Enter the correct number\n");
            }
        }
    }

    public void printTask (Task task) {
        System.out.println(dateFormat.format(task.getDate()));
        System.out.print(task.getDescription());
        System.out.print("\nStatus - ");
        System.out.println(task.getStatus());
        System.out.println("");
    }


    public static void saveInFile() throws IOException {
        FileWriter fileWriter = new FileWriter("SaveList.txt");
        for (Task task : mainList) {
            fileWriter.write(dateFormat.format(task.getDate()));
            fileWriter.write((char) 174);   //разделитель
            fileWriter.write(task.getDescription());
            fileWriter.write((char) 174);   //разделитель
            fileWriter.write(task.getStatus());
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
            Task task = new Task(dateFormat.parse(chunks[i]), chunks[i + 1], chunks[i + 2]);
            mainList.add(task);
        }
        for (Task task: mainList){      //Проверка на наличие просроченных задач
            String status = task.getStatus();
            String taskDate = dateFormat.format(task.getDate());
            String today = dateFormat.format(todayDate);
            if (status.equals("UNCOMPLETED") && dateFormat.parse(taskDate).before(dateFormat.parse(today))){
                task.setStatus(Status.EXPIRED);
            }
        }

    }

}
