package com.practice.slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

// Largest Substring With No Repeating Character
public class LargestSubstringWithNoRepeatingCharacter {
    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(solve(str));
    }

    private static String solve(String str) {

        int left = 0, right = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int ansI = -1, ansJ = -1;
        int longestSubStringSize = Integer.MIN_VALUE;

        while (right < str.length()) {

            char ch = str.charAt(right);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

            // to find the largest sub string with all unique characters
            // means the size of frequency map is equal to the size of window so far
            // and then persist the size and update the variables of start and end accordingly
            if (freqMap.size() == right - left + 1) {
                if (right - left + 1 > longestSubStringSize) {
                    longestSubStringSize = right - left + 1;
                    ansI = left;
                    ansJ = right;
                }
            } else if (freqMap.size() < right - left + 1) {
                // any time we encounter a duplicate variable means that the size of freq map became less than the window size
                // so we need to start reducing the window from the left to see if we are able to remove the duplicates
                // and match the window length
                while (freqMap.size() < right - left + 1) {
                    freqMap.put(str.charAt(left), freqMap.get(str.charAt(left)) - 1);
                    if (freqMap.get(str.charAt(left)) == 0) {
                        freqMap.remove(str.charAt(left));
                    }
                    left++;
                }
            }
            right++;
        }

        if (ansI != -1) {
            return str.substring(ansI, ansJ + 1);
        }
        return null;
    }
}
