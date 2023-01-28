package com.practice.stack;

public class RainWaterTrapping {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 0, 0, 2, 0, 4};
        int ans = calculateRainWaterTrapped(arr);
        System.out.println(ans);
    }

    private static int calculateRainWaterTrapped(int[] input) {

        if (input == null || input.length == 0) {
            return 0;
        }

        int[] leftMax = new int[input.length];
        int[] rightMax = new int[input.length];

        int n = input.length;

        leftMax[0] = input[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], input[i]);
        }

        rightMax[n - 1] = input[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], input[i]);
        }

        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - input[i];
        }

        return totalWater;
    }
}
