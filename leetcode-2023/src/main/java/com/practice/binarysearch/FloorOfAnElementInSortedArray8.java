package com.practice.binarysearch;

// Find the floor element for a given element
public class FloorOfAnElementInSortedArray8 {

    public static int findFloor(int[] arr, int element) {
        int start = 0, end = arr.length - 1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == element)
                return arr[mid];
            // If current element is less than the target element then store this as answer and search for a more accurate floor if available
            if (arr[mid] < element) {
                res = arr[mid];
                start = mid + 1;
            } else
                end = mid - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8, 10, 10, 12, 19};
        System.out.println(findFloor(arr, 5));
    }
}
