package src.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
	
	int time = 0;
	int totalTruckWeightOnBridge = 0;
	int qtyOfTruckOnBridge = 0;
	int qtyOfTruckOffBridge = 0;
	
	public class Truck {
		int weight;
		int leftBridgeLength;
		
		Truck(int weight, int bridgeLength) {
			this.weight= weight;
			this.leftBridgeLength = bridgeLength;
		}
		
		public void onBridge() {
			totalTruckWeightOnBridge += this.weight;
			qtyOfTruckOnBridge++;
		}//enterBridge() end
		
		public int runBridge() {
			return --leftBridgeLength;
		}
		
		public void offBridge() {
			totalTruckWeightOnBridge -= this.weight;
			qtyOfTruckOnBridge--;
			qtyOfTruckOffBridge++;
		}//exitBridge() end
	}
	
	public class Bridge {
		int bridgeLength;
		int weight;
		Queue<Truck> trucks = new LinkedList<>();
		
		Bridge(int bridgeLength, int weight) {
			this.bridgeLength = bridgeLength;
			this.weight = weight;
		}
	}


	public int solution(int bridgeLength, int weight, int[] truckWeights) {
		
		Bridge bridge = new Bridge(bridgeLength, weight);
		
		Truck truck = new Truck(truckWeights[0], bridgeLength);
		
		bridge.trucks.add(truck);
		truck.onBridge();
		time++;
		
		
		return time;
    }//solution() end
	
	
}
