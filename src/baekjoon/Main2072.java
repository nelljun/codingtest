package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2072 {
    static final int SIZE = 19;
    static char[][] board = new char[SIZE][SIZE];
    static final int[] DIRECTIONS = {-1, 0, 1};
    static int[] successiveStoneCnt = new int[8];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int totalCnt = Integer.parseInt(bf.readLine());

        StringTokenizer st = null;

        int i = 1;
        boolean isGameOver = false;

        for (; i <= totalCnt; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int row = Integer.parseInt(st.nextToken())-1;
            int col = Integer.parseInt(st.nextToken())-1;

            board[row][col] = (i%2==1)? 'B':'W';

            if (isFinished(row, col, board[row][col])) {
                isGameOver = true;
                break;
            }
        }//for end

        System.out.println((isGameOver)? i : -1);
    }

    public static boolean isFinished(int row, int col, char stone) {
        //현재 위치를 포함해서 정확히 다섯 개의 같은 색의 돌이 연속하는지 8방향으로 확인 (같은 선상의 2방향은 합친다.)

        Arrays.fill(successiveStoneCnt, 0);
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i==1 && j==1)) {
                    int cnt = 0;
                    int tempRow = row + DIRECTIONS[i];
                    int tempCol = col + DIRECTIONS[j];
                    while ((tempRow>=0 && tempRow<SIZE)
                            && (tempCol>=0 && tempCol<SIZE)
                            && board[tempRow][tempCol]==stone) {
                        cnt++;
                        tempRow += DIRECTIONS[i];
                        tempCol += DIRECTIONS[j];
                    }//while end
                    successiveStoneCnt[index++] = cnt;
                }
            }//for end
        }//for end

        for (int i = 0; i < 4; i++) {
            if (successiveStoneCnt[i] + successiveStoneCnt[7-i] == 4) {
                return true;
            }
        }//for end

        return false;
    }
}
