package src.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int[][] maps2 = {{1,0,1,1,1}, {1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        solution(maps2);
    }
    static boolean[][] isVisited;

    //어느 한 지점에서 1칸씩 이동하기 위한 배열
    static final int[] DIRECTIONS_ROW = {1, 0 , -1, 0};
    static final int[] DIRECTIONS_COL = {0, 1, 0, -1};

    public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        isVisited = new boolean[n][m];

        return bfs(0, 0, maps);
    }//solution() end

    //1칸씩 이동하면서 너비탐색
    public static int bfs(int firstRow, int firstColumn, int[][] maps) {
        //탐색할 포인트 좌표 저장할 queue
        Queue<int[]> queue = new LinkedList<>();
        int n = maps.length;
        int m = maps[0].length;

        //시작 지점에서 각 포인트까지 길이 저장할 distMaps
        int[][] distMaps = new int[n][m];

        /**
         * 시작지점 방문 체크 후
         * 해당 포인트까지의 거리 저장, queue에 해당 포인트 저장
         */
        isVisited[firstRow][firstColumn] = true;
        distMaps[firstRow][firstColumn] = 1;
        queue.add(new int[]{firstRow, firstColumn});

        while (!queue.isEmpty()) {
            //현재 탐색할 Point
            int[] nowPoint = queue.poll();
            int row = nowPoint[0];
            int column = nowPoint[1];
            int distance = distMaps[row][column];

            //동, 서, 남, 북으로 1칸씩 이동할 수 있는지 체크
            //이동할 수 있으면 방문 체크, queue에 add, distMaps에 이동한 위치까지의 거리 갱신
            for (int i = 0; i < 4; i++) {
                int newRow = row + DIRECTIONS_ROW[i];
                int newColumn = column + DIRECTIONS_COL[i];

                //맵을 벗어나지 않은 위치고, 방문하지 않았고, 벽이 아니라면 이동 가능!
                if (newRow<n && newRow>=0
                        && newColumn<m && newColumn>=0
                        && !isVisited[newRow][newColumn]
                        && maps[newRow][newColumn]==1) {
                    isVisited[newRow][newColumn] = true;
                    //현재 탐색 point에서 한 칸 이동했으므로 distance+1
                    distMaps[newRow][newColumn] = distance+1;
                    queue.add(new int[]{newRow, newColumn});
                }//if end
            }//for end
        }//while end


        /**
         * 최종 위치의 거리 값이 0이면 도착하지 못하는 경우이므로 -1 리턴
         */
        return (distMaps[n-1][m-1]==0)? -1 : distMaps[n-1][m-1];
    }//bfs() end
}
