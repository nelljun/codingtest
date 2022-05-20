package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main2667 {
    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    static int[][] board;
    static boolean[][] isChecked;
    //위 -> 오 -> 아 -> 왼 순서
    static final int[] DIRECTIONS_ROW = {-1, 0, 1, 0};
    static final int[] DIRECTIONS_COL = {0, 1, 0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        board = new int[N][N];
        isChecked = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String row = bf.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = row.charAt(j) - '0';
            }//for end
        }//for end

        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j]==1 && !isChecked[i][j]) {
                    answerList.add(bfs(i, j, N));
                }
            }//for end
        }//for end

        StringBuilder sb = new StringBuilder();

        sb.append(answerList.size()).append("\n");

        answerList.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .forEach(i -> {
                    sb.append(i).append("\n");
                });

        System.out.println(sb);
        
    }//main() end
    
    //bfs로 한 단지를 순회 후 해당 단지에 속하는 집의 수 리턴
    public static int bfs(int startRow, int startCol, int N) {
        Queue<Point> queue = new LinkedList<>();

        int cnt = 0;

        queue.add(new Point(startRow, startCol));
        isChecked[startRow][startCol] = true;
        cnt++;


        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowRow = now.row;
            int nowCol = now.col;

            for (int i = 0; i < 4; i++) {
                int newRow = nowRow + DIRECTIONS_ROW[i];
                int newCol = nowCol + DIRECTIONS_COL[i];

                //범위 벗어나지 않고, board값이 1이고, isChecked가 false면 queue에 추가
                if ((newRow>=0 && newRow<N) && (newCol>=0 && newCol<N)
                    && board[newRow][newCol]==1
                    && !isChecked[newRow][newCol]) {
                    queue.add(new Point(newRow, newCol));
                    isChecked[newRow][newCol] = true;
                    cnt++;
                }
            }//for end
        }//while end

        return cnt;
    }//bfs() end
}
