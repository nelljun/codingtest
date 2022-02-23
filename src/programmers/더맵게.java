package src.programmers;

import java.util.PriorityQueue;

public class ���ʰ� {
	public int solution(int[] scoville, int K) {
        int answer = 0;
        //�迭 �� �߿��� ù��°, �ι�° ���� ���� ã�ƾ� �ϹǷ�
        //�켱���� ť ���
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
