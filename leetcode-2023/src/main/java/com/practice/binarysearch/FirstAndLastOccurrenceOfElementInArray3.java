package com.practice.binarysearch;

public class FirstAndLastOccurrenceOfElementInArray3 {

    public static void main(String[] args) {
        int[] arr = new int[]{-8, 1, 2, 10, 10, 10, 10, 10, 15, 20};
        int ele = 10;
        int firstOccurrence = firstOccurrence(arr, ele);
        System.out.println(firstOccurrence);
        if (firstOccurrence != -1) {
            int lastOccurrence = lastOccurrence(arr, ele);
            System.out.println(lastOccurrence);
        }
    }

    private static int firstOccurrence(int[] arr, int ele) {
        int l = 0, r = arr.length - 1;
        int pos = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // basically the idea is if element is smaller than middle element then we point r to mid - 1
            if (arr[mid] >= ele) {
                if (arr[mid] == ele) {
                    pos = mid;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return pos;
    }

    private static int lastOccurrence(int[] arr, int ele) {
        int l = 0, r = arr.length - 1;
        int pos = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // basically the idea is if element is greater than middle element then we point l to mid + 1
            if (arr[mid] <= ele) {
                if (arr[mid] == ele) pos = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return pos;
    }
}
