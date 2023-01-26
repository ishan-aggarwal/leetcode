package com.practice.slidingwindow.fixed;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumOfDistinctSubarrayWithLengthK {

    public static void main(String[] args) {
        int[] input = new int[]{1, 5, 4, 2, 9, 9, 9};
        System.out.println(maximumSubarraySum(input, 3));
    }

    public static long maximumSubarraySum(int[] nums, int k) {

        int left = 0, right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        long ans = Integer.MIN_VALUE;

        while (right < nums.length) {
            int ele = nums[right];

            sum += ele;
            map.put(ele, map.getOrDefault(ele, 0) + 1);

            if (right - left + 1 < k) {
                right++;
            } else if (right - left + 1 == k) {
                if (map.size() == k) {
                    ans = Math.max(ans, sum);
                }

                int leftEle = nums[left];
                if (map.containsKey(leftEle)) {
                    map.put(leftEle, map.get(leftEle) - 1);
                    if (map.get(leftEle) == 0) {
                        map.remove(leftEle);
                    }
                }
                sum -= leftEle;
                left++;
                right++;
            }
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}