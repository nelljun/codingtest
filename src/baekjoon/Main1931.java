package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1931 {
    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //끝나는 시간이 빠른 순서대로 poll()할 수 있게 회의 객체 저장
        //만일, 끝나는 시간이 같다면 시작시간이 빠른 순서대로
        PriorityQueue<Meeting> pq = new PriorityQueue<>( new Comparator<Meeting>() {
            @Override
            public int compare(Meeting m1, Meeting m2) {
                if (m1.end<m2.end) {
                    return -1;
                } else if (m1.end>m2.end) {
                    return 1;
                } else {
                    return Integer.compare(m1.start, m2.start);
                }
            }
        });

        int cnt = Integer.parseInt(bf.readLine());

        StringTokenizer st;
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            pq.add(new Meeting(Integer.parseInt(st.nextToken()),
                                 Integer.parseInt(st.nextToken())));
        }//for end

        int time = 0;
        int answer = 0;

        while (!pq.isEmpty()) {
            Meeting now = pq.poll();

            //현재 시간보다 시작 시간이 뒤에 있어야 진행이 가능하다
            if (now.start < time) continue;

            //미팅 진행 (현재 시간을 미팅 끝나는 시간으로 세팅)
            time = now.end;
            answer++;
        }

        System.out.println(answer);
    }
}
