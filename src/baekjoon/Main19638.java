package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main19638 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine() , " ");

        int total = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int hitCnt = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

        for (int i = 0; i < total; i++) {
            pq.add(Integer.parseInt(bf.readLine()));
        }//for end

        int cnt = 0;
        while (cnt<hitCnt) {
            Integer max = pq.poll();

            if (max<target) {
                break;
            } else {
                max /= (max==1)? 1 : 2;
                pq.add(max);
            }//if~else end

            cnt++;
        }//while end

        StringBuilder sb = new StringBuilder();

        if (cnt<hitCnt) {
            sb.append("YES").append("\n").append(cnt);
        } else {
            Integer max = pq.poll();

            if (max<target) {
                sb.append("YES").append("\n").append(cnt);
            } else {
                sb.append("NO").append("\n").append(max);
            }
        }

        System.out.println(sb);
    }
}
