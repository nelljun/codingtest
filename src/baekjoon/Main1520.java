package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1520 {
    static int R;
    static int C;
    static int[][] map;
    static boolean[][] isVisited;

    static int answer;

    static int[] DIRECTIONS_ROW = {1, 0, -1, 0};
    static int[] DIRECTIONS_COL = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        isVisited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }//for end
        }//for end

        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs(int row, int col) {
        if (row==R-1 && col==C-1) {
            answer++;
            return;
        }

        int nowHeight = map[row][col];

        for (int i = 0; i < 4; i++) {
            int newRow = row + DIRECTIONS_ROW[i];
            int newCol = col + DIRECTIONS_COL[i];

            if ((newRow>=0 && newRow<R)
                    && (newCol>=0 && newCol<C)
                    && (map[newRow][newCol] < nowHeight)
                    && !isVisited[newRow][newCol]) {
                isVisited[newRow][newCol] = true;
                dfs(newRow, newCol);
                isVisited[newRow][newCol] = false;
            }
        }//for end
    }//dfs() end
}
