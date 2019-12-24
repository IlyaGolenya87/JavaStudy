package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int $ac = 1;

        //ИНТЕРФЕЙСЫ
        //Список свойств и методов, того или иного класса

        Bancomat bancomat = new Bancomat();

        Scanner sc = new Scanner(System.in); //пользовательский ввод с клавиатуры (устройства ввода по умолчанию)
        System.out.println("Вставьте карту"); //т.к. картоприемника нет, пользователь вводит сам ID карточки
        String cardId = sc.nextLine();  //команда nextLine() - принимает строку, если нужно другой тип - next.Int и т.д.

        boolean succes = false;
        for (int i = 0; i < 3; i++) {

            System.out.println("Введите Pin");
            String pin = sc.nextLine();
            if (bancomat.chekPin(cardId, pin)) {
                succes = true;
                break;
            }
            System.out.println("Неверный Pin");


        }
        if (!succes) {
            System.out.println("Карта заблокирована");
            return;
        }

        while (true){
            System.out.println("Главное меню");
            System.out.println("1. Показать баланс");
            System.out.println("2. Снять наличные");
            System.out.println("3. Пополнить счет");
            System.out.println("4. Закончить работу");

            int menu = sc.nextInt();

            //далее сравниеваем с пунктами меню

            switch (menu){
                case 4:
                    bancomat.rejectCard();
                    System.out.println("Заберите Вашу карту");
                    return; //завершает всю программу
                case 1:
                    float balance = bancomat.getBalance();
                    System.out.println(balance);
                    break;
                case 2:
                    System.out.println("Введите сумму");
                    float cash = sc.nextFloat();
                    bancomat.getCash(cash);
                    break;
                case 3:
                    System.out.println("Вставьте купюры");
                    float cashIn = sc.nextFloat();
                    bancomat.addCach(cashIn);
                    break;

            }
        }
    }
}
