package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2206 {
    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    static int[][] map;
    static final int[] DIRECTIONS_ROW = {-1, 0, 1, 0};
    static final int[] DIRECTIONS_COL = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //0:길, 1:벽

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = bf.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }//for end
        }//for end

    }

    public static void bfs(int startRow, int startCol, int R, int C) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(startRow, startCol));
        map[startRow][startCol] = -1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowRow = now.row;
            int nowCol = now.col;
            int nowDist = map[nowRow][nowCol];

            for (int i = 0; i < 4; i++) {
                int newRow = nowRow + DIRECTIONS_ROW[i];
                int newCol = nowCol + DIRECTIONS_COL[i];

                if ((newRow>=0 && newRow<R)
                    && (newCol>=0 && newCol<C)
                    && map[newRow][newCol] == 0) {
                    queue.add(new Point(newRow, newCol));
                    map[newRow][newCol] = nowDist-1;
                }//if end
            }//for end


        }//while end
    }
}
