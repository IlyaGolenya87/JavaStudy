package com.company;

import java.io.*;
import java.util.ArrayDeque;


public class Main {

    public static void main(String[] args) {

        String path = args[0];
        ArrayDeque<String> allStrings = new ArrayDeque<>();

        try {
            FileReader reader = new FileReader(path);
            int c = reader.read();
            String str = "";
            while (c != -1) {
                if (c == '\n') {
                    allStrings.addFirst(str);
                } else {
                    str += (char) c;
                }

                c = reader.read();
            }
            allStrings.addFirst(str);

            ArrayDeque<String> lastTenStrings = new ArrayDeque<>();

            for (int i = 0; i <= 9; i++) {
                lastTenStrings.addFirst(allStrings.getFirst());
                allStrings.removeFirst();

            }
            for (String s : lastTenStrings) {
                System.out.println(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
