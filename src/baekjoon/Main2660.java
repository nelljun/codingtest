package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2660 {
    static int[][] graph;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int memberCnt = Integer.parseInt(bf.readLine());

        graph = new int[memberCnt][memberCnt];

        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int member1 = Integer.parseInt(st.nextToken());
            int member2 = Integer.parseInt(st.nextToken());

            if (member1==-1 && member2==-1) break;

            graph[member1-1][member2-1] = 1;
            graph[member2-1][member1-1] = 1;
        }//while end

        int[] scoreArr = new int[memberCnt];

        int minScore = 51;

        for (int i = 0; i < memberCnt; i++) {
            int[] distFromPerson = new int[memberCnt];
            bfs(i, distFromPerson);
            int maxDist = Arrays.stream(distFromPerson)
                                    .max()
                                    .getAsInt();

            minScore = Math.min(minScore, maxDist);

            scoreArr[i] = maxDist;
        }//for end

        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < memberCnt; i++) {
            if (scoreArr[i]==minScore) {
                answerList.add(i);
            }
        }//for end

        StringBuilder sb = new StringBuilder();

        sb.append(minScore-1).append(" ")
          .append(answerList.size()).append("\n");

        answerList.forEach(i -> sb.append(i+1).append(" "));

        System.out.println(sb);
    }

    public static void bfs(int start, int[] distFromPerson) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        distFromPerson[start] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            int nowDist = distFromPerson[now];

            for (int i = 0; i < graph.length; i++) {
                if (graph[now][i]==1 && distFromPerson[i]==0) {
                    queue.add(i);
                    distFromPerson[i] = nowDist+1;
                }
            }//for end
        }//while end
    }
}
