package com.company;

public interface CoffeeMachineImpl {
    float []showRes ();     // Показать текущий объем воды и кофе
    void americano ();      // Приготовить американо
    void espresso ();       // Приготовить эспрессо
    void doubleEspresso ();     // Приготовить двойной эспрессо
    void pourWater ();      // Добавить воды
    void pourCofee ();      // Добавить кофе
    void info ();       // Информация
    void finish();      // Выключение

}
