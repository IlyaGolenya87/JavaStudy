package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        UsdConverter usdConverter = new UsdConverter();
        RubConverter rubConverter = new RubConverter();

        System.out.println(usdConverter.convert(100));
        System.out.println(rubConverter.convert(100));


        USD usd = new USD();

        usd.setValue(35.3f);

        BYN byn = new BYN();

        usd.convertTo(byn);

        System.out.println(byn);

        byn.convertTo(usd);

        System.out.println(usd);

        /////////////////////////////////

        String s = "мамамылараму";
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
