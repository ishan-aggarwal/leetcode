package com.practice.recursion.easy;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequence<T> {

    // We are using the ip-op method here to print all the sub-sequences
    // A sub-sequence is a contiguous or non-contiguous sequence that follows the order.
    // We will have the choice diagram to form the recursion tree
    // We have two choices for each of the element/char in the input string - either to take the character in output or not take it.
    // TC - O(2^n) where n is the length of the string and since we are printing each of these sub-sequences where n being the max length of sub-sequence
    // we may call it like O(n * 2^n)
    // depth of the recursion tree contributes to SC which is O(n)

    public static void main(String[] args) {
        String str = "312";
        printSubsequence(str, "");

        System.out.println("-------------------------------------");
        PrintSubsequence<Integer> object = new PrintSubsequence<>();
        List<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(1);
        input.add(2);
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        object.generateSubsequences(input, 0, current, output);

        for (List<Integer> subsequence : output) {
            System.out.println(subsequence);
        }
    }

    private void generateSubsequences(List<T> input, int index, List<T> current, List<List<T>> output) {
        if (input == null || input.isEmpty() || index == input.size()) {
            output.add(new ArrayList<>(current));
            return;
        }

        T element = input.get(index);
        // case where the element is taken
        current.add(element);
        generateSubsequences(input, index + 1, current, output);
        // case where the element is not taken
        current.remove(element);
        generateSubsequences(input, index + 1, current, output);
    }

    private static void printSubsequence(String ip, String op) {

        if (ip == null || ip.isEmpty()) {
            System.out.println("{" + op + "}");
            return;
        }

        char ch = ip.charAt(0);
        printSubsequence(ip.substring(1), op);
        printSubsequence(ip.substring(1), op + ch);

    }
}
