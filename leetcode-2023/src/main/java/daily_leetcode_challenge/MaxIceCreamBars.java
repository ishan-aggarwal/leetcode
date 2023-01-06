package daily_leetcode_challenge;

public class MaxIceCreamBars {

    // Counting Sort Technique
//    Initialize variables:
//          n, length of the input array.
//          m, maximum cost in the costs array.
//          icecreams, number of ice creams we picked.
//
//    costsFrequency, to store the frequency of each cost from the costs array.
//    Iterate over the costs array and store each element's frequency costsFrequency.
//
//    Iterate over each cost from 1 to m.
//      For each cost, if there are ice creams and we have enough coins, then count the maximum number of ice creams we can pick.
//      Reduce the cost of those picked ice creams from our coins.
//      Add the count of those picked ice creams in the icecreams variable.
//    Return the number of ice creams we picked, i.e. the icecreams variable.


    public static int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        int totalIcecreams = 0;

        int m = costs[0];
        for (int cost : costs) {
            m = Math.max(m, cost);
        }

        int[] costsFrequency = new int[m + 1];
        for (int cost : costs) {
            costsFrequency[cost]++;
        }

        for (int cost = 1; cost <= m; ++cost) {
            // No ice cream is present costing 'cost'.
            if (costsFrequency[cost] == 0) {
                continue;
            }
            // We don't have enough 'coins' to even pick one ice cream.
            if (coins < cost) {
                break;
            }

            // Count how many totalIcecreams of 'cost' we can pick with our 'coins'.
            // Either we can pick all ice creams of 'cost' or we will be limited by remaining 'coins'.
            int count = Math.min(costsFrequency[cost], coins / cost);
            // We reduce price of picked ice creams from our coins.
            coins -= cost * count;
            totalIcecreams += count;
        }

        return totalIcecreams;
    }

    public static void main(String[] args) {
        System.out.println(maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));
        System.out.println(maxIceCream(new int[]{10, 6, 8, 7, 7, 8}, 5));
        System.out.println(maxIceCream(new int[]{1, 6, 3, 1, 2, 5}, 20));
    }
}