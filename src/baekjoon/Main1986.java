package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1986 {
    static char[][] board;
    static boolean[][] isDangerous;
    static char[] CHESS_PIECES = {'Q', 'K', 'P'};

    static final int[] DIRECTIONS_FOR_QUEEN = {0, -1, 1};
    static final int[] DIRECTIONS_FOR_NIGHT1 = {-2, 2};
    static final int[] DIRECTIONS_FOR_NIGHT2 = {-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int rowLength = Integer.parseInt(st.nextToken());
        int colLength = Integer.parseInt(st.nextToken());

        board = new char[rowLength][colLength];
        isDangerous = new boolean[rowLength][colLength];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int cnt = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int row = Integer.parseInt(st.nextToken())-1;
                int col = Integer.parseInt(st.nextToken())-1;
                board[row][col] = CHESS_PIECES[i];
                isDangerous[row][col] = true;
            }//while end
        }//for end

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (board[i][j]==CHESS_PIECES[0] || board[i][j]==CHESS_PIECES[1]) {
                    checkBoard(i, j, rowLength, colLength, board[i][j]);
                }
            }//for end
        }//for end

        int answer = 0;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (!isDangerous[i][j]) {
                    answer++;
                }
            }//for end
        }//for end

        System.out.println(answer);
    }

    public static void checkBoard(int row, int col, int rowLength, int colLength, char piece) {
        if (piece=='Q') {
            //Queen
            //8방향으로 이동하면서 지나간 곳 isVisited[][]에 true로
            //board를 벗어나거나 board[][]값이 존재하면 그 방향은 stop
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!(i==0 && j==0)) {
                        int tempRow = row + DIRECTIONS_FOR_QUEEN[i];
                        int tempCol = col + DIRECTIONS_FOR_QUEEN[j];
                        while ((tempRow >= 0 && tempRow < rowLength)
                                && (tempCol >= 0 && tempCol< colLength) && board[tempRow][tempCol] == '\u0000') {
                            isDangerous[tempRow][tempCol] = true;

                            tempRow += DIRECTIONS_FOR_QUEEN[i];
                            tempCol += DIRECTIONS_FOR_QUEEN[j];
                        }//while end
                    }//if end
                }//for end
            }//for end
        } else {
            //Knight
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    int tempRow = row;
                    int tempCol = col;

                    tempRow += DIRECTIONS_FOR_NIGHT1[i];
                    tempCol += DIRECTIONS_FOR_NIGHT2[j];

                    if ((tempRow >= 0 && tempRow < rowLength)
                            && (tempCol >= 0 && tempCol< colLength)) {
                        isDangerous[tempRow][tempCol] = true;
                    }
                }//for end
            }//for end

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    int tempRow = row;
                    int tempCol = col;

                    tempRow += DIRECTIONS_FOR_NIGHT2[i];
                    tempCol += DIRECTIONS_FOR_NIGHT1[j];

                    if ((tempRow >= 0 && tempRow < rowLength)
                            && (tempCol >= 0 && tempCol< colLength)) {
                        isDangerous[tempRow][tempCol] = true;
                    }
                }//for end
            }//for end
        }
    }
}
