package com.practice.recursion.parameterized;

public class FactorialOfN {

    public static void main(String[] args) {
        fact(5, 1);
    }

    private static void fact(int num, int fact) {
        if (num < 1) {
            System.out.println(fact);
            return;
        }
        fact(num - 1, num * fact);
    }
}
