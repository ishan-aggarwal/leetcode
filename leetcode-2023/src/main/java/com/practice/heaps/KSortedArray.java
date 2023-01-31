package com.practice.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

// Given an array of N elements, where each element is at most K away from its target position, devise an algorithm that sorts in O(N log K) time.
public class KSortedArray {

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        kSortedArray(arr, k + 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void kSortedArray(int[] arr, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        int ndx = 0;
        for (int i = 0; i < arr.length; i++) {
            que.add(arr[i]);
            if (que.size() > k)
                arr[ndx++] = que.poll();
        }
        while (que.size() > 0)
            arr[ndx++] = que.poll();
    }
}
