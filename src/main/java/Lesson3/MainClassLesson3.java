package Lesson3;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainClassLesson3 {
    static Scanner in = new Scanner(System.in);
    static final int ARRAY_SIZE = 5;
    static private Logger task8 = Logger.getLogger("task8");;

    public static boolean checkBalance(int[] arr7) {
        task8.info("\nНачинаем тестировать задание 8, возвращаем true если можно разбить массив так , что бы его сумма левой части элементов массива была = сумме его правой части элементов");
        task8.info("Входящий массив=" + Arrays.toString(arr7));
        int sumArray = 0;
        int sumCurrent = 0;
        for (int i = 0; i < arr7.length; i++) {
            sumArray += arr7[i];
        }
        task8.debug("Сумма элементов в массиве = "+ sumArray);
        for (int i = 0; i < arr7.length; i++) {
            sumCurrent += arr7[i];
            if ((sumArray - sumCurrent) == sumCurrent)  {
                task8.debug("Число найдено, сумма первых "+(i+1)+" элементов = сумме оставшихся элементов в массиве и = "+ sumCurrent);
                return true;
            }
        }
        task8.debug("массив не соответствует условию, возвращаем false");
        return false;
    }
    public static void main(String[] args) {
        PropertyConfigurator.configure("src/main/resources/logs/config/log4j.properties");

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
  task8.info("начинается тестирование сдвига массива, входящие данные Массив = "+Arrays.toString(arr8)+", сдвиг n= "+n);
        int tempIndex = Math.abs(n) % arr8.length;
if (n>0) {
    task8.debug("сдвиг будет осущетвляться влево, т.к входящее значение  n отрицательное, сдвиг прведется на n=n остаток от деления на длинну входящего массива. сдвиг равен =" + tempIndex);
} else {task8.debug("сдвиг будет осущетвляться вправо, т.к входящее значение  n положительно, сдвиг прведется на n=n остаток от деления на длинну входящего массива. сдвиг равен =" + tempIndex);

}
        if (n > 0)
            for (int i = 0; i < tempIndex ; i++) {

                arr8 = IncCurrentArray(arr8);
                task8.debug("сдвинули на "+ (i+1));
                task8.debug("сдвинули на "+ (-i-1)+" результат ="+Arrays.toString(arr8));
            }
        else for (int i = 0; i < tempIndex; i++) {

            arr8 = DecCurrentArray(arr8);
            task8.debug("сдвинули на "+ (-i-1)+" результат ="+Arrays.toString(arr8));
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
