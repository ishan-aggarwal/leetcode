package com.practice.slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

// find the smallest length sub string that has all the characters of pattern inside it
public class MinimumWindowSubstringWithGivenChars {

    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String pattern = "ABC";
        System.out.println(solve(str, pattern));
    }

    private static String solve(String str, String pattern) {

        int left = 0, right = 0;
        int ansI = -1, ansJ = -1;
        int smallestLengthSubString = Integer.MAX_VALUE;
        Map<Character, Integer> patternFreqMap = new HashMap<>();
        for (char ch : pattern.toCharArray()) {
            patternFreqMap.put(ch, patternFreqMap.getOrDefault(ch, 0) + 1);
        }
        int count = patternFreqMap.size();

        while (right < str.length()) {
            char ch = str.charAt(right);
            if (patternFreqMap.containsKey(ch)) {
                patternFreqMap.put(ch, patternFreqMap.get(ch) - 1);
                if (patternFreqMap.get(ch) == 0) {
                    count--;
                }
            }
            if (count > 0) {
                right++;
            } else if (count == 0) {  // we have found sub-string where we are able to get match the frequency of each of the char of given pattern

                // try n shrink the window from left till the time count remains zero
                // and keep storing the pointers in your answer
                while (count == 0) {

                    // store the current answer so far
                    if (right - left + 1 < smallestLengthSubString) {
                        smallestLengthSubString = right - left + 1;
                        ansI = left;
                        ansJ = right;
                    }

                    // try n shrink the window
                    char leftChar = str.charAt(left);
                    if (patternFreqMap.containsKey(leftChar)) {
                        patternFreqMap.put(leftChar, patternFreqMap.get(leftChar) + 1);
                        if (patternFreqMap.get(str.charAt(left)) == 1)
                            count++;
                    }
                    left++;
                }

                // window will keep on increasing from the right side
                right++;
            }
        }
        return (ansI == -1) ? "" : str.substring(ansI, ansJ + 1);
    }
}
