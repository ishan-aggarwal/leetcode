package com.practice.heaps;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
The distance between two points on the X-Y plane is the Euclidean distance (i.e., âˆš(x1 - x2)2 + (y1 - y2)2).
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
https://leetcode.com/problems/k-closest-points-to-origin/
 */
class CustomPair {
    int dist;
    int[] point;

    public CustomPair(int dist, int[] point) {
        this.dist = dist;
        this.point = point;
    }
}

public class KClosetPointToOrigin {
    public static List<int[]> kClosetNo(int[][] arr, int k) {
        List<int[]> result = new ArrayList<>();

        //Create a max heap
        PriorityQueue<CustomPair> que = new PriorityQueue<>(k, (o1, o2) -> o2.dist - o1.dist);
        for (int[] point : arr) {
            // adding distance a key and co-ordinates as value to max heap
            que.add(new CustomPair((point[0] * point[0]) + (point[1] * point[1]), point));
            if (que.size() > k)
                que.poll();
        }
        while (que.size() > 0) {
            int[] point = que.poll().point;
            result.add(point);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k = 2;
        List<int[]> result = kClosetNo(arr, k);
        result.stream().forEach(e -> System.out.println(Arrays.toString(e)));
    }
}