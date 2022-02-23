package src.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ��ɰ��� {
	
//	public static void main(String[] args) {
//		int[] progresses = {99, 90, 99, 99, 80, 99};
//		int[] speeds = {1, 1, 1, 1, 1, 1};
//		int[] result = solution(progresses, speeds);
//		for(int i : result) {
//			System.out.println(i);
//		}
//	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
		
		//�۾� ������ 100�̵Ǵ� �ð��� queue�� ���� (���� ������ �۾��� ���� ������ �Ǿ�� �ϴϱ�! FIFO)
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
        
        //����� ���� list
        //��� ��Ұ� ������ ���� �迭�� �ƴ� list�� ����
        List<Integer> list = new ArrayList<Integer>();
        
        //�� �� �� poll����, 
        //�� �Ʒ����� peek�ؼ� �� �� ������ �۰ų� ���ٸ�, �ش� �۾��� ������ ���� �̹�
        //�۾��� �Ϸ�� ���̹Ƿ� �ش� �۾��� ���� ������ �����ϴ�.
        //�׷��� poll���ش�.
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
