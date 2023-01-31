package com.practice.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestElements {

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15, 2};
        int k = 3;
        System.out.println(solve(arr, k));
    }

    private static List<Integer> solve(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        // Create a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int ele : arr) {
            pq.add(ele);
            // If heap size is greater than k remove the top element from heap as it will never be in our answer (because top of heap is smaller element only)
            if (pq.size() > k) {
                pq.poll();
            }
        }

        if (pq.isEmpty() || pq.size() < k) return Collections.EMPTY_LIST;

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        return result;
    }

}
