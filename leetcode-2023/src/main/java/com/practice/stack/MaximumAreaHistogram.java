package com.practice.stack;

import java.util.Stack;

public class MaximumAreaHistogram {

    public static void main(String[] args) {
        int[] input = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println("Implementation 1: " + largestRectangleArea(input));
        System.out.println("Implementation 2: " + largestRectangleArea1(input));
    }

    // as we need to find the nearest smallest indices on the right
    // and if there is nothing smallest available on the right
    // then we will mark arr.length in place of the index
    private static int[] nearestSmallestIndicesRight(int[] input) {
        int[] ans = new int[input.length];
        Stack<Integer> stack = new Stack<>();
        int right = input.length - 1;
        while (right >= 0) {
            int ele = input[right];
            if (stack.isEmpty()) {
                ans[right] = input.length; // instead of -1
            } else {
                while (!stack.isEmpty() && input[stack.peek()] > ele) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ans[right] = input.length; // instead of -1
                } else {
                    ans[right] = stack.peek();
                }
            }
            stack.push(right);
            right--;
        }
//        System.out.println(stack);
//        System.out.println(Arrays.toString(ans));
        return ans;
    }

    private static int[] nearestSmallestIndicesLeft(int[] input) {
        int[] ans = new int[input.length];
        Stack<Integer> stack = new Stack<>();
        // -1, -1, 1, 2, 1, 4
        // 1, 4, 5
        int left = 0;
        while (left < input.length) {
            int ele = input[left];
            if (stack.isEmpty()) {
                ans[left] = -1;
            } else {
                while (!stack.isEmpty() && input[stack.peek()] > ele) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ans[left] = -1;
                } else {
                    ans[left] = stack.peek();
                }
            }
            stack.push(left);
            left++;
        }
//        System.out.println(stack);
//        System.out.println(Arrays.toString(ans));
        return ans;
    }

    private static int largestRectangleArea(int[] input) {
        if (input.length == 1) {
            return input[0];
        }

        long maxArea = Long.MIN_VALUE;
        int[] nsl = computeNearestSmallestLeft(input);
        int[] nsr = computeNearestSmallestRight(input);

        for (int i = 0; i < input.length; i++) {
            int height = input[i];
            int width = nsr[i] - nsl[i] - 1; // for (a,b) where both boundary elements are not included total width would be b - a - 1
            maxArea = Math.max(maxArea, 1l * width * height);
        }
        return (int) maxArea;
    }

    private static int largestRectangleArea1(int[] input) {
        if (input.length == 1) {
            return input[0];
        }

        long maxArea = Long.MIN_VALUE;
        int[] nsl = nearestSmallestIndicesLeft(input);
        int[] nsr = nearestSmallestIndicesRight(input);

        for (int i = 0; i < input.length; i++) {
            int height = input[i];
            int width = nsr[i] - nsl[i] - 1; // for (a,b) where both boundary elements are not included total width would be b - a - 1
            maxArea = Math.max(maxArea, 1l * width * height);
        }
        return (int) maxArea;
    }

    private static int[] computeNearestSmallestRight(int[] A) {
        int[] nsr = new int[A.length];
        Stack<Integer> stack = new Stack<>();

        int idx = A.length - 1;
        for (int i = A.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nsr[idx--] = A.length;
            } else {
                nsr[idx--] = stack.peek();
            }

            stack.push(i);
        }
//        System.out.println(Arrays.toString(nsr));
        return nsr;

    }

    private static int[] computeNearestSmallestLeft(int[] A) {
        int[] nsl = new int[A.length];
        Stack<Integer> stack = new Stack<>();

        int idx = 0;
        for (int i = 0; i < A.length; i++) {

            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nsl[idx++] = -1;
            } else {
                nsl[idx++] = stack.peek();
            }

            stack.push(i);
        }
//        System.out.println(Arrays.toString(nsl));
        return nsl;
    }

}
