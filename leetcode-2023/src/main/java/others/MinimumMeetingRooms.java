package others;

import java.util.Arrays;
import java.util.PriorityQueue;

// Feature #1: Find Meeting Rooms
// Implementing the "Find Meeting Rooms" feature for our "Google Calendar" project.
// Description
// To develop this project’s first feature, we are given a set of meeting times. Our job is to implement a solution that can identify the number of meeting rooms needed to schedule the required meetings.
// Each meeting time will contain a startTime and an endTime that are both positive integers.


// Solution
// We can use a heap or priority queue to keep the meeting timings, where the key would be the end_time of each meeting.
// This way, we can check if any room is free or not by simply checking the heap’s topmost element.
// The room at the top of the heap would get free the earliest out of all the other rooms currently occupied.
// If the room we obtain from the top of the heap isn’t free yet, then this means no other room is free either. So, we can allocate a new room in this condition.
//
// Here is how the implementation will take place:
//        Sort the given meetings by their startTime.
//        Allocate the first meeting to a room and add an entry in the heap with the meeting’s endTime.
//        Traverse over the remaining meetings, and keep checking if the meeting at the top of the heap has ended or not. This will tell us if a room is free yet.
//        If the room is free, then we extract this element and add it again in the heap with the ending time of the current meeting we are processing.
//        If not, then we allocate a new room and add it to the heap.
//        After processing all the meetings, the heap’s size will tell us the number of rooms allocated. This will be the minimum number of rooms needed to accommodate all the meetings.


public class MinimumMeetingRooms {

//    Time complexity
//    Because the sorting and priority queue operations both take up O(n×log(n)) time, the time complexity is O(n×log(n)), where n
//    is the number of meetings in the schedule.

//    Space complexity
//    The space complexity is O(n), where n is the number of meetings in the schedule. (because in worst case minHeap might have to store all the endTimes)

    private static int minMeetingRooms(int[][] meetingTimes) {

        if (meetingTimes == null || meetingTimes.length == 0) {
            return 0;
        }

        // sort the meeting times on the basis of their start time
        Arrays.sort(meetingTimes, (a, b) -> Integer.compare(a[0], b[0]));
//        Arrays.sort(meetingTimes, Comparator.comparingInt(a -> a[0]));
//        Arrays.stream(meetingTimes).forEach(a -> System.out.println(a[0] + " " + a[1]));

        // min Heap keeps track of earliest ending meeting:
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((A, B) -> A - B);
        minHeap.add(meetingTimes[0][1]);

        for (int i = 1; i < meetingTimes.length; ++i) {
            int currentMeetingStarting = meetingTimes[i][0];
            int currentMeetingEnding = meetingTimes[i][1];
            int earliestMeetingEnding = minHeap.peek();

            // remove the entry from minHeap if the earliest meeting ending is earlier than current meeting starting
            if (earliestMeetingEnding <= currentMeetingStarting) {
                minHeap.remove();
            }

            //update the min heap with currentMeetingEnding
            minHeap.add(currentMeetingEnding);
        }

        return minHeap.size();
    }

    public static void main(String args[]) {
        // Driver code
        int[][] meetingTimes = {{5, 11}, {2, 8}, {3, 9}, {3, 4}, {8, 20}, {11, 15}};
        System.out.print(minMeetingRooms(meetingTimes));
    }
}
