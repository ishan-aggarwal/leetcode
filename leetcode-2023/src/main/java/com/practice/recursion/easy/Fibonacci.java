package com.practice.recursion.easy;


// Example of multiple recursive calls at each iteration
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(nthFibonacciNumber(5));
    }

    private static int nthFibonacciNumber(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return nthFibonacciNumber(n - 1) + nthFibonacciNumber(n - 2);
    }
}
