package com.company;

public class RubConverter implements ConverterImpl {

    @Override
    public float convert(float value) {
        return value * 100f / 3.5f;
    }
}
