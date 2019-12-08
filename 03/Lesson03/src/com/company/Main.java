package com.company;

public class Main {

    public static void main(String[] args) {
/*	//Массивы

	    int [] arr = new int[5];
	    arr [0] = 10;
	    arr [4] = 20;

        System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[4]);*/

		//Двумерные массивы
		//в первой скобке указываются количество строк
		//во второй - количество столбцов
		int arr01 [][] = new int[5][4];

		arr01[0][1] = 12;
		arr01 [2][3] = 7;

		System.out.println(arr01[0][1]);
		System.out.println(arr01[2][3]);

		System.out.println(arr01.length);
		System.out.println(arr01[2].length);

		// статическая инициализация массивов
		int [] arr03 = {1,2,3,8,17};
		System.out.println(arr03[3]);

		//статическая инициализация двумерного массива
		int [][] arr04 = {{5,8,1},{3,8,7},{12,8,14}};
		System.out.println(arr04[2][1]);

		//Циклы
		int i = 0;
		while (i < 5){
			System.out.println("Привет");
			i++;
		}

		//i = 5;
		do {
			System.out.println("ОГОГО!");
		}while (i < 5);


		for (int j = 0; j < 4; j++){
			System.out.println(j);
		}

		//оператор break;

		for (int j = 0;; j++){
			System.out.println("Слово");
			if (j==7){
				break;
			}
		}

		//continue

		for (int j = 0;j<10; j++){
			if (j % 2 !=0 ){
				continue; //завершает текущую итеррацию цикла
			}
			System.out.println(j);

		}

		int arr05 [] = new int[10];

		for (int j = 0; j<arr05.length;j++ ){
			arr05[j] = j+1;
			System.out.println(arr05[j]);
		}

		int t = 5;
		int c = t++;

		System.out.println(c);

		for (int n = 0; n < 10; n++ ){
			for (int k = 0; k <10; k++){
				System.out.print(n);
				System.out.print("*");
				System.out.print(k);
				System.out.print("=");
				System.out.println(n*k);
			}
			System.out.println();
		}


    }

}

