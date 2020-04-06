package com.company;

public class Main {

    public static void main(String[] args) {

        FahrenheitConverter fahrenheitConverter = new FahrenheitConverter();
        KelvinConverter kelvinConverter = new KelvinConverter();

        System.out.println(fahrenheitConverter.convert(100));
        System.out.println(kelvinConverter.convert(100));


    }
}
