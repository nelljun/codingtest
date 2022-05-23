package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1697 {
    static int[] arr = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());


        System.out.println(bfs(from, to));
    }

    public static int bfs(int from, int to) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(from);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now==to) {
                return arr[now];
            }

            if (now-1>=0 && arr[now-1]==0) {
                arr[now-1] = arr[now]+1;
                queue.add(now-1);
            }

            if (now+1<=100000 && arr[now+1]==0) {
                arr[now+1] = arr[now]+1;
                queue.add(now+1);
            }

            if (2*now<=100000 && arr[2*now]==0) {
                arr[2*now] = arr[now]+1;
                queue.add(2*now);
            }
        }//while end

        return -1;
    }//bfs() end

}
