package src.programmers;

import java.util.*;

public class 가장먼노드 {
    public static void main(String[] args) {
        int[][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        solution(6, edge);
    }

    static LinkedList<Integer>[] adjList;
    static boolean[] isVisited;
    static int[] distance;

    public static int solution(int n, int[][] edge) {
         adjList = new LinkedList[n];
         isVisited = new boolean[n];
         distance = new int[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new LinkedList<>();
        }//for end

        for (int[] info : edge) {
            int a = info[0];
            int b = info[1];

            adjList[a-1].add(b);
            adjList[b-1].add(a);
        }//for end

        return bfs(1);
    }//solution() end
    
    public static int bfs(int now) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(now);
        isVisited[0] = true;

        int count = 0;
        int result = 0;

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int point = queue.poll();
                distance[point-1] = count;

                Iterator<Integer> iterator = adjList[point-1].iterator();
                while (iterator.hasNext()) {
                    int adjPoint = iterator.next();
                    if (!isVisited[adjPoint-1]) {
                        queue.add(adjPoint);
                        isVisited[adjPoint-1] = true;
                    }
                }//while end
            }//for end

            result = queueSize;
        }
        return result;
    }
}
