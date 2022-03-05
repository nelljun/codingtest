package src.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    public static void main(String[] args) {
        int[][] maps1 = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
        int[][] maps2 = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}};

        solution(maps1);
    }//main() end

    public static boolean[][] isVisited;

    public static int solution(int[][] maps) {
        isVisited = new boolean[maps.length][maps[0].length];

        dfs(0, 0, maps, 1);
        //갱신이 한번도 안되었으면 목적지 도착하지 못한 것이니 -1 리턴
        return (min==Integer.MAX_VALUE)? -1 : min;
    }//solution() end

    static int min = Integer.MAX_VALUE;

    public static void dfs(int y, int x, int[][] maps, int count) {

        isVisited[y][x] = true;

        if(y==maps.length-1 && x==maps[0].length-1) {
            //목적지 도착 -> 최솟값 갱신
            min = Math.min(min, count);
            return;
        }

        //right
        if(isOkToGo(y, x+1, maps)) {
            dfs(y, x+1, maps, count+1);
        }
        //down
        if(isOkToGo(y+1, x, maps)) {
            dfs(y+1, x, maps, count+1);
        }
        //left
        if(isOkToGo(y, x-1, maps)) {
            dfs(y, x-1, maps, count+1);
        }
        //up
        if(isOkToGo(y-1, x, maps)) {
            dfs(y-1, x, maps, count+1);
        }

        //모든 방향 try 후 현재 위치 false로 초기화
        isVisited[y][x] = false;
    }//dfs() end

    //이동 시 벽, 범위, 방문여부 확인하는 method
    public static boolean isOkToGo(int y, int x, int[][] maps) {
        return !(y > maps.length-1 || y<0
                || x > maps[0].length-1 || x<0
                || maps[y][x]==0
                || isVisited[y][x]);
    }//isOkToGo() end

    static int[] dy = {1, 0, -1, 0}, dx = {0, 1, 0, -1};

    //bfs 풀이
    public static int solution2(int[][] maps) {
        int rows = maps.length;
        int columns = maps[0].length;

        isVisited = new boolean[rows][columns];

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(0, 0, 1));
        isVisited[0][0] = true;

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            if(point.y==rows-1 && point.x==columns-1) return point.distance;

            for(int i=0; i<4; i++) {
                int ny = point.y + dy[i];
                int nx = point.x + dx[i];

                if(isOkToGo(ny, nx, maps)) {
                    isVisited[ny][nx] = true;
                    queue.add(new Point(ny, nx, point.distance+1));
                }
            }//for end
        }//while end

        return -1;

    }//solution2() end

    public static class Point {
        int y;
        int x;
        int distance;

        Point(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }
}
