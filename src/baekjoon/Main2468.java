package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2468 {
    static int[][] board;
    static Set<Integer> set = new HashSet<>();
    static boolean[][] isVisited;
    static int N;
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

        N = Integer.parseInt(bf.readLine());

        board = new int[N][N];
        isVisited = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                board[i][j] = height;
                set.add(height);
            }//for end
        }//for end

        //모든 높이가 같은 경우 초기값 1
        int max = 1;

        for (int height : set) {
            for (int i = 0; i < N; i++) {
                Arrays.fill(isVisited[i], false);
            }//for end

            int num = getNumOfSafeArea(height);

            max = Math.max(max, num);
        }//for end

        System.out.println(max);
    }

    public static int getNumOfSafeArea(int height) {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j]>height && !isVisited[i][j]) {
                    cnt++;
                    bfs(i, j, height);
                }
            }//for end
        }//for end

        return cnt;
    }

    public static void bfs(int startRow, int startCol, int height) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(startRow, startCol));
        isVisited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowRow = now.row;
            int nowCol = now.col;

            for (int i = 0; i < 4; i++) {
                int newRow = nowRow + DIRECTIONS_ROW[i];
                int newCol = nowCol + DIRECTIONS_COL[i];

                if ((newRow>=0 && newRow<N)
                        && (newCol>=0 && newCol<N)
                        && board[newRow][newCol]>height
                        && !isVisited[newRow][newCol]) {
                    queue.add(new Point(newRow, newCol));
                    isVisited[newRow][newCol] = true;
                }
            }//for end
        }//while end
    }

}
