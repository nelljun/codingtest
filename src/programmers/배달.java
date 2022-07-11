package src.programmers;

import java.util.Arrays;

public class 배달 {

    public static void main(String[] args) {
        int[][] road1 = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        solution(5, road1, 3);
    }//main() end

    static int[] distance;
    static int[][] graph;
    static boolean[] isVisited;

    public static int solution(int N, int[][] road, int K) {
        distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        graph = new int[N][N];
        isVisited = new boolean[N];
        isVisited[0] = true;

        //a-b 경로 중 최소 시간으로 세팅
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];

            graph[a-1][b-1] = (graph[a-1][b-1]==0)? c : Math.min(graph[a-1][b-1], c);
            graph[b-1][a-1] = graph[a-1][b-1];
        }//for end

        while (true) {
            int idx = getSmallestIdx();

            if (idx==0) break;

            for (int i = 0; i < N; i++) {
                if (graph[idx][i] != 0
                        && !isVisited[i]
                        && distance[idx] + graph[idx][i] < distance[i]) {
                    distance[i] = distance[idx] + graph[idx][i];
                }
            }//for end

            isVisited[idx] = true;
        }//while end

        Arrays.sort(distance);

        int i = 0;
        for (; i < distance.length; i++) {
            if (distance[i] > K) break;
        }//for end

        return i;
    }//solution() end

    public static int getSmallestIdx() {
        int min = Integer.MAX_VALUE;
        int idx = 0;

        for (int i = 0; i < distance.length; i++) {
            if (distance[i] < min && !isVisited[i]) {
                idx = i;
                min = distance[i];
            }
        }//for end

        return idx;
    }//getSmallestIdx() end

}
