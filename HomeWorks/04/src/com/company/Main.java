package com.company;

public class Main {

    public static void main(String[] args) {

        //Test Case 1
        int [] arr = {1,8,6,15,0,-9};
        double test = average(arr);
        System.out.println("TestCase 1");
        System.out.println(test);
        System.out.println("");

        //Test Case 2
        double [] arrDouble = {-1.5, 0.8, 67.3285, -8.27, 18.24, 2.7};
        double test2 = min(arrDouble);
        System.out.println("TestCase 2");
        System.out.println(test2);
        System.out.println("");

        //Test Case 3
        int even = firstEven(1,13,3,6,9,12,7,11);
        System.out.println("TestCase 3");
        System.out.println(even);
        System.out.println("");

        //Test Case 4
        long amount = byteConverter(1024,"b");
        System.out.println("TestCase 4");
        System.out.println(amount);
        System.out.println("");

        //Test Case 5
        int [] array = {17,18,4,0,28};
        System.out.println("TestCase 5");
        System.out.println(isSorted(array));
        System.out.println("");

        //Test Case 6
        boolean boo = isPrime(239);
        System.out.println("TestCase 6");
        System.out.println(boo);
        System.out.println("");

        //Test Case 7
        int c = sumDigits(285);
        System.out.println("TestCase 7");
        System.out.println(c);
        System.out.println("");

        //Test Case 8
        System.out.println("TestCase 8");
        showTime(15280);
        System.out.println("");

        //Test Case 9
        System.out.println("TestCase 9");
        int n = (int)(Math.random()*20+1);
        int m = (int) (Math.random()*20+1);
        //создание двумерного массива со случайным количеством строк и столбцов в диапазоне от 1 до 20
        int [][] arr01 = new int[n][m];
        //заполнение массива случайными числами от -50 до +49
        for (int i = 0; i < arr01.length; i++){
            for (int j = 0; j < arr01[0].length; j++){
                arr01 [i][j] = (int)(Math.random()*100-50);
            }
        }
        //передаем массив в функцию replaceNegatives
        replaceNegatives(arr01);
        //распечатываем измененный массив
        for (int i = 0; i < arr01.length; i++){
            for (int j = 0; j < arr01[0].length; j++){
                System.out.print(arr01 [i][j]+ " ");
            }
            System.out.println("");
        }
        System.out.println("");

        //Test Case 10
        System.out.println("TestCase 10");
        sqRoots(4.2, -2.17, 0.25);
    }


    /*1. Написать функцию average, которая в качестве входного параметра принимает
    массив целых чисел и возвращает их среднеее значение.*/
    public static double average (int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return (double)(sum/arr.length);
    }

    /*2. Написать функцию min, которая принимает на вход массив вещественных чисел
    и возвращает минимальный элемент массива.*/

    public static double min (double[] arr){
        double result = arr[0];
        for (int i = 0; i<arr.length; i++){
            if (result > arr[i]) {
                    result = arr[i];
            }
        }

        return result;
    }

    /*3. Написать функцию firstEven, которая на вход принимает переменное число
    параметров целого типа и возвращает первый найденный элемент из заданной
    последовательности, который является четным числом.*/

    public static int firstEven (int...a){
        int even = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i] % 2 == 0){
                even = a[i];
                break;
            }
        }
        return even;
    }

    /*4. Написать функцию byteConverter, принимающую на вход 2 аргумента.
    Назначение функции – перевести мегабайты в байты или килобайты. Первый
    аргумент – целое число в диапазоне от 0 до 106, представляющее количество
    мегабайт. Второй аргумент – строка, в которую может быть записано одно из 2-х
    значений: “b” или kb”. В зависимости от значения второго аргумента, функция
    должна возвращать количествово байт, либо килобайт, согласно значению первого
    аргумента.*/

    public static long byteConverter (int mb, String type){
        long result = 0L;
        if (type == "b"){
            result = mb*1024*1024;
        }else {
            if (type == "kb")
                result = mb*1024;
        }
        return result;
    }

    /*5. Написать функцию isSorted, которая принимает на вход массив элементов
    целого типа. Функция должна возвратить значение true, если заданный массив
    является отсортированным по возрастанию, либо false – в противном случае.*/

    public static boolean isSorted (int arr[]){
        boolean isSorted = false;
        if (arr.length <= 1){
            isSorted = true;
        }
        for (int i = 0; i < arr.length-1; i++){
            if (arr[i]>arr[i+1]){
                isSorted = true;
            }else {
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }

   /* 6. Написать функцию isPrime, принимающую на вход целое число и
    возвращающую true, если заданное значение является простым числом, либо false,
    если число составное.*/
   public static boolean isPrime (int a){
       boolean result = true;

       for (int i = 2; i < a; i++){
           if ((a % i) == 0){
               result = false;
               break;
           }
       }
       return result;
   }

   /*7. Написать функцию sumDigits, которая на вход принимает целое положительное
    число и возвращает сумму цифр этого числа.*/

   public static int sumDigits (int a){
       int sum = 0;
       int i = 0;
       while (a>=1){
           i = a % 10;
           sum += i;
           a -= i;
           a /=10;
       }
       return sum;
   }

   /*8. Написать функцию showTime, которая принимает на вход количество секунд
            (целое положительное число). Функция должна перевести время из секунд в часы,
    минуты и секунды, и вывести значение в формате “HH:MM:SS” на экран.
    Например, при вызове функции showTime(765), на экран должна вывестить
    надпись "00:12:45”, т.к. аргумент 765 соответствует 12 минутам и 45 секундам.
    Обратитите внимание, что если один из параметров времени меньше 10, то перед
    ним необходимо вывести лидирующий 0, чтобы в каждой позиции было записано
    минимум 2 цифры. Функция не должна возвращать значения, а лишь выводить
    полученный результат на экран.*/

   public static void showTime (int sec){
       int h = sec / 3600;
       int m  = (sec - 3600 * h) / 60;
       int s = sec - h * 3600 - m * 60;

       if (h < 10) {
           System.out.print("0" + h + ":");
       }else {
           System.out.print(h + ":");
       }
       if (m < 10) {
           System.out.print("0" + m + ":");
       }
       else {
           System.out.print(m + ":");
       }
       if (s < 10) {
           System.out.println("0" + s);
       }else {
           System.out.println(s);
       }
   }

   /*9. Написать функцию replaceNegatives, которая принимает в качестве аргумента
    двумерный массив(матрицу) размером nxm, состоящий из целых чисел. Функция
    должна заменить все отрицательные значения в этой матрице на 0 и вернуть
    измененную матрицу. Примечание: кол-во строк и столбцов в матрице может быть
    любым и варьироваться в диапазоне от 1 до 20.*/

   public static int[][] replaceNegatives (int arr [][]){
       for (int n = 0; n < arr.length; n++){
           for (int m = 0; m < arr[0].length; m++){
               if (arr[n][m] < 0){
                   arr [n][m] = 0;
               }
           }
       }
       return arr;
   }

   /*10. Написать функцию sqRoots, которая должна вывести на экран корни
    квадратного уравнения. В качестве входных аргументов функция должна
    принимать 3 вещественных значения a, b и c, которые являются коэффициентами
    квадратного трехчлена вида
    Если корни для заданных аргументов определить невозможно, то вывести на экран
    сообщение "корней нет”*/
   public static void sqRoots (double a, double b, double c){

       double diskr = b*b-a*c*4;
       if (diskr > 0){
           double x1 = (-b + Math.sqrt(diskr))/(a*2);
           double x2 = (-b - Math.sqrt(diskr))/(a*2);
           System.out.print("x1 = ");
           System.out.print(x1);
           System.out.print("; x2 = ");
           System.out.println(x2);
           }else{
           if (diskr == 0){
               double x = -b/(a*2);
               System.out.print("x = ");
               System.out.println(x);
           }else {
               System.out.println("У уравнения нет корней");
           }
       }
   }
}


