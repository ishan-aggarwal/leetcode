package com.practice.recursion.easy;

public class CheckPalindrome {

    public static void main(String[] args) {
        String str = "madam";
        isPalindrome(str, 0, str.length() - 1);

        str = "madem";
        isPalindrome(str, 0, str.length() - 1);

        str = "madam";
        System.out.println("String : " + str + (isPalindrome(str, 0) ? " is palindrome" : " is not palindrome"));

        str = "madeam";
        System.out.println("String : " + str + (isPalindrome(str, 0) ? " is palindrome" : " is not palindrome"));
    }

    private static boolean isPalindrome(String str, int start) {
        if (start >= str.length() / 2) {
            return true;
        }
        if (str.charAt(start) != str.charAt(str.length() - 1 - start)) {
            return false;
        }
        return isPalindrome(str, start + 1);
    }

    private static void isPalindrome(String str, int start, int end) {
        if (start >= end) {
            System.out.println("String : " + str + " is palindrome");
            return;
        }

        if (str.charAt(start) != str.charAt(end)) {
            System.out.println("String : " + str + " is not palindrome");
            return;
        }

        isPalindrome(str, start + 1, end - 1);
    }
}
