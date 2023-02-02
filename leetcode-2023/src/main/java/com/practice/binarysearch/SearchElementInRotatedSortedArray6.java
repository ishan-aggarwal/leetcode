package com.practice.binarysearch;

public class SearchElementInRotatedSortedArray6 {

    public static void main(String[] args) {
        int[] arr = new int[]{11, 12, 15, 18, 2, 5, 6};
        int ele = 15;
        int index = minElementIndex(arr);
        int pos1 = search(arr, 0, index - 1, ele);
        int pos2 = search(arr, index, arr.length - 1, ele);
        if (pos2 != -1 || pos1 != -1) {
            System.out.println(pos1 != -1 ? pos1 : pos2);
        } else {
            System.out.println("-1");
        }
    }

    private static int search(int[] arr, int start, int end, int ele) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == ele) return mid;
            if (arr[mid] > ele) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    private static int minElementIndex(int[] arr) {

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
