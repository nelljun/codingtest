package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1495 {
    static int[] vArr;
    static int[][] dp;
    static int max = -1;

    //dp 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        vArr = new int[N];

        st = new StringTokenizer(bf.readLine(), " ");

        for (int i = 0; i < N; i++) {
            vArr[i] = Integer.parseInt(st.nextToken());
        }//for end

        dp = new int[N][M+1];

        //첫 번째 곡
        if (S + vArr[0] <= M) dp[0][S + vArr[0]] = 1;
        if (S - vArr[0] >= 0) dp[0][S - vArr[0]] = 1;

        //두 번째 곡
        for (int i = 1; i < N; i++) {
            calculate(i, M);
        }//for end

        int max = -1;

        for (int i = M; i >= 0; i--) {
            if (dp[N-1][i] == 1) {
                max = i;
                break;
            }
        }//for end

        System.out.println(max);

    }

    public static void calculate(int index, int M) {
        for (int i = 0; i <= M; i++) {
            if (dp[index-1][i] == 1) {
                if (i + vArr[index] <= M) dp[index][i + vArr[index]] = 1;
                if (i - vArr[index] >= 0) dp[index][i - vArr[index]] = 1;
            }
        }//for end
    }



    public static void main2(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        vArr = new int[N];

        st = new StringTokenizer(bf.readLine(), " ");

        for (int i = 0; i < N; i++) {
            vArr[i] = Integer.parseInt(st.nextToken());
        }//for end

        System.out.println(bfs(S, N, M));
    }

    //dfs 시간초과
    public static void dfs(int now, int index, int total, int limit) {
        if (index==total) {
            max = Math.max(max, now);
            return;
        }

        if ((now+vArr[index])<=limit) {
            dfs(now+vArr[index], index+1, total, limit);
        }
        if ((now-vArr[index])>=0) {
            dfs(now-vArr[index], index+1, total, limit);
        }
    }
    //bfs 메모리 초과
    public static int bfs(int start, int total, int limit) {
        Queue<Integer> queue = new LinkedList<>();

        int index = 0;

        queue.add(start);

        int cnt = 1;

        int tempCnt = 0;

        while (!queue.isEmpty() && index!=total) {
            while (cnt--!=0) {
                int now = queue.poll();

                if (now+vArr[index]<=limit) {
                    queue.add(now+vArr[index]);
                    tempCnt++;
                }
                if ((now-vArr[index])>=0) {
                    queue.add(now-vArr[index]);
                    tempCnt++;
                }
            }//while end
            index++;
            cnt = tempCnt;
            tempCnt = 0;
        }//while end

        int max = -1;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            max = Math.max(max, temp);
        }//while end

        return max;
    }
}
