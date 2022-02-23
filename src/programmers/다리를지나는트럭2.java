package src.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class �ٸ���������Ʈ��2 {
	
	public int solution(int bridgeLength, int weight, int[] truckWeights) {
		int time = 0;
		int sum = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        
        //���� 1. �ٸ� ����
        //���� 2. �ٸ� �� Ʈ�� ��
        
        for(int truckWeight : truckWeights) {
        	while(true) {
	        	if(bridge.isEmpty()) {
	        		//�ٸ��� �� ���
	        		bridge.add(truckWeight);
	        		sum += truckWeight;
	        		time++;
	        		break;
	        	} else if(bridge.size()==bridgeLength) {
	        		//�ٸ��� �� �� ���
        			sum -= bridge.poll();
	        	} else {
	        		if(sum + truckWeight > weight) {
	        			bridge.add(0);
	        			time++;
	        		} else {
	        			bridge.add(truckWeight);
	        			sum += truckWeight;
	        			time++;
	        			break;
	        		}//if~else end
	           	}//if~else end
        	}//while end
        	
        }//for end
        
        return time + bridgeLength;
        
    }
}
