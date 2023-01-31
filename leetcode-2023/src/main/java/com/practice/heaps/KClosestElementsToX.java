package com.practice.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElementsToX {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 7, 8, 9};
        int x = 7, k = 3;
        System.out.println(solve(arr, x, k));
    }

    public static List<Integer> solve(int[] arr, int x, int k) {
        List<Integer> result = new ArrayList<>();
        // since we want closest elements, then we will prepare max heap..
        // so that when more than k elements are added
        // the element that gets removed first will be having the farthest distance
        // that is the reason for lamda expression in reverse order
        // (p1, p2) -> p2.getDifference() - p1.getDifference()
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.getFirst() - p1.getFirst());
        for (int ele : arr) {
            pq.add(new Pair(Math.abs(ele - x), ele));
            if (pq.size() > k) pq.poll();
        }
        if (pq.isEmpty() || pq.size() < k) return Collections.emptyList();
        while (!pq.isEmpty()) {
            result.add(pq.poll().getSecond());
        }
        return result;
    }

}
