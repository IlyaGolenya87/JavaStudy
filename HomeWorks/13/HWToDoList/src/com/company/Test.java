package com.company;

import java.io.IOException;
import java.text.ParseException;

public class Test {
    public static void main(String[] args) {
        ToDoList q = new ToDoList();
        try {
            q.loadFromFile();
        } catch (IOException e) {
            System.out.println("Error of reading from file");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        q.showList();
    }
}
