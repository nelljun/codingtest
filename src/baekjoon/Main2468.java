package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2468 {
    //지역 높이 board
    static int[][] board;

    //각 지역의 높이값 저장할 set
    static Set<Integer> set = new HashSet<>();

    //각 bfs 탐색마다 false로 초기화 후, 방문 여부 체크할 배열
    static boolean[][] isVisited;

    //board 사이즈
    static int N;

    //row 방향 이동 배열
    static final int[] DIRECTIONS_ROW = {-1, 0, 1 ,0};

    //col 방향 이동 배열
    static final int[] DIRECTIONS_COL = {0, 1, 0, -1};

    //각 지점에 해당하는 Point 클래스
    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        board = new int[N][N];
        isVisited = new boolean[N][N];

        //각 지역의 높이 값을 board에 채우면서 set에도 저장
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                board[i][j] = height;
                set.add(height);
            }//for end
        }//for end

        //모든 높이가 같은 경우 초기값 1
        int max = 1;

        for (int height : set) {
            //isVisited 배열을 false로 초기화
            for (int i = 0; i < N; i++) {
                Arrays.fill(isVisited[i], false);
            }//for end

            //height 높이만큼 비가 왔을 때 안전 영역 갯수 탐색
            int num = getNumOfSafeArea(height);

            //최대 안전 영역 갯수
            max = Math.max(max, num);
        }//for end

        System.out.println(max);
    }

    //height만큼 비가 왔을 때 안전 영역 갯수 찾는 메서드
    public static int getNumOfSafeArea(int height) {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //board[0][0]부터 탐색하면서
                //높이가 height보다 크고 방문한 적 없는 지역이면 cnt를 +1하고
                //해당 지역을 시작으로 bfs 탐색한다.
                if (board[i][j]>height && !isVisited[i][j]) {
                    cnt++;
                    bfs(i, j, height);
                }
            }//for end
        }//for end

        return cnt;
    }

    public static void bfs(int startRow, int startCol, int height) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(startRow, startCol));
        isVisited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowRow = now.row;
            int nowCol = now.col;

            for (int i = 0; i < 4; i++) {
                //각 이동방향으로 이동한 후 새로운 좌표
                int newRow = nowRow + DIRECTIONS_ROW[i];
                int newCol = nowCol + DIRECTIONS_COL[i];

                //범위를 벗어나지 않고, height보다 새로운 지점의 높이가 높고, 방문한 적 없는 경우
                if ((newRow>=0 && newRow<N)
                        && (newCol>=0 && newCol<N)
                        && board[newRow][newCol]>height
                        && !isVisited[newRow][newCol]) {

                    queue.add(new Point(newRow, newCol));
                    isVisited[newRow][newCol] = true;
                }//if end
            }//for end
        }//while end
    }

}
