package com.practice.heaps;

import javafx.print.Collation;

import java.util.Collections;
import java.util.PriorityQueue;

//Sum of k1 smallest and k2 the smallest composite numbers in the array
public class SumOfElements {

    private static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int ele : arr) {
            priorityQueue.add(ele);
            if (priorityQueue.size() > k) priorityQueue.poll();
        }
        if (priorityQueue.isEmpty() || priorityQueue.size() < k) return -1;
        return priorityQueue.peek();
    }

    public static int sumOfEle(int[] arr, int k1, int k2) {
        int sum = 0;
        int first = kthSmallest(arr, k1);
        int second = kthSmallest(arr, k2);
        System.out.println(first + " " + second);
        for (int num : arr) {
            if (num > first && num < second)
                sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 12, 5, 15, 11};
        int k1 = 3, k2 = 6;
        System.out.println(sumOfEle(arr, k1, k2));
    }

}
