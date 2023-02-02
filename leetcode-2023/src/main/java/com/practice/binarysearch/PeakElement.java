package com.practice.binarysearch;

//Find a peak element
public class PeakElement {

    public static int findPeak(int[] nums, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // Avoiding first and last element of an array to avoid array out of bound
            // exception, checking this separately for first and last element
            if (mid > 0 && mid < nums.length - 1) {
                // If current element is greater than both its neighbours then this is the peak
                // element
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                    return mid;
                // If next element is greater than the previous element then search in right
                // part of the array
                if (nums[mid] < nums[mid + 1])
                    start = mid + 1;
                    // If previous element is greater than the previous element then search in left
                    // part of the array
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
        int[] arr = {5, 10, 20, 15};
        System.out.println(findPeak(arr, 0, arr.length - 1));
    }

}