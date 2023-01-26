package com.practice.slidingwindow.fixed;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeInWindowSizeK {

    public static void main(String[] args) {
        int[] arr = {12, -1, -2, 8, -16, 30, 16, 28};
        int k = 3;
        // here in this problem, we have been provided with an array and a window length
        // for each sub-array of size k, we need to find the first negative element that occurred in it
        // answer will be again in form of an array, which will either have the negative element that encountered first in that window
        // or it will be zero representing there was no negative element in that sub-array
        int[] ans = solve(arr, k);

        // print the result
        System.out.println(Arrays.toString(ans));
    }

    private static int[] solve(int[] arr, int k) {
        // given an array of length n, and sliding window size k
        // total sub-arrays possible are n - k + 1
        int[] ans = new int[arr.length - k + 1];

        // we are maintaining a list of negatives (FIFO) structure to hold the negatives that are encountered in the original array
        Queue<Integer> negatives = new LinkedList<>();

        // left and right ptrs to move in the array
        int left = 0, right = 0;

        // ptr to keep track of index in ans
        int ptr = 0;

        // iterate till right is less than overall length
        while (right < arr.length) {

            // find right most element
            int ele = arr[right];
            // if negative add it to the queue
            if (ele < 0) {
                negatives.add(ele);
            }

            // if window size is not reached, increase the window size by moving right ptr
            if (right - left + 1 < k) {
                right++;
            } else if (right - left + 1 == k) {
                // if window size is reached, we need additional logic as demanded in the question
                // if the negatives queue is empty that means no negative element encountered so far
                // so simple add a 0 to the answer/result array
                if (negatives.isEmpty()) {
                    ans[ptr++] = 0;
                } else {
                    // in case the negatives queue is not empty that means we have seen some negative elements in the current sliding window
                    // peek the queue to find the element and store it in answer array
                    ans[ptr++] = negatives.peek();
                    // if the top most element is same as the left most element
                    // then also remove it from the queue
                    if (arr[left] == negatives.peek()) {
                        negatives.remove();
                    }
                }
                // finally increase both left and right pointers
                // to slide the window
                left++;
                right++;
            }
        }
        return ans;
    }
}
