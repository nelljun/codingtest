package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main2210 {
    static String[][] board = new String[5][5];
    static StringBuilder sb = new StringBuilder();
    static Set<String> strSet = new HashSet<>();

    static int[] DIRECTIONS_ROW = {-1, 0, 1, 0};
    static int[] DIRECTIONS_COL = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            board[i] = bf.readLine().split(" ");
        }//for en

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                sb.setLength(0);
                sb.append(board[i][j]);
                dfs(i, j);
            }//for end
        }//for end

        System.out.println(strSet.size());
    }

    public static void dfs(int row, int col) {
        if (sb.length()==6) {
            strSet.add(sb.toString());
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newRow = row + DIRECTIONS_ROW[i];
            int newCol = col + DIRECTIONS_COL[i];

            if ((newRow>=0 && newRow<=4) && (newCol>=0 && newCol<=4)) {
                sb.append(board[newRow][newCol]);
                dfs(newRow, newCol);
                sb.deleteCharAt(sb.length() - 1);
            }
        }//for end

    }
}
