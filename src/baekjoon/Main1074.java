package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1074 {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int size = 1;

        for (int i = 0; i < N; i++) {
            size *= 2;
        }//for end

        dfs(0, 0, size-1, size-1, row, col, size);

        System.out.println(answer);

    }

    public static void dfs(int startRow, int startCol, int endRow, int endCol, int row, int col, int size) {
        if (size==1) return;

        int midRow = (startRow+endRow)/2;
        int midCol = (startCol+endCol)/2;

        int cnt = 0;

        if (row<=midRow) {
            endRow -= size/2;
        } else {
            startRow += size/2;
            cnt+=2;
        }

        if (col<=midCol) {
            endCol -= size/2;
        } else {
            startCol += size/2;
            cnt+=1;
        }

        answer += cnt * (size/2) * (size/2);

        dfs(startRow, startCol, endRow, endCol, row, col, size/2);

    }
}
