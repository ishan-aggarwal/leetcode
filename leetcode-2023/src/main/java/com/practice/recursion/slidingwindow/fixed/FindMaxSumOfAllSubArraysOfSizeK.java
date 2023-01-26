package com.practice.recursion.slidingwindow.fixed;

public class FindMaxSumOfAllSubArraysOfSizeK {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 2, 9, 7, 1};
        int k = 3;

        int max = solve(arr, k);
        // ans should be 18 for sub-array {2, 9, 7} as this is the maximum sum for any sub-array for given size k
        System.out.println(max);
    }

    private static int solve(int[] arr, int k) {

        // pointers to maintain start and end of the sliding window
        int left = 0, right = 0;
        // variable to hold the answer
        int ans = Integer.MIN_VALUE;
        // sum to hold the sum of current on-going window
        int sum = 0;

        // while we have not reached till the end
        while (right < arr.length) {
            // add current right value to sum
            sum += arr[right];
            // if not reached the size of sliding window
            // just increase the right side
            if (right - left + 1 < k) {
                right++;
            } else if (right - left + 1 == k) { // once we have reached the size of sliding window, we need to increase both the variables, but need addition logic
                // first find the answer till now to hold the maxSum so far for the sub-arrays
                ans = Math.max(ans, sum);
                // as we are going to slide, so we reduce the sum of the left most element from sum variable
                sum -= arr[left];
                // finally increase both the pointers to slide the window
                left++;
                right++;
            }
        }

        // here, we finally return the sum
        return ans;
    }
}
