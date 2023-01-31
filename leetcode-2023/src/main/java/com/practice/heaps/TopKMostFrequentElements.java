package com.practice.heaps;

import java.util.*;

public class TopKMostFrequentElements {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 1, 3, 2, 2, 2, 4};
        int k = 2;
        System.out.println(solve(arr, k));
    }

    public static List<Integer> solve(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        Arrays.stream(arr).forEach(x -> freqMap.put(x, freqMap.getOrDefault(x, 0) + 1));
        // prepare a frequency map
        System.out.println(freqMap);

        // since we want high frequencies in the answer
        // so we will prepare a min heap.. (so that lower frequency elements are removed first)
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getFirst));
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.add(new Pair(entry.getValue(), entry.getKey()));
            if (pq.size() > k) pq.poll();
        }

        if (pq.isEmpty() || pq.size() < k) return Collections.EMPTY_LIST;
        while (!pq.isEmpty()) {
            result.add(pq.poll().getSecond());
        }
        return result;
    }
}
