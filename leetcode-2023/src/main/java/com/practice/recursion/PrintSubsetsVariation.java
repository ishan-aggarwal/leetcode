package com.practice.recursion;

public class PrintSubsetsVariation {

    public static void main(String[] args) {
        subsets("", "ABC");
    }

    private static void subsets(String op, String ip) {

        if (ip.isEmpty()) {
            System.out.println(op);
            return;
        }

        char ch = ip.charAt(0);
        subsets(op + ch, ip.substring(1));
        subsets(op + "_" + ch, ip.substring(1));
    }
}
