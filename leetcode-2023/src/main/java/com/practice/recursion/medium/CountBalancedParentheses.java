package com.practice.recursion.medium;

public class CountBalancedParentheses {

    private static int ans = 0;

    public static void main(String[] args) {
        int n = 3;
        solve("", n, n);
        System.out.println(ans);
    }

    private static void solve(String op, int open, int close) {

        if (open == 0 && close == 0) {
            ans++;
            return;
        }

        if (open != 0) {
            solve(op + "(", open - 1, close);
        }
        if (close > open) {
            solve(op + ")", open, close - 1);
        }
    }
}
