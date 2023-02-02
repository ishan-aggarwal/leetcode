package com.practice.binarysearch;

/*
Given a bitonic sequence of n distinct elements, and an integer x, the task is to write a program to find given element x in the bitonic sequence in O(log n) time.
A Bitonic Sequence is a sequence of numbers that is first strictly increasing then after a point decreasing.
 */
public class SearchElementBitonic {

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

    public static int binarySearchDesc(int[] arr, int start, int end, int element) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == element)
                return mid;
            if (arr[mid] < element)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static int findPeak(int[] nums, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // Avoiding first and last element of an array to avoid array out of bound exception, checking this separately for first and last element
            if (mid > 0 && mid < nums.length - 1) {
                // If current element is greater than both its neighbours then this is the peak element
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                    return mid;
                // If next element is greater than the previous element then search in right part of the array
                if (nums[mid] < nums[mid + 1])
                    start = mid + 1;
                    // If previous element is greater than the previous element then search in left part of the array
                else
                    end = mid - 1;
            } else if (mid == 0) {
                if (nums.length == 1 || nums[0] >= nums[1])
                    return 0;
                return 1;
            } else {
                if (nums[nums.length - 2] <= nums[nums.length - 1])
                    return nums.length - 1;
                return nums.length - 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 12, 8, 2};
        int element = 8;
        int peakIndex = findPeak(arr, 0, arr.length - 1);
        int first = binarySearchAsc(arr, 0, peakIndex, element);
        int second = binarySearchDesc(arr, peakIndex, arr.length - 1, element);
        if (first == -1 && second == -1)
            System.out.println(-1);
        else if (first == -1)
            System.out.println(second);
        else
            System.out.println(first);
    }
}
