package com.practice.recursion;

public class ReverseNumber {

    private static int ans = 0;

    public static void main(String[] args) {
        reverseNum(1234);
        System.out.println(ans);
    }

    private static void reverseNum(int number) {

        if (number == 0) {
            return;
        }

        ans = (ans * 10) + (number % 10);
        reverseNum(number / 10);
    }
}
