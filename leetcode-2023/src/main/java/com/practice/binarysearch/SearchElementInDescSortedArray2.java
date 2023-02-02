package com.practice.binarysearch;

public class SearchElementInDescSortedArray2 {

    public static void main(String[] args) {
        int[] arr = new int[]{20, 17, 15, 14, 13, 12, 10, 9, 8, 4};
        int ele = 4;
        System.out.println(search(arr, ele));
    }

    private static int search(int[] arr, int ele) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == ele) return mid;
            if (arr[mid] < ele) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
