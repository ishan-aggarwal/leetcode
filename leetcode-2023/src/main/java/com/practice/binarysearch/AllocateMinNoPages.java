package com.practice.binarysearch;

public class AllocateMinNoPages {
    public static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int item : arr) {
            if (max < item)
                max = item;
        }
        return max;
    }

    public static int findSum(int[] arr) {
        int sum = 0;
        for (int item : arr)
            sum += item;
        return sum;
    }

    public static boolean isValid(int[] arr, int k, int max) {
        int student = 1;
        int sum = 0;
        for (int j : arr) {
            sum += j;
            if (sum > max) {
                student++;
                sum = j;
            }
            if (student > k)
                return false;
        }
        return true;
    }

    public static int binarySearch(int[] arr, int start, int end, int k) {
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(arr, k, mid)) {
                res = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {31, 14, 19, 75};
        int k = 12;
        int start = findMax(arr), end = findSum(arr);
        System.out.println(binarySearch(arr, start, end, k));
    }
}
