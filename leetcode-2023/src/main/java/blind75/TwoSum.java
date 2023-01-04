package blind75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Hints
// 1. A really brute force way would be to search for all possible pairs of numbers but that would be too slow. Again,
//    it's best to try out brute force solutions for just for completeness. It is from these brute force solutions that you can come up with optimizations.
// 2. So, if we fix one of the numbers, say x, we have to scan the entire array to find the next number y which is value - x where value is the input parameter.
//    Can we change our array somehow so that this search becomes faster?
// 3. The second train of thought is, without changing the array, can we use additional space somehow? Like maybe a hash map to speed up the search?

//One-pass Hash Table
//        It turns out we can do it in one-pass. While we are iterating and inserting elements into the hash table,
//        we also look back to check if current element's complement already exists in the hash table. If it exists, we have found a solution and return the indices immediately.

//Complexity Analysis
//        Time complexity: O(n). We traverse the list containing nn elements only once. Each lookup in the table costs only O(1) time.
//        Space complexity: O(n). The extra space required depends on the number of items stored in the hash table, which stores at most nn elements.


public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> elementIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (elementIndexMap.get(target - nums[i]) != null) {
                return new int[]{elementIndexMap.get(target - nums[i]), i};
            }
            elementIndexMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }
}