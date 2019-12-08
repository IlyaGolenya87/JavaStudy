package com.company;

public class Main {

    public static void main(String[] args) {
        // методы

        int s = sum(2,3,4);
        System.out.println(s);

        float m = max(1.3f,2.8f, -4.9f);
        System.out.println(m);

        int arr [] = {8, 7, 15, 1};
        int sumAll = sumElements(arr);
        System.out.println(sumAll);

        float result = sumOdd(1.7f, 0.8f, -14.8f, 87.129f);
        System.out.println(result);

        arr = bubbleSort(arr);

        System.out.println("arr");

        for (int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

    }


    public static int sumElements (int [] array){
        int s = 0;

        for (int i = 0; i < array.length; i++) {
            s = s + array[i];
        }

        return s;
    }

    public static int sum(int a, int b, int c){
        return a + b + c; // ключевое слово return завершает выполнение метода
    }

    public static float max (float c, float d, float e){

        if (c>d&&c>e){
            return c;
        }else {
            if (d>c&&d>e){
                return d;
            }else return e;
        }

    }

    //Метод с переменным числом параметров

    public static float sumOdd (float...a){ //оператор ... обозначает любое число параметров
        float s = 0.0f;

        for (int i = 0; i < a.length; i++){
            if (i % 2 == 0){
                continue;
            }

            s = s + a [i];
        }
        return s;
    }

    // Сортировка массивов
    // Метод пузырька

    public static int[] bubbleSort(int [] arr){

        for (int i = 0; i<arr.length; i++){

            for (int j = i + 1; j < arr.length; j++){

                if (arr[i] < arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        return arr;
    }

}
