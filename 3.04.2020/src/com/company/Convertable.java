package com.company;

public interface Convertable <T extends Currency> {     //через дженерик накладывается ограниечение типа. Он обязательно должен наследоваться от класса Currency

    void convertTo(T currency);


}
