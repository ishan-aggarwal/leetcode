package com.practice.slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/fruit-into-baskets/
public class PickToysWithMaxTypesK {

    public static void main(String[] args) {
        String str = "abaccaaaccbbbbbbbb";
        int k = 2;
        System.out.println(solve(str, k));

//        String str = "333333";
//        int k = 2;
//        System.out.println(solve(str, k));
    }

    private static int solve(String str, int k) {
        int left = 0, right = 0;
        int answer = Integer.MIN_VALUE;
        int ansI = -1, ansJ = -1;
        Map<Character, Integer> map = new HashMap<>();

        while (right < str.length()) {

            char ch = str.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.size() < k) {
                if (right - left + 1 > answer) {
                    answer = right - left + 1;
                    ansI = left;
                    ansJ = right;
                }
                right++;
            } else if (map.size() >= k) {

                if (map.size() == k) {
                    if (right - left + 1 > answer) {
                        answer = right - left + 1;
                        ansI = left;
                        ansJ = right;
                    }
                }

                while (map.size() > k) {
                    char leftChar = str.charAt(left);
                    if (map.containsKey(leftChar)) {
                        map.put(leftChar, map.get(leftChar) - 1);
                        if (map.get(leftChar) == 0) {
                            map.remove(leftChar);
                        }
                    }
                    left++;
                }

                right++;
            }
        }

        return (ansI == -1) ? 0 : (ansJ - ansI + 1);
    }
}
