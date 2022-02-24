package src.programmers;

import java.util.PriorityQueue;

public class 더맵게 {
	public int solution(int[] scoville, int K) {
        int answer = 0;
        //배열 값 중에서 첫번째, 두번째 작은 수를 찾아야 하므로
        //우선순위 큐 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num : scoville) {
        	pq.add(num);
        }
        
        while(pq.size()>1 && pq.peek()<K) {
	        int minimum = pq.poll();
	        pq.add(minimum + pq.poll()*2);
	        answer++;
        }
        if(pq.peek()<K) answer = -1;
        
        return answer;
    }
}
