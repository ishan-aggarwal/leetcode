package daily_leetcode_challenge;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> charToWordMap = new HashMap<>();
        Map<String, Character> wordToCharMap = new HashMap<>();
        String[] words = s.split(" ");

        if (words.length != pattern.length())
            return false;

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if (!charToWordMap.containsKey(c)) {
                if (wordToCharMap.containsKey(w)) {
                    return false;
                } else {
                    charToWordMap.put(c, w);
                    wordToCharMap.put(w, c);
                }

            } else {
                String mappedWord = charToWordMap.get(c);
                if (!mappedWord.equals(w))
                    return false;
            }
        }
        return true;
    }

    public static boolean wordPattern1(String pattern, String s) {
        HashMap<Object, Integer> mapIndex = new HashMap();
        String[] words = s.split(" ");

        if (words.length != pattern.length())
            return false;

        // Idea is that index of character and word should always match
        // for this whenever we encounter a new character/ word we store the object with its index in the map
        // in case the same character is mapped to some other word, the word gets stored again with a different index
        // to avoid problem where the word could itself be a character.. we can prefix the char with char- and word with word-
        for (Integer i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (!mapIndex.containsKey(c))
                mapIndex.put(c, i);

            if (!mapIndex.containsKey(w))
                mapIndex.put(w, i);

            if (mapIndex.get(c) != mapIndex.get(w))
                return false;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));

        System.out.println(wordPattern1("abba", "dog cat cat dog"));
        System.out.println(wordPattern1("abba", "dog cat cat fish"));
        System.out.println(wordPattern1("aaaa", "dog cat cat dog"));

    }
}