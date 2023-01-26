package com.practice.stack;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/next-greater-element-ii/

public class NearestGreaterToRight2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 4};
        // [3, 4, 4, -1]
        System.out.println(Arrays.toString(solve(arr)));

        int[] arr1 = new int[]{1, 2, 3, 4, 3};
        // [2, 3, 4, -1, -1]
        System.out.println(Arrays.toString(solve(arr1)));
    }

    private static int[] solve(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int right = arr.length - 1;

        // we are scanning from the right
        while (right >= 0) {

            // holds the current right most element
            int rightEle = arr[right];

            // if there are no elements on the right which are present in the stack
            // that means we can put -1 in the ans array
            if (stack.isEmpty()) {
                ans[right] = -1;
            } else {
                // otherwise if the stack is not empty
                // then we need to see if the current element is greater than the one on top of the stack...
                // then we can remove the top element of the stack as we have found new greater element
                // which will be closer to the elements on its left
                // and keep repeating the process
                while (!stack.isEmpty() && rightEle >= stack.peek()) {
                    stack.pop();
                }

                // if by doing the above steps, the stack becomes empty
                // that means there was no greater element to the right of the current element
                // so again push -1 in the answer for current index
                // otherwise simply use the top most element of stack and push it in ans
                if (stack.isEmpty()) {
                    ans[right] = -1;
                } else {
                    ans[right] = stack.peek();
                }
            }

            // finally we need to insert the right most element in the stack
            // and decrease the right pointer as well.
            stack.push(rightEle);
            right--;
        }
        return ans;
    }
}
