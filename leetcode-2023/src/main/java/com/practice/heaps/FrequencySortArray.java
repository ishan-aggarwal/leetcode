package com.practice.heaps;

import java.util.*;

public class FrequencySortArray {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 2, 2, 2, 1, 4, 1};
        List<Integer> result = freqSort(arr);
        System.out.println(result);
    }

    private static List<Integer> freqSort(int[] arr) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> results = new ArrayList<>();

        Arrays.stream(arr).forEach(x -> freqMap.put(x, freqMap.getOrDefault(x, 0) + 1));
        System.out.println(freqMap);
        // reverse order (means decreasing order)
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o2.getFirst() - o1.getFirst());

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.add(new Pair(entry.getValue(), entry.getKey()));
        }

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            for (int i = 0; i < pair.getFirst(); ++i) {
                results.add(pair.getSecond());
            }
        }
        return results;
    }

}
