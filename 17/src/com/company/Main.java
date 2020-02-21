package com.company;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        int sum = 0;

        for (String arg: args ){

            int a = Integer.parseInt(arg);
            sum += a;
        }

        System.out.print("Сумма чисел равна ");
        System.out.println(sum);

        //СИСТЕМНЫЕ ПЕРЕМЕННЫЕ
        Map <String, String> envs = System.getenv();     //getenv() возвращает список системных переменных  (переменных среды)

        System.out.println("Path = " + envs.get("Path"));

        System.out.println(System.getenv("TEMP"));

    }
}
