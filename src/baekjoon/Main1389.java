package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1389 {

    static int[][] kevinBoard;
    static boolean[] isChecked;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        kevinBoard = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            kevinBoard[from][to] = 1;
            kevinBoard[to][from] = 1;
        }//for end

        isChecked = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i!=j && kevinBoard[i][j] == 0) {
                    bfs(i, N);
                    break;
                }
            }//for end
        }//for end

        int minKevinIdx = 1;
        int minKevin  = Arrays.stream(kevinBoard[minKevinIdx]).sum();

        for (int i = 2; i <= N; i++) {
            int kevin = Arrays.stream(kevinBoard[i]).sum();

            if (minKevin>kevin) {
                minKevinIdx = i;
                minKevin = kevin;
            }
        }//for end

        System.out.println(minKevinIdx);
    }

    public static void bfs(int from, int N) {
        queue.clear();
        Arrays.fill(isChecked, false);

        queue.add(from);
        isChecked[from] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            int distance = kevinBoard[from][now];

            for (int i = 1; i <= N; i++) {
                if (kevinBoard[now][i]==1 && !isChecked[i]) {
                    queue.add(i);
                    kevinBoard[from][i] = distance+1;
                    kevinBoard[i][from] = distance+1;
                    isChecked[i] = true;
                }
            }//for end
        }//while end
    }


}
