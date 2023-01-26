package com.practice.slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

public class LargestSubstringWithKUniqueCharacter {

    public static void main(String[] args) {
        String str = "aabacbebebe";
        System.out.println(largestSubString(str, 3));
    }

    private static String largestSubString(String str, int k) {

        int left = 0, right = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int ansI = -1, ansJ = -1;
        int largestSubStringWithKUniqueChars = Integer.MIN_VALUE;

        while (right < str.length()) {
            Character ch = str.charAt(right);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

            if (freqMap.size() < k) {
                right++;
            } else if (freqMap.size() >= k) {
                while (freqMap.size() > k) {
                    Character leftChar = str.charAt(left);
                    if (freqMap.containsKey(leftChar)) {
                        freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                        if (freqMap.get(leftChar) == 0) {
                            freqMap.remove(leftChar);
                        }
                    }
                    left++;
                }
                if (freqMap.size() == k) {
                    if (right - left + 1 > largestSubStringWithKUniqueChars) {
                        largestSubStringWithKUniqueChars = right - left + 1;
                        ansI = left;
                        ansJ = right;
                    }
                }
                right++;
            }
        }

        if (ansI != -1) {
            return str.substring(ansI, ansJ + 1);
        }
        return null;
    }

}
