package com.practice.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerToRight {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 4};
        // [-1, 2, -1, -1]
        System.out.println(Arrays.toString(solve(arr)));

        int[] arr1 = new int[]{1, 2, 3, 4, 3};
        // [-1, -1, -1, 3, -1]
        System.out.println(Arrays.toString(solve(arr1)));
    }

    private static int[] solve(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int right = arr.length - 1;

        while (right >= 0) {
            int rightElement = arr[right];
            if (stack.isEmpty()) {
                ans[right] = -1;
            } else {
                while (!stack.isEmpty() && rightElement <= stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ans[right] = -1;
                } else {
                    ans[right] = stack.peek();
                }
            }
            stack.push(rightElement);
            right--;
        }
        return ans;
    }
}
