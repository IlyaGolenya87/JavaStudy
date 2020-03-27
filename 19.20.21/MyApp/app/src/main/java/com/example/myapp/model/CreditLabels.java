package com.example.myapp.model;

public enum CreditLabels {
    FOOD ("Еда"),
    TRANSPORT ("Транспорт"),
    ENTERTAINMENT ("Развлечения"),
    OTHER ("Другое");

    private String label;

    CreditLabels(String label) {
        this.label = label;
    }


    public String getLabel() {
        return label;
    }



}
