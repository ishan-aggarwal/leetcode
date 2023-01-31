package com.practice.heaps;

//Given are N ropes of different lengths, the task is to connect these ropes into one rope with minimum cost,
// such that the cost to connect two ropes is equal to the sum of their lengths.

import java.util.PriorityQueue;

public class MinCostConnectRopes {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(minCost(arr));
    }

    private static int minCost(int[] arr) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int ele : arr) {
            pq.add(ele);
        }

        while (!pq.isEmpty() && pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();
            ans += (first + second);
            pq.add(first + second);
        }

        return ans;
    }

}
