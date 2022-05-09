package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1347 {

    //DOWN LEFT UP RIGHT 순으로
    static int[] DIRECTIONS_ROW = {1, 0, -1, 0};
    static int[] DIRECTIONS_COL = {0, -1, 0, 1};

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return row == point.row && col == point.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(bf.readLine());

        int nowRow = 0;
        int nowCol = 0;
        int nowDirIdx = 0;

        char[] moveInfos = bf.readLine().toCharArray();

        Set<Point> pointSet = new HashSet<>();
        pointSet.add(new Point(nowRow, nowCol));

        for (int i = 0; i < moveInfos.length; i++) {


            switch (moveInfos[i]) {
                case 'R' : nowDirIdx = (++nowDirIdx)%4;
                break;
                case 'L' : nowDirIdx = (--nowDirIdx<0)? 3 : nowDirIdx;
                break;
                case 'F' :
                    nowRow += DIRECTIONS_ROW[nowDirIdx];
                    nowCol += DIRECTIONS_COL[nowDirIdx];

                    pointSet.add(new Point(nowRow, nowCol));
                    break;
            }//switch~case end
        }//for end

        int maxRow = 0;
        int maxCol = 0;
        int minRow = 0;
        int minCol = 0;

        for (Point point : pointSet) {
            maxRow = Math.max(maxRow, point.row);
            maxCol = Math.max(maxCol, point.col);
            minRow = Math.min(minRow, point.row);
            minCol = Math.min(minCol, point.col);
        }//for end

        char[][] answerChar = new char[maxRow-minRow+1][maxCol-minCol+1];

        for (int i = 0; i < maxRow - minRow + 1; i++) {
            Arrays.fill(answerChar[i], '#');
        }//for end

        for (Point point : pointSet) {
            answerChar[point.row-minRow][point.col-minCol] = '.';
        }//for end

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < maxRow - minRow + 1; i++) {
            for (int j = 0; j < maxCol - minCol + 1; j++) {
                sb.append(answerChar[i][j]);
            }//for end
            sb.append("\n");
        }//for end

        System.out.println(sb);
    }
}
