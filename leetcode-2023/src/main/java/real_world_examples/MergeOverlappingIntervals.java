package real_world_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Feature #2: Show Busy Schedule
// Implementing the "Show Busy Schedule" feature for our "Google Calendar" project.
// Description
// For the next feature, we want to find the times during which a user is busy. This feature is intended to show the busy hours of a user
// to other users without revealing the individual meeting slots. Therefore, if any meetings overlap or are back to back, then we want to merge their timings.
//
// We will be provided a list of scheduled meetings, such as [[1, 4], [2, 5], [6, 8], [7, 9], [10, 13]]. In this schedule, [1, 4] and [2, 5], as well as [6, 8] and [7, 9], are overlapping.
// After merging these meetings, the schedule becomes [[1, 5], [6, 9], [10, 13]].

// Solution
// To solve this problem, it is best to sort the meetings based on the startTime.
// Then, we can determine if two meetings should be merged or not by processing them simultaneously.
//
// First, we will sort the meetings according to startTime.
//      Considering two meetings at a time, we will then check if the startTime of the second meeting is less than the endTime of the first meeting.
//      If the condition is true, merge the meetings into a new meeting and delete the existing ones.
//      Repeat the above steps until all the meetings are processed.

//Time complexity
//        The time complexity is O(n×log(n)),where n
//        is the number of meetings in the schedule.The sorting takes up O(n×log(n)) time,whereas the rest of the algorithm is O(n).
//        Since O(n×log(n)) dominates, it will be the final complexity of the solution.
//
//        Space complexity
//        The space complexity is O(1),as constant memory is allocated. However,if sorting is not in-place,the space complexity would be O(n).

public class MergeOverlappingIntervals {

    private static int[][] mergeMeetings(int[][] meetingTimes) {

        // base conditions
        if (meetingTimes == null || meetingTimes.length == 0) {
            return new int[][]{};
        } else if (meetingTimes.length == 1) {
            return meetingTimes;
        }

        // arrange the meeting slots in ascending order on the basis of their start time
        Arrays.sort(meetingTimes, (a, b) -> Integer.compare(a[0], b[0]));

        // Take an array list as the final output size of merge intervals is not fixed
        List<int[]> merged = new ArrayList<>();
        // add the first meeting slot to the merged list output
        merged.add(meetingTimes[0]);

        // iterate over the rest of the meeting slots
        for (int i = 1; i < meetingTimes.length; ++i) {

            // find the end time for last meeting added to merged list
            int size = merged.size();
            int prevMeetingEndTime = merged.get(size - 1)[1];

            // find the start and end time for current meeting
            int currentMeetingStartTime = meetingTimes[i][0];
            int currentMeetingEndTime = meetingTimes[i][1];

            // if the start time for current meeting overlaps with previous meeting end time
            // update the end time of last meeting in merged list to the max of end time of last meeting or end time of current meeting
            // else add the current meeting as well to the merged list
            if (currentMeetingStartTime <= prevMeetingEndTime) {
                merged.get(size - 1)[1] = Math.max(prevMeetingEndTime, currentMeetingEndTime);
            } else {
                merged.add(meetingTimes[i]);
            }
        }

        // finally return the array as an output
        return merged.toArray(new int[merged.size()][]);


//        ArrayList<int[]> merged = new ArrayList<>();
//        for (int[] meeting: meetingTimes){
//            int size = merged.size();
//            if(size == 0 || merged.get(size - 1)[1] < meeting[0]){
//                merged.add(meeting);
//            }
//            else{
//                merged.get(size - 1)[1] = Math.max(merged.get(size - 1)[1], meeting[1]);
//            }
//        }
//        return merged.toArray(new int[merged.size()][]);

    }

    public static void main(String args[]) {
        int[][] meetingTimes1 = {{1, 4}, {2, 5}, {6, 8}, {7, 9}, {10, 13}};
        System.out.println(Arrays.deepToString(mergeMeetings(meetingTimes1)));
        int[][] meetingTimes2 = {{4, 7}, {1, 3}, {8, 10}, {2, 3}, {6, 8}};
        System.out.println(Arrays.deepToString(mergeMeetings(meetingTimes2)));
    }
}
