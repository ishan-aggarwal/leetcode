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

## Constraints:

1 <= pattern.length <= 300 <br/>
pattern contains only lower-case English letters. <br/>
1 <= s.length <= 3000 <br/>
s contains only lowercase English letters and spaces ' '. <br/>
s does not contain any leading or trailing spaces. <br/>
All the words in s are separated by a single space. <br/>

## Solution

This problem is similar to Isomorphic Strings.

## Approach 1: Two Hash Maps

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
[290: Word Pattern Solution](../../../../src/main/java/WordPattern.java)  <br/>

## Complexity Analysis

    Time complexity : O(N) where N represents the number of words in s or the number of characters in pattern.

    Space complexity : O(M) where M represents the number of unique words in s. Even though we have two hash maps, the character to word hash map has space complexity of O(1) since there can at most be 26 keys.

## Approach 2: Single Index Hash Map

**Intuition**

Rather than having two hash maps, we can have a single index hash map which keeps track of the first occurrences of each
character in pattern and each word in s. As we go through each character-word pair, we insert unseen characters from
pattern and unseen words from s.

The goal is to make sure that the indices of each character and word match up. As soon as we find a mismatch, we can
return False.

Let's go through some examples.

    pattern: 'abba'
    s: 'dog cat cat dog'

    'a' and 'dog' -> map_index = {'a': 0, 'dog': 0}
        Index of 'a' and index of 'dog' are the same.
    'b' and 'cat' -> map_index = {'a': 0, 'dog': 0, 'b': 1, 'cat': 1}
        Index of 'b' and index of 'cat' are the same.
    'b' and 'cat' -> map_index = {'a': 0, 'dog': 0, 'b': 1, 'cat': 1}
        'b' is already in the mapping, no need to update.
        'cat' is already in the mapping, no need to update.
        Index of 'b' and index of 'cat' are the same.
    'a' and 'dog' -> map_index = {'a': 0, 'dog': 0, 'b': 1, 'cat': 1}
        'a' is already in the mapping, no need to update.
        'dog' is already in the mapping, no need to update.
        Index of 'a' and index of 'dog' are the same.

    pattern: 'abba'
    s: 'dog cat fish dog'

    'a' and 'dog' -> map_index = {'a': 0, 'dog': 0}
        Index of 'a' and index of 'dog' are the same.
    'b' and 'cat' -> map_index = {'a': 0, 'dog': 0, 'b': 1, 'cat': 1}
        Index of 'b' and index of 'cat' are the same.
    'b' and 'fish' -> map_index = {'a': 0, 'dog': 0, 'b': 1, 'cat': 1, 'fish': 2}
        'b' is already in the mapping, no need to update.
        Index of 'b' and index of 'fish' are NOT the same. Returns False.

**Implementation**
[290: Word Pattern Solution](../../../../src/main/java/WordPattern.java)  <br/>

Differentiating between character and string: In Python there is no separate char type. And for cases such as:

    pattern: 'abba'
    s: 'b a a b'

Using the same hash map will not work properly. A workaround is to prefix each character in pattern with "char_" and
each word in s with "word_".

## Complexity Analysis

    Time complexity : O(N) where N represents the number of words in the s or the number of characters in the pattern.

    Space complexity : O(M) where M is the number of unique characters in pattern and words in s.
