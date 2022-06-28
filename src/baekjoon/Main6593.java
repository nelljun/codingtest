package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main6593 {
    static char[][][] building;
    static int[][][] distance;
    static final int[] DIRECTIONS_LENGTH = {1, -1, 0, 0, 0, 0};
    static final int[] DIRECTIONS_ROW = {0, 0, 1, -1, 0, 0};
    static final int[] DIRECTIONS_COL = {0, 0, 0, 0, 1, -1};

    static class Point {
        int length;
        int row;
        int col;

        public Point(int length, int row, int col) {
            this.length = length;
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        //금 : #, 비어있는 칸 : .
        //S에서 시작, E로 탈출

        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (L==0 && R==0 && C==0) {
                System.out.println(sb);
                return;
            }

            building = new char[L][R][C];
            distance = new int[L][R][C];

            Point start = null, end = null;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = bf.readLine();

                    for (int k = 0; k < C; k++) {
                        char now = line.charAt(k);
                        if (now=='S') {
                            start = new Point(i, j, k);
                        } else if (now=='E') {
                            end = new Point(i, j, k);
                        }//if~else end
                        building[i][j][k] = now;
                    }//for end
                }//for end

                bf.readLine();
            }//for end

            bfs(start, end, L, R, C);

            if (distance[end.length][end.row][end.col]!=0) {
                sb.append("Escaped in ").append(distance[end.length][end.row][end.col]-1).append(" minute(s).").append("\n");
            } else {
                sb.append("Trapped!").append("\n");
            }
        }//while end


    }

    public static void bfs(Point start, Point end, int length, int row, int col) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(start);
        distance[start.length][start.row][start.col] = 1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowLength = now.length;
            int nowRow = now.row;
            int nowCol = now.col;
            int nowDist = distance[nowLength][nowRow][nowCol];

            if (nowLength==end.length && nowRow==end.row && nowCol==end.col) {
                return;
            }

            for (int i = 0; i < 6; i++) {
                int newLength = nowLength + DIRECTIONS_LENGTH[i];
                int newRow = nowRow + DIRECTIONS_ROW[i];
                int newCol = nowCol + DIRECTIONS_COL[i];

                if ((newLength>=0 && newLength<length)
                        && (newRow>=0 && newRow<row)
                        && (newCol>=0 && newCol<col)
                        && (building[newLength][newRow][newCol] == '.' || building[newLength][newRow][newCol] == 'E')
                        && distance[newLength][newRow][newCol] == 0) {
                    queue.add(new Point(newLength, newRow, newCol));
                    distance[newLength][newRow][newCol] = nowDist+1;
                }//if end
            }//for end


        }//while end
    }
}
