package src.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
	
//	public static void main(String[] args) {
//		int[] progresses = {99, 90, 99, 99, 80, 99};
//		int[] speeds = {1, 1, 1, 1, 1, 1};
//		int[] result = solution(progresses, speeds);
//		for(int i : result) {
//			System.out.println(i);
//		}
//	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
		
		//작업 진도가 100이되는 시간을 queue에 저장 (먼저 시작한 작업이 먼저 배포가 되어야 하니까! FIFO)
        Queue<Integer> queue = new LinkedList<>();
        
        int day = 0;
        for(int i=0; i<progresses.length; i++) {
        	while(progresses[i]<100) {
        		progresses[i] += speeds[i];
        		day++;
        	}//while end
        	queue.add(day);
        	day = 0;
        }//for end
        
        int num = 0;
        int top = 0;
        
        //결과값 담을 list
        //몇개의 요소가 나올지 몰라서 배열이 아닌 list로 선언
        List<Integer> list = new ArrayList<Integer>();
        
        //맨 위 값 poll나서, 
        //그 아래값을 peek해서 맨 위 값보다 작거나 같다면, 해당 작업이 끝나기 전에 이미
        //작업이 완료된 것이므로 해당 작업과 같이 배포가 가능하다.
        //그래서 poll해준다.
        while(!queue.isEmpty()) {
	        top = queue.poll();
	        num++;
	        while((!queue.isEmpty())&&(queue.peek()<=top)) {
	        	queue.poll();
	        	num++;
	        }//while end
	        
	        list.add(num);
	        num = 0;
        }//while end
        
        int listSize = list.size();
        int[] answer = new int[listSize];
        
        for(int i=0; i<listSize; i++) {
        	answer[i] = list.get(i);
        }//for end
        
        return answer;
        
    }
	
}
