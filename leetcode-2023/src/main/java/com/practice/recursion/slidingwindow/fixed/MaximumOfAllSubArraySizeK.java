package com.practice.recursion.slidingwindow.fixed;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllSubArraySizeK {


    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] ans = solve(arr, k);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] solve(int[] arr, int k) {

        int left = 0, right = 0;
        int[] ans = new int[arr.length - k + 1];
        Deque<Integer> temp = new LinkedList<>();
        int ptr = 0;
        while (right < arr.length) {
            int ele = arr[right];
            while (!temp.isEmpty() && temp.peekLast() < ele) {
                temp.removeLast();
            }
            temp.addLast(ele);

            if (right - left + 1 < k) {
                right++;
            } else if (right - left + 1 == k) {
                ans[ptr++] = temp.peekFirst();
                if (arr[left] == temp.peekFirst()) {
                    temp.removeFirst();
                }
                left++;
                right++;
            }
        }
        return ans;
    }
}
