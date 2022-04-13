package src.programmers;

import java.util.*;

public class 야근지수 {
    public static void main(String[] args) {
        int[] works1 = {4,3,3};
        solution(4, works1);
    }

    public static long solution(int n, int[] works) {
        int length = works.length;
        long answer = 0L;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < length; i++) {
            pq.add(works[i]);
        }//for end

        for (int i = 0; i < n; i++) {
            if (pq.peek()==0) return 0;
            int max = pq.poll();
            pq.add(max-1);
        }//for end

        while (!pq.isEmpty()) {
            int num = pq.poll();
            answer += num*num;
        }//while end

        return answer;
    }//solution() end
}
