package daily_leetcode_challenge;

import java.util.ArrayList;
import java.util.List;


//Algorithm
//        Create an adjacency matrix adjMatrix to store the edges. This matrix will be of size 26 * 26, as we have only lowercase English letters, with value 11 at cell (x, y) if there is an edge between character x and y, 00 otherwise. Also, create an array visited that will help us track if a character has been visited by DFS yet.
//
//        Iterate over all the characters in their integer form ("a" = 0, "b" = 1, etc.), from 00 until 2525, and for each character c:
//
//        If c is not visited yet (visited[c] = 0), perform a DFS starting with c and store all the traversed characters in a vector component, also store the minimum of all these characters in a variable minChar.
//        Iterate over all the characters in component and map all these characters to minChar in a vector mappingChar. This map will store the characters to which the baseStr characters will finally map.
//        Iterate over the string baseStr and store the mapped character in the string ans.
//
//        Return ans.


public class SmallestEquivalentString {
    private static int minChar;

    public static void DFS(int src, Integer[][] adjMatrix, Integer visited[], List<Integer> component) {
        // Mark the character as visited.
        visited[src] = 1;
        // Add it to the list.
        component.add(src);
        // Update the minimum character in the component.
        minChar = Math.min(minChar, src);

        for (int i = 0; i < 26; i++) {
            // Perform DFS if the edge exists and the node isn't visited yet.
            if (adjMatrix[src][i] != null && visited[i] == null) {
                DFS(i, adjMatrix, visited, component);
            }
        }
    }

    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Adjacency matrix to store edges.
        Integer adjMatrix[][] = new Integer[26][26];
        for (int i = 0; i < s1.length(); i++) {
            adjMatrix[s1.charAt(i) - 'a'][s2.charAt(i) - 'a'] = 1;
            adjMatrix[s2.charAt(i) - 'a'][s1.charAt(i) - 'a'] = 1;
        }

        // Array to store the final character mappings.
        int mappingChar[] = new int[26];
        for (int i = 0; i < 26; i++) {
            mappingChar[i] = i;
        }

        // Array to keep visited nodes during DFS.
        Integer visited[] = new Integer[26];
        for (int c = 0; c < 26; c++) {
            if (visited[c] == null) {
                // Store the characters in the current component.
                List<Integer> component = new ArrayList<>();
                // Variable to store the minimum character in the component.
                minChar = 27;

                DFS(c, adjMatrix, visited, component);

                // Map the characters in the component to the minimum character.
                for (int vertex : component) {
                    mappingChar[vertex] = minChar;
                }
            }
        }

        String ans = "";
        // Create the answer string.
        for (char c : baseStr.toCharArray()) {
            ans += (char) (mappingChar[c - 'a'] + 'a');
        }
        return ans;
    }
}