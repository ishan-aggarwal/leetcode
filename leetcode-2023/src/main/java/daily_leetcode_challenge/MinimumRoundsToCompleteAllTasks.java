package daily_leetcode_challenge;

import java.util.HashMap;
import java.util.Map;

// Hints
// 1. Which data structure can you use to store the number of tasks of each difficulty level?
//      -> map to store the frequency of each of difficulty level
// 2. For any particular difficulty level, what can be the optimal strategy to complete the tasks using minimum rounds?
//      -> If total tasks (x - 3k) are multiplier of 3 - then x/3 (k)
//      -> otherwise total task (x) could be 3K+1 which is not possible to solve (3k - 1) + 2 i.e. 10 = 8 + 2 = (6 + 2) + 2 = (2 rounds + 1 round) + 1 round
//                                                      or 3K+2 -> (k + 1 rounds)
// 3. When can we not complete all tasks of a difficulty level?
//      -> when the total tasks of that difficulty level are 1.


//Algorithm
//        Iterate over the integers in the array tasks, and for each integer store the frequency in the map freq.
//
//        Initialize the answer variable minimumRounds to 0.
//
//        Iterate over the frequencies in the map freq and for each frequency count:
//
//        If count is 1, then we should stop and return -1.
//        Add count / 3 to the answer variable minimumRounds, if count is divisible by 33.
//        Otherwise, add count / 3 + 1 to minimumRounds.
//        Return minimumRounds.


//Complexity Analysis
//        Here, N is the number integers in the given array.
//
//        Time complexity: O(N).
//        We iterate over the integer array to store the frequencies in the map, this will take O(N) time, then we iterate over the map to find the minimum group needed for each integer, which again will cost O(N).
//        Therefore, the total time complexity is equal to O(N).
//
//        Space complexity: O(N).
//        We need the map to store the frequencies of the integers, hence the total space complexity is equal to O(N).

public class MinimumRoundsToCompleteAllTasks {
    public static int minimumRounds(int[] tasks) {

        Map<Integer, Integer> taskCountMap = new HashMap<>();
        for (int task : tasks) {
            taskCountMap.put(task, taskCountMap.getOrDefault(task, 0) + 1);
        }

        int minimumTotalRounds = 0;
        for (int tasksCount : taskCountMap.values()) {

            if (tasksCount == 1) {
                return -1;
            }

            if (tasksCount % 3 == 0) {
                minimumTotalRounds += tasksCount / 3;
            } else {
                minimumTotalRounds += (tasksCount % 3 == 2) ? (tasksCount / 3 + 1) : (tasksCount / 3 - 1) + 2;
            }
        }

        return minimumTotalRounds;
    }

    public static void main(String[] args) {
        System.out.println(minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}));
        System.out.println(minimumRounds(new int[]{2, 3, 3}));
    }
}