package daily_leetcode_challenge;

import java.util.*;

//Complexity Analysis
//        Here, n is the number of nodes.
//
//        Time complexity: O(26 * n) = O(n)
//
//        Each node is visited by the dfs function once, which takes O(n) time in total. We also iterate over the edges of every node once (since we don't visit a node more than once, we don't iterate its edges more than once), which adds O(n) time since we have n - 1 edges.
//        For each child of a node, we also add the counts of each label in the child's subtree to the node, which comes with a 2626 factor. Since there are n - 1 edges, there are n - 1 children. So, we would take up O(26 * n) time to perform all these operations.
//        Additionally, we need O(n) time to initialize the adjacency list and the ans array.
//        Space complexity: O(26 * n) = O(n)
//
//        The recursion call stack used by dfs can have no more than n elements in the worst-case scenario. Storing each element comes with a 26 factor because we create an array nodeCounts of size 26 for each node. So, we would take up O(26 * n) space in the worst case.
//        We also need O(n) memory for the adjacency list and the ans array.

public class CountNodesInSubTreeWithSameLabel {


//    Algorithm
//    Create an adjacency list where adj[X] contains all the neighbors of node X.
//    Initialize an array ans, storing the answer of each node. Initialize it with 0 for every node.
//    Start a DFS traversal.
//    We use a dfs function to perform the traversal. For each call, pass node, parent, adj, labels and ans as the parameters. It returns an array which stores the count of each label in the node's subtree. We start with node 0. We also keep track of the parent node of the current node so that we don’t visit the node’s parent as it has already been visited.
//    Initialize an array nodeCounts to store the count of each label in the node's subtree. Initialize it with 0 except for the node label, which should be 1.
//    Iterate over all the children of the node (nodes that share an edge) and check if any child is equal to the parent. If the child is equal to the parent, we will not visit it again.
//    If the child is not equal to the parent, recursively call the dfs function with the node as child and the parent as node. Store the count of all labels in its subtree in childCounts.
//    Add childCounts to nodeCounts.
//    After looping through all the children, set the ans[node] to ans[node] = nodeCounts[labels[node]].
//    Return nodeCounts.
//    Return ans.

    public static int[] dfs(int node, int parent, Map<Integer, List<Integer>> adj,
                            char[] labels, int[] ans) {
        // Store count of all alphabets in the subtree of the node.
        int[] nodeCounts = new int[26];
        nodeCounts[labels[node] - 'a'] = 1;

        if (!adj.containsKey(node))
            return nodeCounts;
        for (int child : adj.get(node)) {
            if (child == parent) {
                continue;
            }
            int[] childCounts = dfs(child, node, adj, labels, ans);
            // Add frequencies of the child node in the parent node's frequency array.
            for (int i = 0; i < 26; i++) {
                nodeCounts[i] += childCounts[i];
            }
        }

        ans[node] = nodeCounts[labels[node] - 'a'];
        return nodeCounts;
    }

    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<>()).add(a);
        }

        int[] ans = new int[n];
        char[] label = labels.toCharArray();
        dfs(0, -1, adj, label, ans);
        return ans;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        String labels = "abaedcd";
        System.out.println(Arrays.toString(countSubTrees(n, edges, labels)));
    }
}