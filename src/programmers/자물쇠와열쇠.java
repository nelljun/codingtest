package src.programmers;

import java.util.ArrayList;

public class 자물쇠와열쇠 {
    public static void main(String[] args) {

    }

    public static boolean solution(int[][] key, int[][] lock) {
        /**
         * 1. 열쇠 돌기 = 자물쇠 홈 (돌기끼리 x)
         * 2. 자물쇠 모든 홈을 채워야 한다.
         * 3. 자물쇠 벗어난 영역의 열쇠 부분은 영향x
         * 4. 열쇠는 회전, 이동 가능
         *
         * 열쇠 사이즈 <= 자물쇠 사이즈
         *
         * 0 : 홈, 1 : 돌기 ->
         */

        int keySize = key.length;
        int lockSize = lock.length;

        int boardSize = lockSize * 3;

        for (int x = lockSize-keySize; x < 2 * lockSize; x++) {
            for (int y = lockSize-keySize; y < 2 * lockSize; y++) {
                for (int r = 0; r < 4; r++) {
                    int[][] board = new int[boardSize][boardSize];
                    for (int k = 0; k < lockSize; k++) {
                        for (int l = 0; l < lockSize; l++) {
                            if (lock[k][l]==1) {
                                board[k+lockSize][l+lockSize] = 1;
                            }
                        }//for end
                    }//for end

                    match(board, key, x, y, r);
                    if (check(board)) return true;

                }//for end
            }//for end
        }//for end

        return false;
    }//solution() end

    public static void match(int[][] board, int[][] key, int x, int y, int r) {
        int keySize = key.length;

        for (int i = 0; i < keySize; i++) {
            for (int j = 0; j < keySize; j++) {
                switch (r) {
                    case 0 -> board[x + i][y + j] += key[i][j];
                    case 1 -> board[x + i][y + j] += key[j][keySize - 1 - i];
                    case 2 -> board[x + i][y + j] += key[keySize - 1 - i][keySize - 1 - j];
                    case 3 -> board[x + i][y + j] += key[keySize - 1 - j][i];
                }
            }//for end
        }//for end
    }

    public static boolean check(int[][] board) {
        int lockSize = board.length / 3;

        for (int i = lockSize; i < 2*lockSize; i++) {
            for (int j = lockSize; j < 2*lockSize; j++) {
                if (board[i][j] != 1) return false;
            }//for end
        }//for end

        return true;
    }
}
