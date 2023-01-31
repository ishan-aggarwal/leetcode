package com.practice.recursion.easy;

import java.util.ArrayList;
import java.util.List;

public class CountSubsequenceWithTargetSum<T> {

    // We are using the ip-op method here to print all the sub-sequences
    // A sub-sequence is a contiguous or non-contiguous sequence that follows the order.
    // We will have the choice diagram to form the recursion tree
    // We have two choices for each of the element/char in the input string - either to take the character in output or not take it.
    // TC - O(2^n) where n is the length of the string and since we are printing each of these sub-sequences where n being the max length of sub-sequence
    // we may call it like O(n * 2^n)
    // depth of the recursion tree contributes to SC which is O(n)

    public static void main(String[] args) {

        CountSubsequenceWithTargetSum<Integer> object = new CountSubsequenceWithTargetSum<>();
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(1);
        List<Integer> current = new ArrayList<>();
        int targetSum = 2;
        int count = object.generateSubsequences(input, 0, current, targetSum);
        System.out.println(count);
    }

    private int generateSubsequences(List<T> input, int index, List<T> current, int targetSum) {
        if (input == null || input.isEmpty() || index == input.size()) {
            if (targetSum == 0) {
                return 1;
            }
            return 0;
        }

        T element = input.get(index);
        // case where the element is taken, then reduce the targetSum with the element value
        current.add(element);
        int leftValue = generateSubsequences(input, index + 1, current, targetSum - (Integer) element);
        // case where the element is not taken, then targetSum remains same
        current.remove(element);
        int rightValue = generateSubsequences(input, index + 1, current, targetSum);
        return leftValue + rightValue;
    }
}
