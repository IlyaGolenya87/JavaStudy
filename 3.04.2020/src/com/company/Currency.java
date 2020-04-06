package com.company;

import java.util.HashMap;

public abstract class Currency implements Convertable {

    private float value;

    protected String name;

    public String getName() {
        return name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    private static HashMap<String, Float> exchangeTable;       //коллекция для хранения коэффициентов перевода между валютами

    private static HashMap<String, Float> getExchangeTable() {      //паттерн синглтон для инициализации коллекции, чтобы она создавалась в единственном экземпляре
        if (exchangeTable != null) {
            return exchangeTable;
        }
        exchangeTable = new HashMap<>();
        exchangeTable.put("USD_BYN", 2.58f);
        exchangeTable.put("BYN_USD", 0.388f);
        exchangeTable.put("USD_EUR", 1.04f);
        exchangeTable.put("EUR_USD", 0.96f);
        exchangeTable.put("USD_RUB", 74.64f);
        exchangeTable.put("RUB_USD", 0.013f);
        exchangeTable.put("RUB_EUR", 0.011f);
        exchangeTable.put("EUR_RUB", 79.95f);
        return exchangeTable;
    }

    private static void convert(Currency from, Currency to) {

        String key = from.name + "_" + to.name;
        to.value = from.value * getExchangeTable().get(key);

    }

    @Override
    public void convertTo(Currency currency) {

        convert(this, currency);

    }


    @Override
    public String toString() {
        return String.format("%.2f %s", this.value, this.name);       //   %.2f - float с двумя знаками после запятой
    }


}
