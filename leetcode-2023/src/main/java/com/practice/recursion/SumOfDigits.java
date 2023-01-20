package com.practice.recursion;

public class SumOfDigits {

    public static void main(String[] args) {
        System.out.println(sod(1234));
    }

    public static int sod(int number) {
        if (number <= 9) {
            return number;
        }
        return (number % 10) + sod(number / 10);
    }
}
