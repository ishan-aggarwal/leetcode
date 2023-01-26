package com.practice.recursion.slidingwindow.fixed;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrenceOfAnagrams {

    public static void main(String[] args) {
        String str = "aabaabaa";
        String pattern = "aaba";
        System.out.println(solve(str, pattern, pattern.length()));
    }

    private static int solve(String str, String pattern, int patternLength) {

        Map<Character, Integer> freqMap = new HashMap<>();
        int left = 0, right = 0;
        int ans = 0;
        int count = 0;

        // prepare frequency map by iterating over pattern
        for (Character c : pattern.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        // initialize count by size of frequency map to represent number of distinct characters in pattern
        count = freqMap.size();

        // run till right pointer is less than length of the string
        while (right < str.length()) {

            // get the right most char
            char ch = str.charAt(right);

            // see if the char is there in frequency map
            if (freqMap.containsKey(ch)) {
                // decrease the count of frequency by 1
                freqMap.put(ch, freqMap.get(ch) - 1);

                // check if the frequency count of the char became 0, then reduce the count as well by 1
                if (freqMap.get(ch) == 0) {
                    count--;
                }
            }

            // see if the window side is still not reached, then increase the right pointer only
            if (right - left + 1 < patternLength) {
                right++;
            } else if (right - left + 1 == patternLength) { // if window size is same as pattern lenght both ptr will be increased by 1

                // verify at this time if count is 0, means we are able to match the freq of all chars in freq map,
                // increase the answer by 1
                if (count == 0) ans++;
                // now since we need to shrink the window, we need add on logic
                // find the left char of the window
                Character leftChar = str.charAt(left);

                // if the left char is present in the freqMap
                // we are going to increase the frequency for this char by 1 in freq map
                // also if the freq of this char became greater than 0 this time, then we will increase the count variable also by 1
                if (freqMap.containsKey(leftChar)) {
                    freqMap.put(leftChar, freqMap.get(leftChar) + 1);
                    if (freqMap.get(leftChar) > 0) {
                        count++;
                    }
                }

                // finally shift the window by sliding both pointers
                left++;
                right++;
            }
        }

        return ans;
    }
}
