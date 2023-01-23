package com.practice.recursion;

public class PrintPermutationsWithCaseChangeIncludingDigits {

    // output:
    //    a1b2
    //    a1B2
    //    A1b2
    //    A1B2

    public static void main(String[] args) {
        String ip = "a1B2";
        String op = "";
        permutations(op, ip);
    }

    private static void permutations(String op, String ip) {

        if (ip.isEmpty()) {
            System.out.println(op);
            return;
        }

        char ch = ip.charAt(0);

        if (Character.isDigit(ch)) {
            permutations(op + ch, ip.substring(1));
        } else {
            String op1 = op + Character.toLowerCase(ch);
            String op2 = op + Character.toUpperCase(ch);
            permutations(op1, ip.substring(1));
            permutations(op2, ip.substring(1));
        }
    }
}
