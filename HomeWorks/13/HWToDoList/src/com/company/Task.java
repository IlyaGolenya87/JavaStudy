package com.company;

import java.util.Date;

public class Task {
    private String description;
    private Date date;
    private status status;

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public com.company.status getStatus() {
        return status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Task(String description, Date date) {
        this.description = description;
        this.date = date;
        status = com.company.status.UNCOMPLETED;
    }

    public void editDescription(String newDescription){     //отредактировать описание
        description = newDescription;
    }

    public void delTask(){ //удалить задачу, пока непонятно как реализовать

    }

    public void markCompleted(){
        status = com.company.status.COMPLETED;
    }

    public void markUnCompleted(){
        status = com.company.status.UNCOMPLETED;
    }

}

enum status {
    COMPLETED,
    UNCOMPLETED
}
