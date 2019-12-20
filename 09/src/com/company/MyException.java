package com.company;

public class MyException extends Exception { //Попытка создать собственное исключение
    public long timestamp; //создаем для примера переменную, которая будет хранить время в мс когда произошло это исключение

    public MyException (){
        super(); //т.к. в классе Exception переопределен стандартный конструктор
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String getMessage() { //переопределение стандартного метода из класса Throwable

        return "MyException error";

    }

}
