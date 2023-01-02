# 520. Detect Capital

### Easy

## We define the usage of capitals in a word to be right when one of the following cases holds:

* All letters in this word are capitals, like "USA".
* All letters in this word are not capitals, like "leetcode".
* Only the first letter in this word is capital, like "Google".

Given a string word, return true if the usage of capitals in it is right.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Example 1:

Input: word = "USA" <br/>
Output: true

Example 2:

Input: word = "FlaG" <br/>
Output: false

## Constraints:

1 <= word.length <= 100 <br/>
word consists of lowercase and uppercase English letters.

## Solution

This problem is similar to Isomorphic Strings.

## Approach : Count caps

**Intuition**

The most naive way to take one count variable and count the number of caps in the input string. Return true in case the
count of caps is equal to the length of the string or count of caps is zero or count of caps is 1 and first letter in
the string is capital in nature.

**Implementation**
[520: Detect Capital Solution](../../../../src/main/java/daily_leetcode_challenge/DetectCapital.java)  <br/>

## Complexity Analysis

    Time complexity : O(N) where N represents the length of string.

    Space complexity : O(1) as we are not taking any extra space.