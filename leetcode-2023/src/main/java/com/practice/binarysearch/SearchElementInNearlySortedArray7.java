package com.practice.binarysearch;

/*
 Given a sorted array arr[] of size N, some elements of array are moved to either of the adjacent positions,
 i.e., arr[i] may be present at arr[i+1] or arr[i-1] i.e. arr[i] can only be swapped with either arr[i+1] or arr[i-1].
 The task is to search for an element in this array.
 */
public class SearchElementInNearlySortedArray7 {

    public static int searchNearlySorted(int[] arr, int element) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == element)
                return mid;
            if (mid - 1 >= start && arr[mid - 1] == element)
                return mid - 1;
            if (mid + 1 <= end && arr[mid + 1] == element)
                return mid + 1;
            if (arr[mid] > element)
                end = mid - 2;
            else
                start = mid + 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 30, 20, 40};
        System.out.println(searchNearlySorted(arr, 30));
    }

}
