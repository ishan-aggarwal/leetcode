package com.practice.binarysearch;

//Find the min difference element for a given element in input
public class MinDiffElement13 {

    public static int binarySearchAsc(int[] arr, int start, int end, int element) {
        int ans = -1;
        int pos = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == element)
                return arr[mid];
            if (arr[mid] < element) {
                ans = arr[mid];
                pos = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (pos != arr.length - 1) {
            return Math.min(Math.abs(ans - element), Math.abs(arr[pos + 1] - element));
        } else {
            return Math.abs(ans - element);
        }
//        return Math.abs(arr[start] - element) < Math.abs(arr[end] - element) ? arr[start] : arr[end];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 10, 11, 15};
        int key = 12;
        int ans = binarySearchAsc(arr, 0, arr.length - 1, key);
        System.out.println(ans);
    }
}
