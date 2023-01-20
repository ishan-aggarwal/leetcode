package com.practice.recursion;


// Print all subsets

public class PrintSubsets {

    public static void main(String[] args) {
        String input = "ABC";
        subsets("", input);
    }

    private static void subsets(String op, String ip) {
        if (ip.isEmpty()) {
            System.out.println(op);
            return;
        }

        char ch = ip.charAt(0);
        subsets(op, ip.substring(1));
        subsets(op + ch, ip.substring(1));
    }
}
