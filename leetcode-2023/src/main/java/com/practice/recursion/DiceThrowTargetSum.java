package com.practice.recursion;

public class DiceThrowTargetSum {

    public static void main(String[] args) {
        int targetSum = 4;
        solve(targetSum, "");
    }

    public static void solve(int targetSum, String op) {

        if (targetSum == 0) {
            System.out.println(op);
            return;
        }

        for (int i = 1; i <= 6 && i <= targetSum; i++) {
            solve(targetSum - i, op + i);
        }
    }
}
