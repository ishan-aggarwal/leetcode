package com.practice.recursion.parameterized;

// When we don't want our recursive function to return anything
// and take the computation as part of recursive function itself

// tail recursion
// reduces the changes of stack overflow error - where we have the recursive function call as the last statement in function

// Backtracking
// if we have some statements written after the function call then those statements would get executed at the last of recursion
// means when the function call gets returned after doing its work
// this is nothing but backtracking

public class SumOfFirstNNaturalNumbers {

    public static void main(String[] args) {
        int n = 3;
        sum(n, 0);
    }

    public static void sum(int cnt, int sum) {
        if (cnt < 1) {
            System.out.println(sum);
            return;
        }
        sum(cnt - 1, sum + cnt);
    }
}
