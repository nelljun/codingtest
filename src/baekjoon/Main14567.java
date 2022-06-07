package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main14567 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int total = Integer.parseInt(st.nextToken());
        int condition = Integer.parseInt(st.nextToken());

        int[][] info = new int[total+1][total+1];
        int[] dp = new int[total+1];
        Set<Integer> postSet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < condition; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int pre = Integer.parseInt(st.nextToken());
            int post = Integer.parseInt(st.nextToken());

            postSet.add(post);

            info[pre][post] = 1;
        }//for end

        for (int i = 1; i <= total; i++) {
            if(!postSet.contains(i)) {
                dp[i] = 1;
                queue.add(i);
            }
        }//for end

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            int nowMinSem = dp[now];

            for (int i = now+1; i <= total; i++) {
                if (info[now][i]==1) {
                    dp[i] = nowMinSem+1;
                    queue.add(i);
                }
            }//for end
        }//while end

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= total; i++) {
            sb.append(dp[i]).append(" ");
        }//for end

        System.out.println(sb);
    }

    public static void main2(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int total = Integer.parseInt(st.nextToken());
        int condition = Integer.parseInt(st.nextToken());

        int[][] graph = new int[total+1][total+1];
        int[] dp = new int[total+1];

        for (int i = 0; i < condition; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int pre = Integer.parseInt(st.nextToken());
            int post = Integer.parseInt(st.nextToken());

            graph[pre][post] = 1;
        }//for end

        for (int i = 1; i <= total; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (graph[j][i]==1) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }//for end
        }//for end


    }
}
