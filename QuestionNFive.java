package Assignment;

//Question Number 5

import java.util.ArrayList;
import java.util.List;

public class QuestionNFive {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            graph.get(connection[0]).add(new int[]{connection[1], 1});  // True indicates the edge direction a -> b
            graph.get(connection[1]).add(new int[]{connection[0], 0}); // False indicates the edge direction b -> a
        }
        
        boolean[] visited = new boolean[n];
        int[] count = new int[]{0}; // Use an array to hold the count value
        dfs(0, graph, visited, count);
        return count[0];
    }
    
    private void dfs(int node, List<List<int[]>> graph, boolean[] visited, int[] count) {
        visited[node] = true;
        for (int[] neighbor : graph.get(node)) {
            if (!visited[neighbor[0]]) {
                count[0] += neighbor[1]; // Increment count if edge needs to be changed
                dfs(neighbor[0], graph, visited, count);
            }
        }
    }
}


