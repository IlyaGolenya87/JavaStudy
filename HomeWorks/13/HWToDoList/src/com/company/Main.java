package com.company;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Date date = new Date();

        Task task = new Task("Съесть пирожок", date);

        System.out.println(task.getStatus());
        task.markCompleted();
        System.out.println(task.getStatus());

    }
}
