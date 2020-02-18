package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //СЕРИАЛИЗАЦИЯ
        //Предоставление информации в виде набора бит или байт

        User user = new User("Вася", 35);

        //Указать стрим, куда мы хотим записать объект
        try {
            FileOutputStream fes = new FileOutputStream("user.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fes);       //
            oos.writeObject(user);
            oos.close();
            fes.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //ДЕСЕРИАЛИЗАЦИЯ
        //обратный процесс

        try {
            FileInputStream fis = new FileInputStream("user.bin");
            ObjectInputStream obs = new ObjectInputStream(fis);
            User user1 = (User) obs.readObject();       //Используется приведение, т.к. метод возвращает объект типа Object
            obs.close();
            fis.close();
            System.out.println(user1.name);
            System.out.println(user1.age);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //Сериализация коллекции
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Fedya", 15));
        users.add(new User("Ivan", 25));
        users.add(new User("Vavan", 30));

        try {
            FileOutputStream fos1 = new FileOutputStream("Users.bin");
            ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
            oos1.writeObject(users);
            oos1.close();
            fos1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Десериадизация коллекции
        try {
            FileInputStream fis = new FileInputStream("Users.bin");
            ObjectInputStream obs = new ObjectInputStream(fis);
            ArrayList<User> people = (ArrayList<User>) obs.readObject();
            obs.close();
            fis.close();
            for (User u: people){
                System.out.println( u.name);
                System.out.println(u.age);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
