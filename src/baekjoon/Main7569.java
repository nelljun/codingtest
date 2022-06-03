package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7569 {
    //35분
    static class Tomato {
        int vertical;
        int horizontal;
        int height;

        public Tomato(int vertical, int horizontal, int height) {
            this.vertical = vertical;
            this.horizontal = horizontal;
            this.height = height;
        }
    }

    static final int[] DIRECTIONS_VERTICAL = {1, -1, 0, 0, 0, 0};
    static final int[] DIRECTIONS_HORIZONTAL = {0, 0, 1, -1,0, 0};
    static final int[] DIRECTIONS_HEIGHT = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int vertical = Integer.parseInt(st.nextToken());
        int horizontal = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int[][][] warehouse = new int[height][horizontal][vertical];
        Queue<Tomato> queue = new LinkedList<>();
        //현재 익은 토마토 개수
        int nowCnt = 0;
        //전체 토마토 개수
        int totalCnt = 0;

        for (int h = 0; h < height; h++) {
            for (int z = 0; z < horizontal; z++) {
                st = new StringTokenizer(bf.readLine(), " ");
                for (int v = 0; v < vertical; v++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    warehouse[h][z][v] = tomato;
                    if (tomato == 1) {
                        queue.add(new Tomato(v, z, h));
                        nowCnt++;
                        totalCnt++;
                    } else if(tomato == 0) {
                        totalCnt++;
                    }
                }//for end
            }//for end
        }//for end

        System.out.println(bfs(warehouse, queue, nowCnt, totalCnt));

    }

    public static int bfs(int[][][] warehouse, Queue<Tomato> queue, int nowCnt, int totalCnt) {
        int cnt = 0;

        while (!queue.isEmpty()) {
            Tomato now = queue.poll();
            int dist = warehouse[now.height][now.horizontal][now.vertical];
            cnt = dist;

            for (int i = 0; i < 6; i++) {
                int newVertical = now.vertical+DIRECTIONS_VERTICAL[i];
                int newHorizontal = now.horizontal+DIRECTIONS_HORIZONTAL[i];
                int newHeight = now.height+DIRECTIONS_HEIGHT[i];


                if ((newVertical>=0 && newVertical<warehouse[0][0].length)
                        && (newHorizontal>=0 && newHorizontal<warehouse[0].length)
                        && (newHeight>=0 && newHeight<warehouse.length)
                        && warehouse[newHeight][newHorizontal][newVertical] == 0) {
                    queue.add(new Tomato(newVertical, newHorizontal, newHeight));
                    warehouse[newHeight][newHorizontal][newVertical] = dist+1;
                    nowCnt++;
                }
            }//for end
        }//while end

        return (nowCnt==totalCnt)? cnt-1 : -1;
    }//bfs() end
}
