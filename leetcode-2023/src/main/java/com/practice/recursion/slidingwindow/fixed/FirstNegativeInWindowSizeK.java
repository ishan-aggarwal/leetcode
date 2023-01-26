package com.practice.recursion.slidingwindow.fixed;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeInWindowSizeK {

    public static void main(String[] args) {
        int[] arr = {12, -1, -2, 8, -16, 30, 16, 28};
        int k = 3;

        int[] ans = solve(arr, k);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] solve(int[] arr, int k) {
        int[] ans = new int[arr.length - k + 1];
        Queue<Integer> negatives = new LinkedList<>();
        int left = 0, right = 0;
        int ptr = 0;
        while (right < arr.length) {

            int ele = arr[right];
            if (ele < 0) {
                negatives.add(ele);
            }

            if (right - left + 1 < k) {
                right++;
            } else if (right - left + 1 == k) {
                if (negatives.isEmpty()) {
                    ans[ptr++] = 0;
                } else {
                    ans[ptr++] = negatives.peek();
                    if (arr[left] == negatives.peek()) {
                        negatives.remove();
                    }
                }
                left++;
                right++;
            }
        }
        return ans;
    }

}
