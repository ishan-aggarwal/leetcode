package com.practice.stack;

import java.util.Arrays;
import java.util.Stack;

public class MaximumAreaRectangleBinaryMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 1, 0, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 0}};
        int rows = matrix.length;
        int cols = matrix[0].length;

        int answer = Integer.MIN_VALUE;

        int[] histogram = new int[cols];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                if (i == rows - 1) {
                    histogram[j] = matrix[i][j];
                } else {
                    if (matrix[i][j] == 0) {
                        histogram[j] = 0;
                    } else {
                        histogram[j] += 1;
                    }
                }
            }

//            System.out.println("arr: " + Arrays.toString(histogram));
            int[] nsl = computeNearestSmallestIndicesLeft(histogram);
            int[] nsr = computeNearestSmallestIndicesRight(histogram);
//            System.out.println("nsl: " + Arrays.toString(nsl));
//            System.out.println("nsr: " + Arrays.toString(nsr));

            for (int k = 0; k < histogram.length; k++) {
                int width = nsr[k] - nsl[k] - 1;
                answer = Math.max(answer, width * histogram[k]);
            }
        }
        System.out.println(answer);
    }

    // 1, 2, 2, 1
    private static int[] computeNearestSmallestIndicesRight(int[] histogram) {
        int[] nsr = new int[histogram.length];
        Stack<Integer> stack = new Stack<>();
        int right = histogram.length - 1;
        while (right >= 0) {
            int ele = histogram[right];
            if (stack.isEmpty()) {
                nsr[right] = histogram.length;
            } else {
                while (!stack.isEmpty() && ele <= histogram[stack.peek()]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    nsr[right] = histogram.length;
                } else {
                    nsr[right] = stack.peek();
                }
            }
            stack.push(right);
            right--;
        }
        return nsr;
    }

    private static int[] computeNearestSmallestIndicesLeft(int[] histogram) {
        int[] nsl = new int[histogram.length];
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        while (left < histogram.length) {
            int ele = histogram[left];
            if (stack.isEmpty()) {
                nsl[left] = -1;
            } else {
                while (!stack.isEmpty() && ele <= histogram[stack.peek()]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    nsl[left] = -1;
                } else {
                    nsl[left] = stack.peek();
                }
            }
            stack.push(left);
            left++;
        }
        return nsl;
    }

}
