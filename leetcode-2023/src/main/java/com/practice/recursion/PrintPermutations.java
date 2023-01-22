package com.practice.recursion;

public class PrintPermutations {

    public static void main(String[] args) {
        String ip = "ABC";
        String op = "";
        permutations(op, ip);
//        permutations(op + ip.charAt(0), ip.substring(1));
    }

    private static void permutations(String op, String ip) {

        if (ip.isEmpty()) {
            System.out.println(op);
            return;
        }

        char ch = ip.charAt(0);
        for (int i = 0; i <= op.length(); i++) {
            String f = op.substring(0, i);
            String s = op.substring(i);
            permutations(f + ch + s, ip.substring(1));
        }
    }
}
