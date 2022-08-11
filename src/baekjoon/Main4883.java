package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main4883 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int cnt = 1;

        while (true) {
            int n = Integer.parseInt(bf.readLine());

            if (n==0) {
                break;
            }//if end

            int[][] graph = new int[n][3];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < 3; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }//for end
            }//for end

            memoize(graph);

            sb.append(cnt++).append(". ").append(graph[n-1][1]).append("\n");
        }//while end

        System.out.println(sb);
    }//main() end

    public static void memoize(int[][] graph) {
        int length = graph.length;

        graph[1][0] += graph[0][1];
        graph[1][1] += min(graph[0][1], graph[0][1] + graph[0][2], graph[1][0]);
        graph[1][2] += min(graph[0][1], graph[0][1] + graph[0][2], graph[1][1]);

        for (int i = 2; i < length; i++) {
            graph[i][0] += min(graph[i-1][0], graph[i-1][0] + graph[i-1][1], graph[i-1][1]);
            graph[i][1] += min();
            graph[i][2] += Math.min(graph[i-1][1], graph[i-1][2]);
        }//for end
    }//memoize() end

    public static int min(int... numbers) {
        Arrays.sort(numbers);

        return numbers[0];
    }
}
