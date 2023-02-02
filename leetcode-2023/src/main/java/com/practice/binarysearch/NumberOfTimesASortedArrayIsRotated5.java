package com.practice.binarysearch;

public class NumberOfTimesASortedArrayIsRotated5 {

    public static void main(String[] args) {
        int[] arr = new int[]{8, 11, 12, 15, 18, 2, 5, 6};
        int count = countTimes(arr);
        System.out.println(count);
    }

    private static int countTimes(int[] arr) {

        int n = arr.length;
        int start = 0, end = n - 1;

        if (n == 1 || arr[start] < arr[end]) return 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if the array is already sorted
            if (arr[start] < arr[end])
                return start;

            // Doing the modulo operation here as we don't want to out of bound
            if (arr[mid] <= arr[(mid + n - 1) % n] && arr[mid] <= arr[(mid + 1) % n]) return mid;

            // and the idea is that we want to find the element in unsorted part of the array
            if (arr[start] < arr[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
