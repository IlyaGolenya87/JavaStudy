package com.company;

public class KelvinConverter extends Converter implements Converting {    //переводит из цельсия в кельвины
    @Override
    public float convert(float temp) {
        return temp + 273.15f;
    }
}
