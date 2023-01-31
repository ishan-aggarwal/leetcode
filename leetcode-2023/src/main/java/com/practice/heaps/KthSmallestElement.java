package com.practice.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/*
Find Kth Smallest Element in an Unsorted Array.
 */

public class KthSmallestElement {

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15, 2};
        int k = 3;
        System.out.println(kthSmallest(arr, k));
    }

    private static int kthSmallest(int[] arr, int k) {
        // Create a max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int ele : arr) {
            pq.add(ele);
            // If heap size is greater than k remove the top element from heap as it will never be in our answer
            if (!pq.isEmpty() && pq.size() > k) {
                pq.poll();
            }
        }

        if (pq.isEmpty() || pq.size() < k) return -1;

        return pq.peek();
    }
}
