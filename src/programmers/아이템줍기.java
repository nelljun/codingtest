package src.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 아이템줍기 {

    public static void main(String[] args) {

    }

    static final int[] DIRECTIONS_X = {1, 0, -1, 0};
    static final int[] DIRECTIONS_Y = {0, 1, 0, -1};
    //가장자리를 따라 캐릭터로부터의 거리 기록할 board
    static int[][] board;

    public static int solution(int[][] rectangle,
                                int characterX,
                                int characterY,
                                int itemX,
                                int itemY) {

        //1칸 단위의 ㄷ자 모양 때문에 좌표를 2배로 키운다.
        board = new int[102][102];

        /**
         * 최종 가장자리만 -1로 채운다.
         */
        //일단 가장자리를 포함한 직사각형 내부를 -1로 채운다.
        for (int[] rect : rectangle) {
            int xMin = rect[0] * 2;
            int xMax = rect[2] * 2;
            int yMin = rect[1] * 2;
            int yMax = rect[3] * 2;

            for (int i = xMin; i <= xMax; i++) {
                for (int j = yMin; j <= yMax; j++) {
                    board[i][j] = -1;
                }//for end
            }//for end
        }//for end
        //가장자리를 제외한 내부만 0으로 채운다.
        for (int[] rect : rectangle) {
            int xMin = rect[0] * 2;
            int xMax = rect[2] * 2;
            int yMin = rect[1] * 2;
            int yMax = rect[3] * 2;

            for (int i = xMin+1; i < xMax; i++) {
                for (int j = yMin+1; j < yMax; j++) {
                    board[i][j] = 0;
                }//for end
            }//for end
        }//for end

        bfs(characterX, characterY, itemX, itemY);

        //좌표를 2배 확장했으므로 최종 거리의 1/2
        return board[itemX*2][itemY*2] / 2;

    }//solution() end

    /**
     * 가장자리를 따라 캐릭터를
     * 아이템까지 1칸씩 이동시키면서 거리를 board에 기록한다.
     */
    public static void bfs(int characterX,
                           int characterY,
                           int itemX,
                           int itemY) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {characterX*2, characterY*2});
        board[characterX*2][characterY*2] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int distFromChar = board[nowX][nowY];

            //아이템에 도착하면 끝
            if (nowX==itemX*2 && nowY==itemY*2) {
                break;
            }

            //상, 하, 좌, 우 탐색하면서 가장자리를 따라 이동
            for (int i = 0; i < 4; i++) {
                int newX = nowX + DIRECTIONS_X[i];
                int newY = nowY + DIRECTIONS_Y[i];

                if (newX>=0 && newY>=0 && board[newX][newY]==-1) {
                    queue.add(new int[] {newX, newY, distFromChar+1});
                    //1칸 이동했으므로 거리 1 증가
                    board[newX][newY] = distFromChar+1;
                }
            }//for end
        }//while end
    }//solution() end
}
