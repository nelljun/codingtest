package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1780 {
    static int[][] board;
    static int[] paperCnt = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(bf.readLine());

        board = new int[size][size];

        StringTokenizer st;

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < size; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }//for end
        }//for end

        dfs(0, 0, size);

        for (int i = 0; i < paperCnt.length; i++) {
            System.out.println(paperCnt[i]);
        }//for end
    }

    public static void dfs(int startRow, int startCol, int size) {
        boolean isAllSame = true;
        int criteria = board[startRow][startCol];

        for (int i = startRow+1; i < startRow+size; i++) {
            for (int j = startCol+1; j < startCol+size; j++) {
                if (board[i][j]!=criteria) {
                    isAllSame = false;
                    break;
                }
            }//for end
            if (!isAllSame) break;
        }//for end

        if (isAllSame) {
            //모두 같은 경우
            paperCnt[board[startRow][startCol]+1]++;
            return;
        } else {
            //하나라도 다른 경우
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    dfs(startRow + i*size/3, startCol + j*size/3, size/3);
                }//for end
            }//for end;
        }
    }
}
