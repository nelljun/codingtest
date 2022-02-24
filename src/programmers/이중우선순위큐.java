package src.programmers;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이중우선순위큐 {
	public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        
        StringTokenizer tokenizer = null;
        
        //최솟값, 최댓값 둘 다 필요하므로 우선순위 큐 2개 생성
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        
        for(String operation : operations) {
        	tokenizer = new StringTokenizer(operation);
        	if(tokenizer.nextToken().equals("I")) {
        		//숫자 삽입
        		int num = Integer.parseInt(tokenizer.nextToken());
        		maxPQ.add(num);
        		minPQ.add(num);
        	} else {
        		//숫자 삭제
        		if(!maxPQ.isEmpty()) {
	        		if(tokenizer.nextToken().equals("1")) {
	        			//최댓값 삭제
	        			int max = maxPQ.poll();
	        			minPQ.remove(max);
	        		} else {
	        			//최솟값 삭제
	        			int min = minPQ.poll();
	        			maxPQ.remove(min);
	        		}//if~else end
        		}//if end
        	}//if~else end
        }//for end
        
        if(!maxPQ.isEmpty()) {
        	answer[0] = maxPQ.peek();
        	answer[1] = minPQ.peek();
        }
        
        return answer;
    }
}
