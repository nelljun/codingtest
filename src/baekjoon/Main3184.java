package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3184 {
    static class Position {
        int row, col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static char[][] garden;
    static boolean[][] isChecked;

    static int oCnt = 0;
    static int vCnt = 0;

    static int oCntTemp = 0;
    static int vCntTemp = 0;

    //u r d l 순서
    static final int[] DIRECTION_ROW = {-1, 0, 1, 0};
    static final int[] DIRECTION_COL = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        garden = new char[R][C];
        isChecked = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            garden[i] = bf.readLine().toCharArray();
        }//for end

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if ((garden[i][j]=='o' || garden[i][j]=='v')
                        && !isChecked[i][j]) {
                    oCntTemp = 0;
                    vCntTemp = 0;

                    bfs(i, j, R, C);

                    if (oCntTemp > vCntTemp) {
                        oCnt += oCntTemp;
                    } else {
                        vCnt += vCntTemp;
                    }
                }
            }//for end
        }//for end

        System.out.println(oCnt+" "+vCnt);
    }

    public static void bfs(int row, int col, int R, int C) {
        Queue<Position> queue = new LinkedList<>();

        queue.add(new Position(row, col));
        isChecked[row][col] = true;

        while (!queue.isEmpty()) {
            Position now = queue.poll();

            switch (garden[now.row][now.col]) {
                case 'o' : oCntTemp++;
                break;
                case 'v' : vCntTemp++;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = now.row + DIRECTION_ROW[i];
                int newCol = now.col + DIRECTION_COL[i];

                if ((newRow>=0 && newRow<R)
                        && (newCol>=0 && newCol<C)
                        && garden[newRow][newCol]!='#'
                        && !isChecked[newRow][newCol]) {
                    isChecked[newRow][newCol] = true;
                    queue.add(new Position(newRow, newCol));
                }
            }//for end
        }//while end


    }//bfs() end

}
