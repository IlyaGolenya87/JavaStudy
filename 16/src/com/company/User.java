package com.company;

import java.io.Serializable;
public class User implements Serializable {     //Для того, чтобы была возможность сериализации, класс нужно имплементировать от интерфейса Serializable

    public String name;
    public int age;
    public transient float height; //модификатор transient применяется есле не нужно сериализовать это свойство

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
