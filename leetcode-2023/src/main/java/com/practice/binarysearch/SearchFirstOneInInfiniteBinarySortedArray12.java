package com.practice.binarysearch;

// Search a target element in an infinite array
public class SearchFirstOneInInfiniteBinarySortedArray12 {

    public static int binarySearchAscFirst(int[] arr, int start, int end, int element) {
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= element) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int element = 1;
        int start = 0, end = 1;
        // Getting the index position for the end pointer
        while (end < arr.length && element > arr[end]) {
            start = end;
            end = end * 2;
        }
        // Applying the normal Binary Search
        System.out.println(binarySearchAscFirst(arr, start, Math.min(end, arr.length - 1), element));
    }
}
