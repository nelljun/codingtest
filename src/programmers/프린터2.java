package src.programmers;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class ������2 {
	public static void main(String[] args) {
		int[] priorities = {2,1,3,2};
		int location = 0;
		int result = solution(priorities, location);
		System.out.println(result);
	}
	
	public static int solution(int[] priorities, int location) {
		
		int answer = 0;
		
		//Max heap
		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		//�߿䵵 ���� pq�� add
		for(int priority : priorities) {
			pq.add(priority);
		}//for end
		
		//pq�� �������� �ݺ�
		while(!pq.isEmpty()) {
			//pq���� ������ ���� ���� ��� Ž��
			for(int i=0; i<priorities.length; i++) {
				//���� ���ٸ� ���!
				if(pq.peek()==priorities[i]) {
					pq.poll();
					answer++;
					//���� ����, ��ġ�� ���ٸ� answer ��ȯ
					if(i == location) return answer;
				}
			}//for end
		}//while end
		
		return answer;
	}
}
