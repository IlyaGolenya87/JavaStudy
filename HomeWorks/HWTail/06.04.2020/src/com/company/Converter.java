package com.company;

public abstract class Converter {

    float value;

    @Override
    public String toString() {
        return String.format("%.2f degrees", this.value);
    }
}
