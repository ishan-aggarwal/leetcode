package com.practice.recursion.functional;

// When we want our recursive function to return the results
// f(n) -> sum of first n natural numbers
// f(n) -> n + f(n-1) when n > 0
//      -> n when n = 0


public class SumOfFirstNNaturalNumbers {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(sum(n));
    }

    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);
    }
}
