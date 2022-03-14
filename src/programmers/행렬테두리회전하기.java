package src.programmers;

import java.util.*;

public class 행렬테두리회전하기 {

    public static void main(String[] args) {
        int[][] queries = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
        solution(3, 3, queries);
    }//main() end

    static int[][] board;
    static Queue<Integer> queue;

    public static void solution(int rows, int columns, int[][] queries) {

        board = new int[rows][columns];
        queue = new LinkedList<>();

        fillMatrix(rows, columns);

        //각 회전 당, 이동한 숫자들 중 최솟값 담을 배열
        int[] answer = new int[queries.length];

        for(int i=0; i<answer.length; i++) {
            answer[i] = rotate(queries[i]);
        }//for end

    }//solution() end

    //행렬 값 채우는 메소드
    public static void fillMatrix(int rows, int columns) {
        int n = 0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                board[i][j] = ++n;
            }
        }
    }

    //query 범위의 행렬 테두리 회전하고, 최솟값 리턴하는 메소드
    public static int rotate(int[] query) {
        //queue 비우기
        queue.clear();

        int x1 = query[0]-1;
        int y1 = query[1]-1;
        int x2 = query[2]-1;
        int y2 = query[3]-1;

        int min = board[x1][y1];

        queue.add(board[x1][y1]);

        //위 테두리
        for(int i=1; i<=y2-y1; i++) {
            min = Math.min(min, board[x1][y1+i]);
            queue.add(board[x1][y1+i]);
            board[x1][y1+i] = queue.poll();
        }//for end

        //오른쪽 테두리
        for(int i=1; i<=x2-x1; i++) {
            min = Math.min(min, board[x1+i][y2]);
            queue.add(board[x1+i][y2]);
            board[x1+i][y2] = queue.poll();
        }//for end

        //아래 테두리
        for(int i=1; i<=y2-y1; i++) {
            min = Math.min(min, board[x2][y2-i]);
            queue.add(board[x2][y2-i]);
            board[x2][y2-i] = queue.poll();
        }//for end

        //왼쪽 테두리
        for(int i=1; i<=x2-x1; i++) {
            min = Math.min(min, board[x2-i][y1]);
            queue.add(board[x2-i][y1]);
            board[x2-i][y1] = queue.poll();
        }//for

        return min;

    }

    //queue를 사용하지 않고 숫자 한 칸씩 이동 (끝나는 지점부터 고려)
    public static int rotate2(int[] query) {
        int x1 = query[0]-1;
        int y1 = query[1]-1;
        int x2 = query[2]-1;
        int y2 = query[3]-1;

        int min = board[x1][y1];
        int temp = board[x1][y1];

        //왼쪽 테두리
        for(int i=x1; i<x2; i++) {
            min = Math.min(min, board[i][y1]);
            board[i][y1] = board[i+1][y1];
        }//for end

        //아래 테두리
        for(int i=y1; i<y2; i++) {
            min = Math.min(min, board[x2][i]);
            board[x2][i] = board[x2][i+1];
        }//for end

        //오른쪽 테두리
        for(int i=x2; i>x1; i--) {
            min = Math.min(min, board[i][y2]);
            board[i][y2] = board[i-1][y2];
        }//for end

        //아래 테두리
        for(int i=y2; i>y1; i--) {
            min = Math.min(min, board[x1][i]);
            board[x1][i] = board[x1][i-1];
        }//for end

        board[x1][y1+1] = temp;

        return min;
    }//rotate2() end
}
