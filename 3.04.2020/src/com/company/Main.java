package com.company;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        UsdConverter usdConverter = new UsdConverter();
        RubConverter rubConverter = new RubConverter();

        System.out.println(usdConverter.convert(100));
        System.out.println(rubConverter.convert(100));


        USD usd = new USD();
        BYN byn = new BYN();
        RUB rub = new RUB();
        EUR eur = new EUR();

        usd.setValue(35.3f);
        rub.setValue(1000f);
        usd.convertTo(byn);
        rub.convertTo(eur);

        System.out.println(byn);
        System.out.println(eur);

        byn.convertTo(usd);

        System.out.println(usd);

        /////////////////////////////////
        //Подсчет количества повторяющихся символов в строке

        String s = "Это какая-то жопная жопа";
        char [] string = s.toCharArray();
        ArrayList<Character> duplicates = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < string.length; i++) {
            char letter = string[i];
            if (duplicates.contains(string[i])){
                continue;
            }
            for (int j = 0; j < string.length; j++) {
                if (string[i] == string[j]) {
                    duplicates.add(string[i]);
                    count++;
                }
            }
            if (count == 0) {
                System.out.printf("Буква %s встречается 1 раз", letter);
            } else {
                System.out.printf("Буква %s встречается %s раз", letter, count);
            }
            count = 0;
            System.out.println("");
        }


    }
}
