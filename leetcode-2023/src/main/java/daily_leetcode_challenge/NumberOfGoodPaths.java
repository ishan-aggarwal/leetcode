package daily_leetcode_challenge;

import java.util.*;

//Algorithm
//        Create an adjacency list where adj[X] contains all the neighbors of node X.
//        Create a map valuesToNodes where valuesToNodes[X] is an array that contains all the nodes having the value X. The data structure chosen to create such a map sorts the keys in non-decreasing order, i.e., the keys are sorted.
//        Iterate over all the nodes and add each node to valuesToNodes[vals[node]].
//        Create a class UnionFind defining standard methods find and union_set.
//        Create an instance of UnionFind, passing the size as n. Also, initialize the count of good paths variable goodPaths with 0.
//        Iterate over each entry value, nodes in valuesToNodes in ascending order.
//        For every node in nodes, iterate over its neighbors.
//        For each neighbor of the node, if vals[node] >= vals[neighbor] we perform a union of the node with the neighbor.
//        After iterating through all the nodes, we create a map group. group[A] contains the number of nodes (from the nodes array) that belong to the same component A. For every node in nodes, we find its component and increment the size of that component by 1 in groups, i.e., group[find(node)] = group[find(node)] + 1.
//        We iterate through all the entries in the group and, for each key, get the value called size corresponding to it. Add (size * (size + 1) / 2) to the goodPaths.
//        Return goodPaths.

//Complexity Analysis
//        Here, n is the number of nodes.
//        Time complexity: O(n⋅log(n))
//        For TT operations, the amortized time complexity of the union-find algorithm (using path compression with union by rank) is O(alpha(T)). Here, \alpha(T)α(T) is the inverse Ackermann function that grows so slowly, that it doesn't exceed 44 for all reasonable TT (approximately T < 10^{600}T<10
//        600
//        ). You can read more about the complexity of union-find here. Because the function grows so slowly, we consider it to be O(1). We iterate over each edge once from the larger value node to the smaller one, or if the neighbours (nodes that share an edge) have equal value, we iterate that edge twice, which is also linear. To iterate over n - 1n−1 edges, we have to perform O(n)O(n) operations which needs O(n)O(n) time.
//        We also need a map valuesToNodes having sorted keys. Each operation in such a data structure comes with a loglog factor. We push all the n nodes into the map and iterate over all of them, which further adds O(n \cdot log(n)))O(n⋅log(n))) time.
//        The group map has unsorted keys, and each of its operation takes O(1) time on average. We need O(n) time to iterate through all of the nodes to find the set size using it.
//        Additionally, we need O(n) time each to initialize the adj, parent and rank arrays.
//        Space complexity: O(n)
//        We require O(n) space each for the adj, parent and rank arrays.
//        We also require O(n) space for the valuesToNodes and the group maps.


public class NumberOfGoodPaths {
    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++)
                parent[i] = i;
            rank = new int[size];
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union_set(int x, int y) {
            int xset = find(x), yset = find(y);
            if (xset == yset) {
                return;
            } else if (rank[xset] < rank[yset]) {
                parent[xset] = yset;
            } else if (rank[xset] > rank[yset]) {
                parent[yset] = xset;
            } else {
                parent[yset] = xset;
                rank[xset]++;
            }
        }
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }

        int n = vals.length;
        // Mapping from value to all the nodes having the same value in sorted order of
        // values.
        Map<Integer, List<Integer>> valuesToNodes = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            valuesToNodes.computeIfAbsent(vals[i], value -> new ArrayList<Integer>()).add(i);
        }

        UnionFind dsu = new UnionFind(n);
        int goodPaths = 0;

        // Iterate over all the nodes with the same value in sorted order, starting from
        // the lowest value.
        for (int value : valuesToNodes.keySet()) {
            // For every node in nodes, combine the sets of the node and its neighbors into
            // one set.
            for (int node : valuesToNodes.get(value)) {
                if (!adj.containsKey(node))
                    continue;
                for (int neighbor : adj.get(node)) {
                    // Only choose neighbors with a smaller value, as there is no point in
                    // traversing to other neighbors.
                    if (vals[node] >= vals[neighbor]) {
                        dsu.union_set(node, neighbor);
                    }
                }
            }
            // Map to compute the number of nodes under observation (with the same values)
            // in each of the sets.
            Map<Integer, Integer> group = new HashMap<>();
            // Iterate over all the nodes. Get the set of each node and increase the count
            // of the set by 1.
            for (int u : valuesToNodes.get(value)) {
                group.put(dsu.find(u), group.getOrDefault(dsu.find(u), 0) + 1);
            }
            // For each set of "size", add size * (size + 1) / 2 to the number of goodPaths.
            for (int key : group.keySet()) {
                int size = group.get(key);
                goodPaths += size * (size + 1) / 2;
            }
        }
        return goodPaths;
    }
}