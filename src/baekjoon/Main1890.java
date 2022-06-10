package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main1890 {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(bf.readLine());

        board = new int[length][length];

        for (int i = 0; i < length; i++) {
            String[] rowInfo = bf.readLine().split(" ");
            for (int j = 0; j < length; j++) {
                board[i][j] = Integer.parseInt(rowInfo[j]);
            }//for end
        }//for end

        System.out.println(bfs(0, 0, length));
    }

    public static long bfs(int row, int col, int length) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{row,col});

        long cnt = 0L;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int distance = board[now[0]][now[1]];

            if (distance==0) {
                cnt++;
                continue;
            }

            int newRow = now[0] + distance;
            int newCol = now[1] + distance;

            if (newRow<length) {
                queue.add(new int[]{newRow, now[1]});
            }
            if (newCol<length) {
                queue.add(new int[]{now[0], newCol});
            }

        }//while end

        return cnt;
    }

//    public static void dfs(int row, int col, int length) {
//        if (row==length-1 && col==length-1) {
//            answer++;
//            return;
//        }
//        if (row>=length || col>=length) {
//            return;
//        }
//
//        dfs(row+board[row][col], col, length);
//        dfs(row, col+board[row][col], length);
//    }
}
