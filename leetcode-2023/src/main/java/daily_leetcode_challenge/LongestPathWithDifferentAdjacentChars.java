package daily_leetcode_challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Algorithm
//Initialize an array children, where children[X] contains all the children of node X.
//        Initialize the answer variable longestPath = 1 (a single node can always be selected).
//        Start a DFS traversal.
//        We use a dfs function to perform the traversal. For each call, pass currentNode, children, s, and longestPath as the parameters. It returns the length of the longest chain starting from that currentNode.
//        Initialize two integers longestChain = 0 and secondLongestChain = 0, to store the longest and the second longest chains across all the children of the currentNode.
//        Iterate over all the children and for every child, recursively call the dfs function with child, children, s, longestPath as the parameters. This call returns the length of longest path longestChainStartingFromChild starting from child.
//        Use longestChainStartingFromChild to update longestChain and secondLongestChain.
//        After iterating over all the children, use longestChain and secondLongestChain to update the longestPath to max(longestPath, longestChain + secondLongestChain + 1). The +1 comes from the currentNode which connects the two chains.
//        Return the length of the longest chain including the currentNode which is longestChain + 1.
//        Return longestPath.


//Here, n is the number of nodes.
//
//        Time complexity: O(n)
//        Each node is visited by the dfs function once, which takes O(n) time in total. We also iterate over the edges of every node once (since we don't visit a node more than once, we don't iterate its edges more than once), which adds O(n) time since we have n - 1 edges.
//        We also need O(n) time to initialize the children array.
//        Space complexity: O(n)
//        The recursion call stack used by dfs can have no more than nn elements in the worst-case scenario. So, we would take up O(n) space in the worst case.
//        We also need O(n) space for the the children array.

public class LongestPathWithDifferentAdjacentChars {
    private int longestPath = 1;

    public int dfs(int currentNode, Map<Integer, List<Integer>> children, String s) {
        // If the node is the only child, return 1 for the currentNode itself.
        if (!children.containsKey(currentNode)) {
            return 1;
        }

        // Longest and second longest path starting from currentNode (does not count the
        // currentNode itself).
        int longestChain = 0, secondLongestChain = 0;
        for (int child : children.get(currentNode)) {
            // Get the number of nodes in the longest chain starting from the child,
            // including the child.
            int longestChainStartingFromChild = dfs(child, children, s);
            // We won't move to the child if it has the same character as the currentNode.
            if (s.charAt(currentNode) == s.charAt(child)) {
                continue;
            }
            // Modify the longestChain and secondLongestChain if longestChainStartingFromChild
            // is bigger.
            if (longestChainStartingFromChild > longestChain) {
                secondLongestChain = longestChain;
                longestChain = longestChainStartingFromChild;
            } else if (longestChainStartingFromChild > secondLongestChain) {
                secondLongestChain = longestChainStartingFromChild;
            }
        }

        // Add "1" for the node itself.
        longestPath = Math.max(longestPath, longestChain + secondLongestChain + 1);
        return longestChain + 1;
    }

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        Map<Integer, List<Integer>> children = new HashMap<>();
        // Start from node 1, since root node 0 does not have a parent.
        for (int i = 1; i < n; i++) {
            children.computeIfAbsent(parent[i], value -> new ArrayList<>()).add(i);
        }
        dfs(0, children, s);
        return longestPath;
    }
}