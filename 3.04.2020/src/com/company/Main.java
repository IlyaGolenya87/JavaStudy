package com.company;

import java.util.ArrayList;

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

        String s = "aakdhflahsfsdpifvnj";
        String[] arr = s.split("");

        ArrayList <String> string = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            string.add(s.split("")[i]);
        }

        for (int i = 0; i < string.size(); i++) {
            int count = 0;
            String letter = string.get(i);

            for (int j = 1; j < string.size(); j++) {

                if (string.get(i).equals(string.get(j))) {
                    count++;
                    string.remove(j);
                                        
                }
            }

            System.out.printf("Буква %s встречается %d раза", letter, count);
            System.out.println("");
            count = 0;


        }


    }
}
