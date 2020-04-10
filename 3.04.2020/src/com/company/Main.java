package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

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

        String s = "Этокакая-тожопа";
        char[] string = s.toCharArray();
        ArrayList<Character> duplicates = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < string.length; i++) {
            char letter = string[i];
            if (duplicates.contains(string[i])) {
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

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        System.out.println(map);

        for (char i = 'A'; i <= 'z'; i++) {
            System.out.print(i);
        }
        int l = 'z' - 'a';
        System.out.println(l + 1);

        char f = 'F';
        char i = (char) (f + 3);
        System.out.println(i);

        ///////////////
        //Работа с матрицами

        int m[][] = new int[3][5];       //первая скобка - количество строк, вторя - столбцов

        m[0][0] = 12;
        m[2][4] = -1;

        //повторить бинарные операторы как они работают!!!!!!!
        //&, |, <<, >>


        //ТЕРНАРНЫЙ ОПЕРАТОР

        String res = m[0][0] > m[2][4] ? "yes" : "no";
        System.out.println(res);

        //////////////////////////////

        int[] array = new int[20];
        Random random = new Random();

        for (int j = 0; j < array.length; j++) {
            array[j] = random.nextInt(21);
        }
        System.out.println("Unsorted:");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }

        int min;
        int max;
        float middle;

        /*for (int j = 0; j < array.length - 1; j++) {
            for (int k = j + 1; k < array.length; k++) {
                if (array[j] > array[k]) {
                    int z = array[j];
                    array[j] = array[k];
                    array[k] = z;
                }
            }

        }*/
        Arrays.sort(array);

        System.out.println("");
        System.out.println("Sorted:");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }

        min = array [0];
        max = array [array.length-1];
        int sum = 0;
        for (int j = 0; j < array.length ; j++) {
            sum += array [j];
        }
        middle = (float) sum / array.length;

        System.out.printf("\n min = %d, max = %d, middle = %.3f\n", min, max, middle );

        String testString = "a;dkfjal;dfja;sldkjf";
        System.out.println(testString.lastIndexOf('d'));

    }
}
