package com.practice.recursion;

public class PrintPermutationsWithCaseChange {

    public static void main(String[] args) {
        String ip = "abc";
        String op = "";
        permutations(op, ip);
    }

    private static void permutations(String op, String ip) {

        if (ip.isEmpty()) {
            System.out.println(op);
            return;
        }

        char ch = ip.charAt(0);
        String op1 = op + Character.toLowerCase(ch);
        String op2 = op + Character.toUpperCase(ch);

        permutations(op1, ip.substring(1));
        permutations(op2, ip.substring(1));

    }
}
