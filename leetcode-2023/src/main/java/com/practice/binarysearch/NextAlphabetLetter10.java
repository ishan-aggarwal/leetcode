package com.practice.binarysearch;

//Find Next letter in a given array for the target element
public class NextAlphabetLetter10 {
    public static char nextLetter(char[] arr, char element) {
        int start = 0, end = arr.length - 1;
        char res = '0';
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= element)
                start = mid + 1;
                // If current letter is greater than the target then store this as answer and search for a more accurate in the first part of an array
            else {
                res = arr[mid];
                end = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'c', 'f', 'h'};
        System.out.println(nextLetter(arr, 'b'));
    }
}
