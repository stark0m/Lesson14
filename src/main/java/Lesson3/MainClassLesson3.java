package Lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainClassLesson3 {
    static Scanner in = new Scanner(System.in);
    static final int ARRAY_SIZE = 5;

    public static boolean checkBalance(int[] arr7) {
        int sumArray = 0;
        int sumCurrent = 0;
        for (int i = 0; i < arr7.length; i++) {
            sumArray += arr7[i];
        }
        for (int i = 0; i < arr7.length; i++) {
            sumCurrent += arr7[i];
            if ((sumArray - sumCurrent) == sumCurrent) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = new int[7];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(2);
        }

        System.out.println("Задание №1 ");
        System.out.print("Исходный массив: ");
        System.out.println(Arrays.toString(arr));
        System.out.print("Редактированный массив: ");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) arr[i] = 0;
            else arr[i] = 1;
            ;
        }
        System.out.println(Arrays.toString(arr));
        //
        System.out.println("Задание №2 ");
        int[] arr2 = new int[100];
        for (int i = 0; i < arr2.length; ) {
            arr2[i] = ++i;

        }
        System.out.println(Arrays.toString(arr2));
        //
        System.out.println("Задание №3 ");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr3));
        for (int i = 0; i < arr.length; i++) {
            if (arr3[i] < 6) arr3[i] *= 2;
        }
        System.out.println(Arrays.toString(arr3));

        //
        System.out.println("Задание №4 ");

        int[][] arr4 = new int[ARRAY_SIZE][ARRAY_SIZE];
        System.out.printf("Исходный массив размером %d x %d%n", ARRAY_SIZE, ARRAY_SIZE);
        WriteArray(arr4);
        System.out.printf("Получившийся массив %d x %d%n", ARRAY_SIZE, ARRAY_SIZE);
        FillArray4(arr4);
        WriteArray(arr4);

        //
        System.out.println("Задание №5 ");
        System.out.println("Введите значение len: ");
        int len = GetNumFromScanner();
        System.out.println("Введите значение initalVAlue: ");
        int initalVAlue = GetNumFromScanner();
        int[] resultArray = new int[len];
        Arrays.fill(resultArray, initalVAlue);
        System.out.println(Arrays.toString(resultArray));

        //Задание №6
        System.out.println("Задание №6 ");
        int[] arr6 = new int[ARRAY_SIZE];
        for (int i = 0; i < arr6.length; i++) {
            arr6[i] = rnd.nextInt(-127, 128);
        }
        System.out.println("Сгенерирован массив :");
        WriteArray(arr6);
        Arrays.sort(arr6);
        System.out.printf("Минимальное значение в массиве min=%d, максимальное max=%d%n", arr6[0], arr6[arr6.length - 1]);


        //Задание №7
        System.out.println("Задание №7 ");
        int[] arr7 = {1, 1, 1, 2, 1};
        if (checkBalance(arr7)) System.out.println("Массив может быть симметричен по сумме левой и правой части");
        else System.out.println("Массив не соответствует условию");


        //Задание №8
        System.out.println("Задание №8 ");
//        int[] arr8 = new int[ARRAY_SIZE];
        int[] arr8 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n;
        /*        for (int i = 0; i < arr8.length; i++) {
            arr8[i] = rnd.nextInt(-127, 128);
        }*/
        System.out.println("Исходный массив:");
        WriteArray(arr8);
        System.out.print("Введите значение на которое произвести сдвиг в массиве: ");
        n = GetNumFromScanner();
        System.out.println("Производим сдвиг на " + n + " ячеек в заданном массиве");
        ShiftArrayToN(arr8, n);
        WriteArray(arr8);

    }// Close Method Main

    public static void ShiftArrayToN(int[] arr8, int n) {
        int[] tmpArr = new int[arr8.length];
        int tempIndex = Math.abs(n) % arr8.length;

        if (n > 0)
            for (int i = 0; i < tempIndex; i++) {
                arr8 = IncCurrentArray(arr8);
            }
        else for (int i = 0; i < tempIndex; i++) {
            arr8 = DecCurrentArray(arr8);
        }


    }

    private static int[] IncCurrentArray(int[] arr8) {
        int swap = arr8[0];
        arr8[0] = arr8[arr8.length - 1];
        arr8[arr8.length - 1] = swap;
        for (int i = 0; i < arr8.length - 2; i++) {
            swap = arr8[1 + i];
            arr8[1 + i] = arr8[arr8.length - 1];
            arr8[arr8.length - 1] = swap;
        }
        return arr8;
    }

    private static int[] DecCurrentArray(int[] arr8) {
        int swap = arr8[0];
        arr8[0] = arr8[arr8.length - 1];
        arr8[arr8.length - 1] = swap;
        for (int i = 0; i < arr8.length - 2; i++) {
            swap = arr8[arr8.length - 2 - i];
            arr8[arr8.length - 2 - i] = arr8[0];
            arr8[0] = swap;
        }
        return arr8;
    }




    private static void FillArray4(int[][] arr4) {
        for (int i = 0; i < ARRAY_SIZE; i++) {

            arr4[i][i] = 1;
            arr4[i][arr4[i].length - i - 1] = 1;

        }
    }


    private static void WriteArray(int[][] arr4) {
        for (int[] arr41 : arr4) {
            for (int intValue : arr41) {
                System.out.print(intValue + " ");

            }
            System.out.println();
        }
    }

    private static void WriteArray(int[] arr4) {
        for (int a : arr4) {

            System.out.print(a + " ");

        }
        System.out.println();

    }

    private static int GetNumFromScanner() {
        while (true) {
            if (in.hasNextInt()) {
                return in.nextInt();
            }
            System.out.println(in.next() + " - не является числом!");
            System.out.print("Повторите ввод: ");
        }
    }


}
