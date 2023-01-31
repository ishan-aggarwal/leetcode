package com.practice.recursion.medium;

// https://leetcode.com/problems/combination-sum/

import java.util.ArrayList;
import java.util.List;

// TC - O(k * 2 ^ t)
// where k is another constant assuming that we need to copy the current solution to the final results
// and this we need to do 2 ^ t (times) reason for taking t and not n is because there are not just 2 choices for every index
// even after picking element at an index, we can again pick the same element and unlimited number of times...

public class CombinationSumI {

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int targetSum = 7;

        List<List<Integer>> results = combinationSum(candidates, targetSum);
        results.stream().forEach(System.out::println);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> current = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        solve(candidates, 0, target, current, results);
//        solve1(candidates, 0, target, current, results);
        return results;
    }

    private static void solve(int[] candidates, int index, int targetSum, List<Integer> current, List<List<Integer>> results) {

        if (index >= candidates.length || targetSum <= 0) {
            if (targetSum == 0) {
                results.add(new ArrayList<>(current));
            }
            return;
        }

        int ele = candidates[index];
        current.add(ele);
        solve(candidates, index, targetSum - ele, current, results);
        current.remove(current.size() - 1);
        solve(candidates, index + 1, targetSum, current, results);
    }

    private static void solve1(int[] candidates, int index, int targetSum, List<Integer> current, List<List<Integer>> results) {

        if (index >= candidates.length) {
            if (targetSum == 0) {
                results.add(new ArrayList<>(current));
            }
            return;
        }

        int ele = candidates[index];

        if (ele <= targetSum) {
            current.add(ele);
            solve(candidates, index, targetSum - ele, current, results);
            current.remove(current.size() - 1);
        }
        solve(candidates, index + 1, targetSum, current, results);
    }
}
