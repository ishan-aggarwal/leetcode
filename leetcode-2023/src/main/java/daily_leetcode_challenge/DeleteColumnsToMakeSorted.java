package daily_leetcode_challenge;

public class DeleteColumnsToMakeSorted {

//    Complexity Analysis
//    Here N is the number of strings in the given list strs, and K is the length of each string.
//
//    Time complexity: O(N * K).
//    We are iterating over each of the K characters in all the N strings. Although we break early in the case where we find the column unsorted,
//    in the worst case when there is no unsorted column, we will have to iterate over each character. Hence, the total time complexity is O(N * K).
//
//    Space complexity: O(1).
//    We don't need any extra space apart from the variable answer used to store the count of unsorted columns.

    public static int minDeletionSize(String[] strs) {
        int n = strs.length;
        int strLen = strs[0].length();
        int totalColumnsToBeDeleted = 0;
        for (int col = 0; col < strLen; col++) {
            int charValue = strs[0].charAt(col) - 'a';
            for (int row = 1; row < n; row++) {
                if (charValue > strs[row].charAt(col) - 'a') {
                    totalColumnsToBeDeleted++;
                    break;
                } else {
                    charValue = Math.max(charValue, strs[row].charAt(col) - 'a');
                }
            }
        }
        return totalColumnsToBeDeleted;
    }


    public static int minDeletionSize1(String[] strs) {
        // String length.
        int strLen = strs[0].length();
        // Variable to store the count of columns to be deleted.
        int totalColumnsToBeDeleted = 0;
        // Iterate over each index in the string.
        for (int col = 0; col < strLen; col++) {
            // Iterate over the strings.
            for (int row = 1; row < strs.length; row++) {
                // Characters should be in increasing order,
                // If not, increment the counter.
                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    totalColumnsToBeDeleted++;
                    break;
                }
            }
        }
        return totalColumnsToBeDeleted;
    }

    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[]{"rrjk", "furt", "guzm"}));
        System.out.println(minDeletionSize1(new String[]{"rrjk", "furt", "guzm"}));
    }
}