package org.example.homework;

import java.util.Arrays;

public class HeapSort {
//    public static void main(String[] args) {
//        int N = 10;
//        int numbers[] = new int[N];
//        for (int i = 0; i < N; i++)
//            numbers[i] = (int) (Math.random() * 10);
//
//        System.out.println((Arrays.toString(numbers)));
//        sort(numbers);
//        System.out.println("--------------------------------------");
//        System.out.println((Arrays.toString(numbers)));
//
//    }

    public void sort(int[] arr) {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(arr, len, i);
        }
        for (int i = len - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private void heapify(int arr[], int len, int i) {
        int large = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < len && arr[left] > arr[large]) {
            large = left;
        }
        if (right < len && arr[right] > arr[large]) {
            large = right;
        }
        if (large != i) {
            int temp = arr[i];
            arr[i] = arr[large];
            arr[large] = temp;
            heapify(arr, len, large);
        }

    }
}
