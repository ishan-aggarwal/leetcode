package com.practice.recursion;


// Print all permutations with space option
// To include a space is only allowed in between (i.e n-1 places where n is the length of the string)
public class PrintPermutationsWithSpaces {

    public static void main(String[] args) {
        String input = "ABC";
        String op = "";
        op = op + input.charAt(0);
        subsetsWithSpaces(op, input.substring(1));
    }

    private static void subsetsWithSpaces(String op, String ip) {
        if (ip.isEmpty()) {
            System.out.println(op);
            return;
        }

        char ch = ip.charAt(0);
        subsetsWithSpaces(op + ch, ip.substring(1));
        subsetsWithSpaces(op + " " + ch, ip.substring(1));
    }
}
