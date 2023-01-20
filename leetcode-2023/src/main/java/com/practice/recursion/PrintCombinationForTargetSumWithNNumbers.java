package com.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintCombinationForTargetSumWithNNumbers {

    public static void main(String[] args) {
        int n = 3;
        int targetSum = 9;

        solve(n, targetSum, "");

        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        getResult(n, targetSum, current, answer);
        answer.stream().forEach(System.out::println);
    }

    private static void getResult(int n, int targetSum, List<Integer> current, List<List<Integer>> answer) {

        if (n == 0 && targetSum == 0) {
            answer.add(new ArrayList<>(current));
            return;
        }

        if (n < 0 || targetSum < 0) return;

        for (int i = 0; i <= targetSum; i++) {
            current.add(i);
            getResult(n - 1, targetSum - i, current, answer);
            current.remove(current.size() - 1);
        }
    }

    public static void solve(int n, int targetSum, String op) {

        if (n == 0 && targetSum == 0) {
            System.out.println(op);
            return;
        }

        if (n < 0 || targetSum < 0) {
            return;
        }

        for (int i = 0; i <= targetSum; i++) {
            solve(n - 1, targetSum - i, op + i);
        }
    }
}
