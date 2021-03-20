package com.ogrinhoProgrammer;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            int mid = list.length / 2;
            int[] firstHalf = new int[mid];
            System.arraycopy(list, 0, firstHalf, 0, mid);

            mergeSort(firstHalf);

            int secondHalfLength = list.length - mid;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, mid, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);
            merge(firstHalf, secondHalf, list);
        }
    }

    public static void merge(int[] list, int[] list2, int[] temp) {
        int i = 0, j = 0, k = 0;

        while (i < list.length && j < list2.length) {
            if (list[i] < list2[j]) {
                temp[k++] = list[i++];
            }

            else {
                temp[k++] = list2[j++];
            }
        }

        while (i < list.length)
           temp[k++] = list[i++];

        while (j < list2.length)
            temp[k++] = list2[j++];
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};

        mergeSort(arr);

        for (int num : arr)
            System.out.println(num + " ");

    }
}
