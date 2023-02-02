package com.practice.binarysearch;

//Given an array of integers which is initially increasing and then decreasing, find the maximum value in the array.
public class FindMaxElementInBitonic {

    public static int findMax(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && mid < arr.length - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                    return mid;
                if (arr[mid] < arr[mid + 1])
                    start = mid + 1;
                else
                    end = mid - 1;
            } else if (mid == 0) {
                if (arr.length == 1 || arr[0] >= arr[1])
                    return 0;
                return 1;
            } else {
                if (arr[arr.length - 2] <= arr[arr.length - 1])
                    return arr.length - 1;
                return arr.length - 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 12, 8, 2};
        System.out.println(findMax(arr));
    }
}
