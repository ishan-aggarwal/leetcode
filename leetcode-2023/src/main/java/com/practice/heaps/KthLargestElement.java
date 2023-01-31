package com.practice.heaps;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15, 2};
        int k = 3;
        System.out.println(kthLargestElement(arr, k));
    }

    private static int kthLargestElement(int[] arr, int k) {
        // Create a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int ele : arr) {
            pq.add(ele);
            // If heap size is greater than k remove the top element from heap as it will never be in our answer (it will be a small element only)
            if (pq.size() > k) {
                pq.poll();
            }
        }
        if (pq.isEmpty() || pq.size() < k) return -1;
        return pq.peek();
    }

}
