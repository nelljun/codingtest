package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178 {
    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int[][] board;
    static final int[] DIRECTIONS_ROW = {-1, 0, 1 ,0};
    static final int[] DIRECTIONS_COL = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        board = new int[row][col];

        for (int i = 0; i < row; i++) {
            String line = bf.readLine();
            for (int j = 0; j < col; j++) {
                board[i][j] = line.charAt(j) - '0';
            }//for end
        }//for end

        bfs(0, 0, row , col);

        System.out.println(board[row-1][col-1]);
    }

    public static void bfs(int startRow, int startCol, int row, int col) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(startRow, startCol));

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowRow = now.row;
            int nowCol = now.col;
            int dist = board[nowRow][nowCol];

            if (nowRow==row-1 && nowCol==col-1) break;

            for (int i = 0; i < 4; i++) {
                int newRow = nowRow + DIRECTIONS_ROW[i];
                int newCol = nowCol + DIRECTIONS_COL[i];

                if ((newRow>=0 && newRow<row)
                        && (newCol>=0 && newCol<col)
                        && board[newRow][newCol]==1
                        && !(newRow==0 && newCol==0)) {
                    queue.add(new Point(newRow, newCol));
                    board[newRow][newCol] = dist+1;
                }//if end

            }//for end
        }//while end

    }
}
