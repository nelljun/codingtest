package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2583 {
    static int[][] board;
    static final int[] DIRECTIONS_ROW = {-1, 0, 1 ,0};
    static final int[] DIRECTIONS_COL = {0, 1, 0, -1};

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int totalCnt = Integer.parseInt(st.nextToken());

        board = new int[R][C];

        for (int i = 0; i < totalCnt; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int c1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            for (int j = r1; j < r2; j++) {
                for (int k = c1; k < c2; k++) {
                    board[j][k] = 1;
                }//for end
            }//for end
        }//for end

        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j]==0) {
                    answerList.add(bfs(i, j, R, C));
                };
            }//for end
        }//for end

        Collections.sort(answerList);
        int size = answerList.size();

        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\n");

        for (int i = 0; i < size; i++) {
            sb.append(answerList.get(i)).append(" ");
        }//for end

        System.out.println(sb);
    }

    public static int bfs(int startRow, int startCol, int R, int C) {
        Queue<Point> queue = new LinkedList<>();

        int cnt = 0;

        queue.add(new Point(startRow, startCol));
        board[startRow][startCol] = 1;
        cnt++;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowRow = now.row;
            int nowCol = now.col;
            int area = board[nowRow][nowCol];

            for (int i = 0; i < 4; i++) {
                int newRow = nowRow + DIRECTIONS_ROW[i];
                int newCol = nowCol + DIRECTIONS_COL[i];

                if ((newRow>=0 && newRow<R)
                        && (newCol>=0 && newCol<C)
                        && board[newRow][newCol]==0) {
                    queue.add(new Point(newRow, newCol));
                    board[newRow][newCol] = ++cnt;
                }
            }//for end
        }//while end

        return cnt;
    }//bfs() end
}
