package com.company;

public class Lambda {
    public  interface doSomething{
        void doWork(String name);

    }

    public void setOnWorkListener(doSomething listener){
        listener.doWork("programming");
    }
}
