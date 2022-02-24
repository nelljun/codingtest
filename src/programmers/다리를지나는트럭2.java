package src.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭2 {
	
	public int solution(int bridgeLength, int weight, int[] truckWeights) {
		int time = 0;
		int sum = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        
        //조건 1. 다리 무게
        //조건 2. 다리 위 트럭 수
        
        for(int truckWeight : truckWeights) {
        	while(true) {
	        	if(bridge.isEmpty()) {
	        		//다리가 빈 경우
	        		bridge.add(truckWeight);
	        		sum += truckWeight;
	        		time++;
	        		break;
	        	} else if(bridge.size()==bridgeLength) {
	        		//다리가 꽉 찬 경우
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
