package com.practice.recursion.medium;

// https://leetcode.com/problems/combination-sum-ii/

import java.util.*;

// TC - O(k * 2 ^ t)
// where k is another constant assuming that we need to copy the current solution to the final results
// and this we need to do 2 ^ t (times) reason for taking t and not n is because there are not just 2 choices for every index
// even after picking element at an index, we can again pick the same element and unlimited number of times...

public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int targetSum = 8;

        List<List<Integer>> results = combinationSum2(candidates, targetSum);
        results.stream().forEach(System.out::println);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, 0, target, current, answer);
        return answer;
    }

    private static void solve(int[] candidates, int index, int targetSum, List<Integer> current, List<List<Integer>> results) {
        if (targetSum == 0) {
            results.add(new ArrayList<>(current));
            return;
        } else if (targetSum < 0) {
            return;
        }

        int prevEle = -1;
        for (int i = 0; i < candidates.length; i++) {
            int ele = candidates[i];
            if (ele == prevEle) {
                continue;
            }
            if (ele <= targetSum) {
                current.add(ele);
                solve(candidates, index + 1, targetSum - ele, current, results);
                current.remove(current.size() - 1);
            }
            solve(candidates, index + 1, targetSum, current, results);
            prevEle = ele;
        }
    }
}
