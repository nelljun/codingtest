package src.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
        solution2(board);
    }

    static boolean[][] isVisited;
    static int min = Integer.MAX_VALUE;

    static final int[] DIRECTION_ROW = {0, 1, 0, -1};
    static final int[] DIRECTION_COL = {1, 0, -1, 0};

    public static int solution(int[][] board) {
        //1 : 벽
        //직선 : 100, 코너 : 500
        //최소 비용

        isVisited = new boolean[board.length][board.length];

        dfs(-1, 0, 0, 0, board);

        return min;
    }//solution() end

    public static void dfs(int prevDir, int row, int col, int price, int[][] board) {
        if (row==board.length-1 && col==board.length-1) {
            min = Math.min(min, price);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newRow = row + DIRECTION_ROW[i];
            int newCol = col + DIRECTION_COL[i];

            if ((newRow>=0 && newRow<board.length)
                    && (newCol>=0 && newCol<board.length)
                    && board[newRow][newCol] == 0
                    && !isVisited[newRow][newCol]) {
                int dirDiff = (prevDir==-1)? 0 : i - prevDir;
                int newPrice = (dirDiff%2==0)? price+100 : price+600;

                isVisited[newRow][newCol] = true;
                dfs(i, newRow, newCol, newPrice, board);
                isVisited[newRow][newCol] = false;
            }
        }//for end
    }//dfs() end

    static class Point {
        int row;
        int col;
        int direction;

        public Point(int row, int col, int direction) {
            this.row = row;
            this.col = col;
            this.direction = direction;
        }
    }
    public static int solution2(int[][] board) {
        int length = board.length;
        int[][] accessCnt = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int newRow = i+DIRECTION_ROW[k];
                    int newCol = j+DIRECTION_COL[k];

                    if ((newRow>=0 && newRow<board.length)
                            && (newCol>=0 && newCol<board.length)
                            && board[newRow][newCol] == 0) {
                        cnt++;
                    }
                }//for end
                accessCnt[i][j] = cnt;
            }//for end
        }//for end

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(0, 0, -1));

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowRow = now.row;
            int nowCol = now.col;
            int nowDirection = now.direction;
            int nowPrice = board[nowRow][nowCol];

            if (nowRow == length-1 && nowCol == length-1 && accessCnt[nowRow][nowCol]==0) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = nowRow+DIRECTION_ROW[i];
                int newCol = nowCol+DIRECTION_COL[i];

                if ((newRow>=0 && newRow<board.length)
                        && (newCol>=0 && newCol<board.length)
                        && board[newRow][newCol] != 1
                        && accessCnt[newRow][newCol] != 0) {

                    accessCnt[newRow][newCol]--;
                    queue.add(new Point(newRow, newCol, i));

                    int dirDiff = (nowDirection==-1)? 0 : i - nowDirection;

                    int newPrice = (dirDiff%2==0)? nowPrice+100 : nowPrice+600;

                    board[newRow][newCol] = (board[newRow][newCol]==0)? newPrice : Math.min(board[newRow][newCol], newPrice);
                }
            }//for end
        }//while end

        return board[length-1][length-1];
    }//solution() end

    public static int solution3(int[][] board) {
        int length = board.length;
        int[][][] dp = new int[length][length][4];

        return 0;
    }//solution() end

}
