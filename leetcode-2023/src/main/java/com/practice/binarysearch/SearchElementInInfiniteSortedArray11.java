package com.practice.binarysearch;

// Search a target element in an infinite array
public class SearchElementInInfiniteSortedArray11 {

    public static int binarySearchAsc(int[] arr, int start, int end, int element) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == element)
                return mid;
            if (arr[mid] < element)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int element = 7;
        int start = 0, end = 1;
        // Getting the index position for the end pointer
        while (element > arr[end]) {
            start = end;
            end = end * 2;
        }
        // Applying the normal Binary Search
        System.out.println(binarySearchAsc(arr, start, end, element));
    }
}
