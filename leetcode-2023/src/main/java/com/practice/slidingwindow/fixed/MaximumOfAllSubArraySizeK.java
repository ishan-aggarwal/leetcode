package com.practice.slidingwindow.fixed;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllSubArraySizeK {


    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        // here we need to find the max element for each sub-array of given size k
        // so the answer would be 3, 3, 5, 5, 6, 7
        int[] ans = solve(arr, k);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] solve(int[] arr, int k) {

        // maintain left and right to iterate over the window
        int left = 0, right = 0;
        // maintain a result/ans array to store the ans
        int[] ans = new int[arr.length - k + 1];
        // here we take a doubly linked list to build the additional logic as we need to insert and remove from both ends
        Deque<Integer> temp = new LinkedList<>();
        // ptr to maintain the index of elements in ans array
        int ptr = 0;
        // iterate till right is less than array length
        while (right < arr.length) {
            // find the right most element and it has to be appended to the temp list based on logic
            int ele = arr[right];

            // if the temp list is not empty and element on right most side is the largest element
            // then we can simply discard all elements on the left which got added to the deque
            while (!temp.isEmpty() && temp.peekLast() < ele) {
                temp.removeLast();
            }
            // add the right most element to the last
            temp.addLast(ele);

            // if the window size is not reached, increase the right pointer
            if (right - left + 1 < k) {
                right++;
            } else if (right - left + 1 == k) {
                // if the window size is reached, we need additional logic before sliding the window

                // now, we peek the first element from the deque and maintain it in the ans array
                ans[ptr++] = temp.peekFirst();
                // if the first element is same as the left most element of the array which we need to slide,
                // then we remove it from the deque
                if (arr[left] == temp.peekFirst()) {
                    temp.removeFirst();
                }
                // finally slide the window
                left++;
                right++;
            }
        }
        return ans;
    }
}
