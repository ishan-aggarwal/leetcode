package com.practice.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerToLeft {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 4};
        // [-1, 1, 1, 2]
        System.out.println(Arrays.toString(solve(arr)));

        int[] arr1 = new int[]{1, 2, 3, 4, 3};
        // [-1, 1, 2, 3, 2]
        System.out.println(Arrays.toString(solve(arr1)));
    }

    private static int[] solve(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int left = 0;

        while (left < arr.length) {
            int leftElement = arr[left];
            if (stack.isEmpty()) {
                ans[left] = -1;
            } else {
                while (!stack.isEmpty() && leftElement <= stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ans[left] = -1;
                } else {
                    ans[left] = stack.peek();
                }
            }
            stack.push(leftElement);
            left++;
        }
        return ans;
    }
}
