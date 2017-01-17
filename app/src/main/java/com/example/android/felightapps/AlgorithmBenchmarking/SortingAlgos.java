package com.example.android.felightapps.AlgorithmBenchmarking;

/**
 * Created by Yogesh on 04-01-2017.
 */

public class SortingAlgos {

    public static long bubbleSort(int[] array) {

        int length = array.length;
        int temp = 0;
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        long totalTime = System.currentTimeMillis() - startTime;
        return totalTime;
    }

    public static void quickSort(int[] array, int low, int high) {

        if (array == null || array.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = array[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    public static long quickSortHelper(int[] array) {
        long startTime = System.currentTimeMillis();
        quickSort(array, 0, array.length - 1);
        long totalTime = System.currentTimeMillis() - startTime;
        return totalTime;
    }

    public static long selectionSort(int[] array) {

        int min;
        int pos = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length - 1; i++) {
            min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    pos = j;
                }
            }
            array[pos] = array[i];
            array[i] = min;
        }

        long totalTime = System.currentTimeMillis() - startTime;
        return totalTime;
    }

    public static long insertionSort(int[] array) {

        long startTime = System.currentTimeMillis();
        int j;
        for (int i = 1; i < array.length; i++) {
            int key = array[i];

            for (j = i - 1; (j >= 0) && (key < array[j]); j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }

        long totalTime = System.currentTimeMillis() - startTime;
        return totalTime;
    }

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int[] array1 = new int[(array.length / 2)];
        int[] array2 = new int[(array.length - array1.length)];

        System.arraycopy(array, 0, array1, 0, array1.length);
        System.arraycopy(array, array1.length, array2, 0, array2.length);

        mergeSort(array1);
        mergeSort(array2);

        merge(array1, array2, array);
        return array;
    }

    public static void merge(int[] array1, int[] array2, int[] mergedArray) {
        int array1Index = 0;
        int array2Index = 0;
        int pos = 0;

        while ((array1Index < array1.length) && (array2Index < array2.length)) {
            if (array1[array1Index] < array2[array2Index]) {
                mergedArray[pos] = array1[array1Index];
                array1Index++;
                pos++;
            } else {
                mergedArray[pos] = array2[array2Index];
                array2Index++;
                pos++;
            }
        }

        if (array1Index < array2Index) {
            System.arraycopy(array1, array1Index, mergedArray, pos, array1.length - array1Index);
        } else if (array2Index < array1Index) ;
        {
            System.arraycopy(array2, array2Index, mergedArray, pos, array2.length - array2Index);
        }

    }

    public static long mergeSortHelper(int[] array) {
        long startTime = System.currentTimeMillis();
        mergeSort(array);
        long totalTime = System.currentTimeMillis() - startTime;
        return totalTime;
    }

}
