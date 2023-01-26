package com.practice.recursion.slidingwindow.fixed;

public class FindMaxSumOfAllSubArraysOfSizeK {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 2, 9, 7, 1};
        int k = 3;

        int max = solve(arr, k);
        // ans should be 18 for sub-array {2, 9, 7}
        System.out.println(max);
    }

    private static int solve(int[] arr, int k) {

        int left = 0, right = 0;
        int ans = Integer.MIN_VALUE;
        int sum = 0;

        while (right < arr.length) {
            sum += arr[right];
            if (right - left + 1 < k) {
                right++;
            } else if (right - left + 1 == k) {
                ans = Math.max(ans, sum);
                sum -= arr[left];
                left++;
                right++;
            }
        }
        return ans;
    }
}
