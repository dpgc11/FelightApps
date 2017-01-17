package com.example.android.felightapps.AlgorithmBenchmarking;

/**
 * Created by Yogesh on 04-01-2017.
 */

public class GenerateArrays {

    public static int[] getNaturalNumbersArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        return numbers;
    }

    public static int[] getRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int) ((Math.random()) * 1000));
        }

        return array;
    }

    public static int[] getReverseArray(int size) {
        int index = 0;
        int[] temp = new int[size];
        System.out.println(temp.length);
        for (int i = temp.length; i > 0; i--) {
            temp[index++] = i;
        }
        return temp;
    }

    public static void initDupArray(int[] array, int[] dupArray) {
        for (int i = 0; i < array.length; i++) {
            dupArray[i] = array[i];
        }
    }

}
