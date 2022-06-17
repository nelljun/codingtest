package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14503 {
    static boolean[][] isVisited;
    static int[][] board;
    static int row, col;
    static int cnt;

    //북 동 남 서 순서
    static final int[] DIRECTIONS_ROW = {-1, 0, 1, 0};
    static final int[] DIRECTIONS_COL = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine() , " ");

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine() , " ");

        int startRow = Integer.parseInt(st.nextToken());
        int startCol = Integer.parseInt(st.nextToken());
        int startDirection = Integer.parseInt(st.nextToken());

        board = new int[row][col];
        isVisited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(bf.readLine() , " ");
            for (int j = 0; j < col; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }//for end
        }//for end

        //출발 장소 count
        cnt++;
        isVisited[startRow][startCol] = true;
        dfs(startRow, startCol, startDirection);

        System.out.println(cnt);
    }

    public static void dfs(int nowRow, int nowCol, int nowDirection) {
        //빈 칸 0, 벽 1

        //왼쪽으로 회전
        int i = 1;
        for (; i <= 4; i++) {
            //새로운 방향
            int newDirection = (nowDirection-i<0)? nowDirection-i+4 : nowDirection-i;
            //새로운 방향으로 한 칸 이동
            int newRow = nowRow + DIRECTIONS_ROW[newDirection];
            int newCol = nowCol + DIRECTIONS_COL[newDirection];

            //만일 새로 이동한 칸으로 진행할 수 있다면 이동!(방문 여부 true, 개수+1, 새로 이동한 칸에서 재귀 호출)
            if ((newRow>0 && newRow<row-1)
                    && (newCol>0 && newCol<col-1)
                    && board[newRow][newCol] == 0
                    && !isVisited[newRow][newCol]) {
                cnt++;
                isVisited[newRow][newCol] = true;
                dfs(newRow, newCol, newDirection);
                //현재 위치에서 어느 한 방향으로 이동했다면 더 이상 현재 위치에서는 진행하지 않으므로 break
                break;
            }
        }//for end

        //모든 방향으로 더 이상 나갈 수 없을 때
        if (i==5) {
            //현재 방향의 반대 방향
            int oppoDirection = (nowDirection+2>3)? nowDirection-2 : nowDirection+2;
            //반대 방향으로 한 칸 이동
            int newRow = nowRow + DIRECTIONS_ROW[oppoDirection];
            int newCol = nowCol + DIRECTIONS_COL[oppoDirection];

            //반대 방향으로 한 칸이 빈 칸이라면 이동!
            if ((newRow>0 && newRow<row-1)
                    && (newCol>0 && newCol<col-1)
                    && board[newRow][newCol] == 0) {
                dfs(newRow, newCol, nowDirection);
            }//if end
        }//if end

    }//dfs() end
}
