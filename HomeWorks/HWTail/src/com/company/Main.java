package com.company;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("Ошибка, не указан путь к файлу");
            return;
        }

        String path = args[0];
        ArrayDeque<String> allStrings = new ArrayDeque<>();


        try {
            FileReader reader = new FileReader(new File(path));
            Scanner scan = new Scanner(reader);

            while (scan.hasNextLine()) {
                allStrings.addFirst(scan.nextLine());
            }
            reader.close();

            ArrayDeque<String> lastTenStrings = new ArrayDeque<>();

            if (allStrings.size() >= 10) {
                for (int i = 0; i <= 9; i++) {
                    lastTenStrings.addFirst(allStrings.getFirst());
                    allStrings.removeFirst();
                }
            } else {
                if (allStrings.size() != 0) {
                    for (String s : allStrings) {
                        lastTenStrings.addFirst(s);
                    }
                } else {
                    System.out.println("Файл пустой");
                    return;
                }
            }

            for (String s : lastTenStrings) {
                System.out.println(s);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка, файл не найден. Проверьте путь к файлу");
        }  catch (IOException e) {
            e.getMessage();
        }
    }
}




