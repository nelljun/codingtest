package src.programmers;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ���߿켱����ť {
	public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        
        StringTokenizer tokenizer = null;
        
        //�ּڰ�, �ִ� �� �� �ʿ��ϹǷ� �켱���� ť 2�� ����
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        
        for(String operation : operations) {
        	tokenizer = new StringTokenizer(operation);
        	if(tokenizer.nextToken().equals("I")) {
        		//���� ����
        		int num = Integer.parseInt(tokenizer.nextToken());
        		maxPQ.add(num);
        		minPQ.add(num);
        	} else {
        		//���� ����
        		if(!maxPQ.isEmpty()) {
	        		if(tokenizer.nextToken().equals("1")) {
	        			//�ִ� ����
	        			int max = maxPQ.poll();
	        			minPQ.remove(max);
	        		} else {
	        			//�ּڰ� ����
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
