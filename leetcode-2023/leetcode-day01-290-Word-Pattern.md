# 290. Word Pattern

### Easy

## Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Example 1: <br/>
Input: pattern = "abba", s = "dog cat cat dog" <br/>
Output: true

Example 2: <br/>
Input: pattern = "abba", s = "dog cat cat fish" <br/>
Output: false

Example 3: <br/>
Input: pattern = "aaaa", s = "dog cat cat dog" <br/>
Output: false

### Constraints:

1 <= pattern.length <= 300 <br/>
pattern contains only lower-case English letters. <br/>
1 <= s.length <= 3000 <br/>
s contains only lowercase English letters and spaces ' '. <br/>
s does not contain any leading or trailing spaces. <br/>
All the words in s are separated by a single space. <br/>

## Solution

This problem is similar to Isomorphic Strings.

### Approach 1: Two Hash Maps

**Intuition**

The most naive way to start thinking about this problem is to have a single hash map, tracking which character (in
pattern) maps to what word (in s). As you scan each character-word pair, update this hash map for characters which are
not in the mapping. If you see a character which already is one of the keys in mapping, check whether the current word
matches with the word the character maps to. If they do not match, you can immediately return False, otherwise, just
keep on scanning until the end.

This type of check will work well for cases such as:

    "abba" and "dog cat cat dog" -> Returns True.
    "abba" and "dog cat cat fish" -> Returns False.

But it will fail for:

    "abba" and "dog dog dog dog" -> Returns True (Expected False).

A fix for this is to have two hash maps, one for mapping characters to words and the other for mapping words to
characters. While scanning each character-word pair,

    If the character is NOT in the character to word mapping, you additionally check whether that word is also in the word to character mapping.
        If that word is already in the word to character mapping, then you can return False immediately since it has been mapped with some other character before.
        Else, update both mappings.
    If the character IS IN in the character to word mapping, you just need to check whether the current word matches with the word which the character maps to in the character to word mapping. If not, you can return False immediately.

**Implementation**
[290: Word Pattern Solution](src\main\java\WordPattern.java)  <br/>