package src.programmers;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프린터2 {
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
		
		//중요도 값을 pq에 add
		for(int priority : priorities) {
			pq.add(priority);
		}//for end
		
		//pq가 빌때까지 반복
		while(!pq.isEmpty()) {
			//pq에서 나오는 값과 같은 경우 탐색
			for(int i=0; i<priorities.length; i++) {
				//값이 같다면 출력!
				if(pq.peek()==priorities[i]) {
					pq.poll();
					answer++;
					//값이 같고, 위치도 같다면 answer 반환
					if(i == location) return answer;
				}
			}//for end
		}//while end
		
		return answer;
	}
}
