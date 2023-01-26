package com.practice.slidingwindow.variable;

import java.util.Arrays;

// Find largest sub array (left and right pos) in given array with sub same as k

public class LargestSubArrayOfSumK {

    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 2, 1, 8};
        System.out.println(Arrays.toString(solve(arr, 9)));
        int[] arr1 = {1, 1, 1, 1, 2, 3};
        System.out.println(Arrays.toString(solve(arr1, 5)));
    }

    private static int[] solve(int[] arr, int targetSum) {

        int left = 0, right = 0;
        int ansI = -1, ansJ = -1;
        int largestSubArraySizeWithGivenSum = Integer.MIN_VALUE;
        int sum = 0;

        while (right < arr.length) {

            sum += arr[right];
            if (sum < targetSum) {
                right++;
            } else if (sum >= targetSum) {
                while (sum > targetSum) {
                    sum -= arr[left];
                    left++;
                }
                if (sum == targetSum) {
                    if (right - left + 1 > largestSubArraySizeWithGivenSum) {
                        largestSubArraySizeWithGivenSum = right - left + 1;
                        ansI = left;
                        ansJ = right;
                    }
                }
                right++;
            }
        }

        if (ansI == -1) {
            return new int[]{-1, -1};
        }

        return new int[]{ansI, ansJ};
    }
}
