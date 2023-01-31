package com.practice.recursion.easy;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequenceWithTargetSum<T> {

    // We are using the ip-op method here to print all the sub-sequences
    // A sub-sequence is a contiguous or non-contiguous sequence that follows the order.
    // We will have the choice diagram to form the recursion tree
    // We have two choices for each of the element/char in the input string - either to take the character in output or not take it.
    // TC - O(2^n) where n is the length of the string and since we are printing each of these sub-sequences where n being the max length of sub-sequence
    // we may call it like O(n * 2^n)
    // depth of the recursion tree contributes to SC which is O(n)

    public static void main(String[] args) {

        PrintSubsequenceWithTargetSum<Integer> object = new PrintSubsequenceWithTargetSum<>();
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(1);
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        int targetSum = 2;
        object.generateSubsequences(input, 0, current, output, targetSum);

        for (List<Integer> subsequence : output) {
            System.out.println(subsequence);
        }
    }

    private void generateSubsequences(List<T> input, int index, List<T> current, List<List<T>> output, int targetSum) {
        if (input == null || input.isEmpty() || index == input.size()) {
            if (targetSum == 0) {
                output.add(new ArrayList<>(current));
            }
            return;
        }

        T element = input.get(index);
        // case where the element is taken, then reduce the targetSum with the element value
        current.add(element);
        generateSubsequences(input, index + 1, current, output, targetSum - (Integer) element);
        // case where the element is not taken, then targetSum remains same
        current.remove(element);
        generateSubsequences(input, index + 1, current, output, targetSum);
    }
}
