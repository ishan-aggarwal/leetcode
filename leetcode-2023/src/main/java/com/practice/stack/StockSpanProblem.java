package com.practice.stack;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/online-stock-span/

public class StockSpanProblem {

    // consecutive smaller on to the left for a given day price
    // so here we want to find the nearest larger element that is on the left of any element
    // and all the elements between those two would be lesser than or equal to the element (and contribute to the answer)
    // Monotonic stack
    // elements are in decreasing order

    public static void main(String[] args) {
        int[] arr = new int[]{100, 80, 60, 70, 60, 75, 85};
        // [1, 1, 1, 2, 1, 4, 6]
        System.out.println(Arrays.toString(solve(arr)));
        System.out.println(Arrays.toString(solve1(arr)));
    }

    private static int[] solve1(int[] arr) {

        int[] ans = new int[arr.length];
        int left = 0;
        Stack<int[]> stack = new Stack<>();

        while (left < arr.length) {
            int temp = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= arr[left] ) {
                temp += stack.peek()[1];
                stack.pop();
            }
            stack.push(new int[] {arr[left], temp});
            ans[left] = temp;
            left++;
        }
        return ans;
    }

    private static int[] solve(int[] arr) {

        int[] ans = new int[arr.length];
        int left = 0;
        Stack<Integer> stack = new Stack<>();

        while (left < arr.length) {
            if (stack.isEmpty()) {
                ans[left] = 1;
            } else {
                while (!stack.isEmpty() && arr[stack.peek()] <= arr[left]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ans[left] = 1;
                } else {
                    ans[left] = left - stack.peek();
                }
            }
            stack.push(left);
            left++;
        }
        return ans;
    }
}
