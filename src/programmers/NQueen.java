package src.programmers;

public class NQueen {
    public static void main(String[] args) {

    }

    //행 check
    static int[] board;
    //열 check
    static boolean[] colCheck;
    //우상 대각선 check
    static boolean[] rightUpDiagonalCheck;
    //좌상 대각선 check
    static boolean[] leftUpDiagonalCheck;

    static int answer;

    public static int solution(int n) {
        board = new int[n];
        colCheck = new boolean[n];
        rightUpDiagonalCheck = new boolean[2*n-1];
        leftUpDiagonalCheck = new boolean[2*n-1];

        dfs(0, n);

        return answer;
    }//solution() end

    public static void dfs(int row, int n) {
        if (row==n) {
            answer++;
            return;
        }

        //row를 정하고, 점유되지 않은 col을 골랐을 때
        //해당 point가 속하는 좌상, 우상 대각선이 포함되지 않은 경우 check
        for (int col = 0; col < n; col++) {
            if (!colCheck[col] && !rightUpDiagonalCheck[row+col] && !leftUpDiagonalCheck[(n-1)-(row-col)]) {
                board[row] = col;
                colCheck[col] = true;
                rightUpDiagonalCheck[row+col] = true;
                leftUpDiagonalCheck[(n-1)-(row-col)] = true;
                dfs(row+1, n);
                colCheck[col] = false;
                rightUpDiagonalCheck[row+col] = false;
                leftUpDiagonalCheck[(n-1)-(row-col)] = false;
            }
        }//for end
    }
}
