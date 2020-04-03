package com.company;

public class UsdConverter implements ConverterImpl{

    @Override
    public float convert(float value) {
        return value / 2.6f;
    }
}
