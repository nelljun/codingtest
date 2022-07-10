package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14500 {
    static int[][] distBoard;
    static int[][] board;
    static int max = 0;
    static final int[] DIRECTIONS_ROW = {-1, 0, 1, 0};
    static final int[] DIRECTIONS_COL = {0, 1, 0, -1};

    static class Point {
        int row;
        int col;
        int sum;

        public Point(int row, int col, int sum) {
            this.row = row;
            this.col = col;
            this.sum = sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        distBoard = new int[R][C];
        board = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }//for end
        }//for end


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int k = 0; k < R; k++) {
                    Arrays.fill(distBoard[k], 0);
                }//for end
                bfs(i, j, R, C);
            }//for end
        }//for end

        System.out.println(max);

    }

    public static void bfs(int startRow, int startCol, int R, int C) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(startRow, startCol, board[startRow][startCol]));
        distBoard[startRow][startCol] = 1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int dist = distBoard[now.row][now.col];

            if (dist==4) {
                max = Math.max(max, now.sum);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = now.row+DIRECTIONS_ROW[i];
                int newCol = now.col+DIRECTIONS_COL[i];

                if ((newRow>=0 && newRow<R)
                        && (newCol>=0 && newCol<C)
                        && distBoard[newRow][newCol]==0) {
                    distBoard[newRow][newCol] = dist+1;
                    queue.add(new Point(newRow, newCol, now.sum+board[newRow][newCol]));
                }

            }//for end

        }//while end
    }//bfs() end
}
