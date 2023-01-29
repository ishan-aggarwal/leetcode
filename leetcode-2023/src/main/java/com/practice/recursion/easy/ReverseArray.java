package com.practice.recursion.easy;

import java.util.Arrays;

// Reverse the given input array
public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 2};
        System.out.println("Array before reverse operation: " + Arrays.toString(arr));
        reverse(arr, 0, arr.length - 1);
        System.out.println("Array after reverse operation:  " + Arrays.toString(arr));
        reverse(arr, 0);
        System.out.println("Array after reverse operation:  " + Arrays.toString(arr));
    }

    private static void reverse(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        swap(arr, start, end);
        reverse(arr, start + 1, end - 1);
    }

    private static void reverse(int[] arr, int start) {
        if (start >= arr.length / 2) {
            return;
        }
        swap(arr, start, arr.length - 1 - start);
        reverse(arr, start + 1);
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
