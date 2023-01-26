package com.practice.recursion.medium;

public class PrintBalancedParentheses {

    public static void main(String[] args) {
        int n = 3;
        solve("", n, n);
    }

    private static void solve(String op, int open, int close) {

        if (open == 0 && close == 0) {
            System.out.println(op);
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
