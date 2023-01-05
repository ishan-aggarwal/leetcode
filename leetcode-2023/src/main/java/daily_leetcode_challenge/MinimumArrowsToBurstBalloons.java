package daily_leetcode_challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumArrowsToBurstBalloons {
    // Finds the minimum number of arrows needed to burst all balloons

    // Approach:

//    Sort the intervals by their end point, and then iterate through the sorted list.
//    At each iteration, we compare the start point of the current interval with the end point of the previous interval.
//    If the start point of the current interval is after the end point of the previous interval,
//          it means that the current interval does not overlap with the previous one, and therefore we need an additional arrow to burst the current interval.
//    If the start point of the current interval is before or at the same point as the end point of the previous interval,
//          it means that the current interval overlaps with the previous one, and we can burst both intervals with only one arrow.
//
//    This solution works because if we sort the intervals by their end point, it will always be optimal to use the minimum number of arrows to burst the intervals that end first.
//    This is because, if we have two intervals A and B such that A ends before B and we use one arrow to burst A, it means that we cannot use that same arrow to burst B,
//    and therefore we must use an additional arrow for B. Therefore, it is always optimal to use the minimum number of arrows to burst the intervals that end first.


    //    Time complexity: O(NlogN) because of sorting of input data, where N is the size of input data 'points'.
    //    Space complexity: O(N)\O(logN)
    //        The space complexity of the sorting algorithm depends on the implementation of each program language and adds upto the space complexity of our algorithm.
    public static int findMinArrowShots(int[][] points) {

        if (points == null || points.length == 0) return 0;

        // Sort the balloons by the end position of the arrow
//        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(points, Comparator.comparing(a -> a[1]));
        // Initialize the number of arrows needed to 1
        int result = 1;
        // Set the index of the previously burst balloon to 0
        int previous = 0;

        // Iterate through all balloons
        for (int current = 1; current < points.length; current++) {
            // If the start position of the current balloon is after the end position of the arrow that burst the previous balloon,
            // then a new arrow is needed to burst the current balloon
            if (points[current][0] > points[previous][1]) {
                result++;
                // Update the index of the previously burst balloon
                previous = current;
            }
        }
        return result;
    }

    // Approach
//    A PriorityQueue is used to sort the balloon ranges in ascending order of their end points.
//    The balloon ranges are processed one by one, starting with the one that ends first.
//    For each balloon range, we check if any of the subsequent ranges start before or at the same time as the end of the current range.
//          If a subsequent range does, we remove it from the PriorityQueue because it will also be burst when the current range is burst.
//    We increment the result counter by 1 for each balloon range processed, since each range requires one arrow to burst it.
//    After all the ranges have been processed, the result counter holds the minimum number of arrows needed to burst all the balloons.

    public static int findMinArrowShots1(int[][] points) {

        if (points == null || points.length == 0) return 0;

        // result will store the minimum number of arrows needed to burst all the balloons
        int result = 0;

        // PriorityQueue to sort the balloon ranges in ascending order of their end points
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        // add all the balloon ranges to the PriorityQueue
        for (int[] point : points) priorityQueue.add(point);

        // while there are balloons in the PriorityQueue, process each balloon range
        while (!priorityQueue.isEmpty()) {
            // get the current balloon with least x_end
            int[] prev = priorityQueue.poll();

            // check if any subsequent balloon ranges start before or at the same time as the end of the current range
            // if a subsequent range does, remove it from the PriorityQueue because it will also be burst when the current range is burst
            while (!priorityQueue.isEmpty() && prev[1] >= priorityQueue.peek()[0] && prev[1] <= priorityQueue.peek()[1]) {
                priorityQueue.poll();
            }

            // increment the result counter by 1 for each balloon range processed, since each range requires one arrow to burst it
            result++;
        }

        // return the minimum number of arrows needed to burst all the balloons
        return result;
    }


    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
        System.out.println(findMinArrowShots1(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        System.out.println(findMinArrowShots1(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        System.out.println(findMinArrowShots1(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
        System.out.println(findMinArrowShots1(new int[][]{{1, 10}, {2, 10}}));
    }
}
