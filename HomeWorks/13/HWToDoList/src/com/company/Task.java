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

    public String getStatus() {
        return status.toString();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStatus(com.company.status status) {
        this.status = status;
    }

    public Task(String description, Date date) {
        this.description = description;
        this.date = date;
        status = com.company.status.UNCOMPLETED;
    }
    public Task ( Date date,String description, String status){
        this.description = description;
        this.date = date;
        switch (status){
            case "COMPLETED":
                this.status = com.company.status.COMPLETED;
                break;
            case "UNCOMPLETED":
                this.status = com.company.status.COMPLETED;
                break;
        }
    }

    public void delTask() {//удалить задачу, пока непонятно как реализовать

    }

    public void markCompleted() {
        this.status = com.company.status.COMPLETED;
    }

    public void markUnCompleted() {
        this.status = com.company.status.UNCOMPLETED;
    }

}

enum status {
    COMPLETED,
    UNCOMPLETED
}
