package com.company;

import java.io.IOException;
import java.text.ParseException;

public interface ToDoListImpl {
    void addTask() throws ParseException;
    void editTask() throws ParseException;
    void showList();
    void saveInFile() throws IOException;
    void loadFromFile() throws IOException, ParseException;
    void start() throws IOException, ParseException;
}
