package com.company;

public class FahrenheitConverter extends Converter implements Converting {
    @Override
    public float convert(float temp) {
        return (temp * 9 / 5) + 32;
    }
}
