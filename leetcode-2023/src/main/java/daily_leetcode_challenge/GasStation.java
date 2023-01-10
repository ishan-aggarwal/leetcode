package daily_leetcode_challenge;

public class GasStation {

    //    Time complexity : O(N) since there is only single loop over all stations here (and no nesting of loops).
    //    Space complexity : O(1) since it's a constant space solution.
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) {
            return -1;
        }
        int currentGas = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                start = i + 1;
            }
        }
        return start;
    }


    //    Time complexity : O(N) since there is only one loop over all stations here.
    //    Space complexity : O(1) since it's a constant space solution.

    //    Algorithm
    //
    //    Initiate total_tank and curr_tank as zero, and choose station 0 as a starting station.
    //    Iterate over all stations :
    //    Update total_tank and curr_tank at each step, by adding gas[i] and subtracting cost[i].
    //    If curr_tank < 0 at i + 1 station, make i + 1 station a new starting point and reset curr_tank = 0 to start with an empty tank.
    //    Return -1 if total_tank < 0 and starting station otherwise.
    public static int canCompleteCircuit_SinglePass(int[] gas, int[] cost) {
        int totalGas = 0;
        int currentGas = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                start = i + 1;
            }
        }
        return totalGas < 0 ? -1 : start;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(canCompleteCircuit_SinglePass(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}