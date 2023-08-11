package Assignment;

//Question Number 4(a)

import java.util.*;

class Solution {
    public int minSteps(int N, int[][] r) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[N + 1];
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] prerequisite : r) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
            indegree[prerequisite[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int task = queue.poll();
                N--;
                for (int nextTask : graph.get(task)) {
                    if (--indegree[nextTask] == 0) {
                        queue.offer(nextTask);
                    }
                }
            }
            steps++;
        }
        
        return N == 0 ? steps : -1;
    }
}

