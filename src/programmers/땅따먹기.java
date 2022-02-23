package src.programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class ¶¥µû¸Ô±â {

	static PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
	static boolean[] isUsed = new boolean[4];
	
	public static void main(String[] args) {
		int[][] land = {{1,2,3,5}, {5,6,7,8}, {4,3,2,1}};
		solution2(land);
	}//main() end
	
	public static void solution1(int[][] land) {
		dfs(0, 0, land);
		System.out.println(pq.poll());
	}//solution() end
	
	public static void dfs(int row, int sum, int[][] land) {
		if(row==land.length) {
			pq.add(sum);
			return;
		}//if end
		
		for(int i=0; i<4; i++) {
			if(!isUsed[i]) {
				sum += land[row][i];
				isUsed[i] = true;
				dfs(row+1, sum, land);
				sum -= land[row][i];
				isUsed[i] = false;
			}//if end
		}//for end
	}//dfs() end
	
	public static void solution2(int[][] land) {
		int length = land.length;
		
		for(int i=1; i<length; i++) {
			land[i][0] += max(land[i-1][1], land[i-1][2], land[i-1][3]); 
			land[i][1] += max(land[i-1][0], land[i-1][2], land[i-1][3]); 
			land[i][2] += max(land[i-1][0], land[i-1][1], land[i-1][3]); 
			land[i][3] += max(land[i-1][0], land[i-1][1], land[i-1][2]); 
		}//for end
		
		System.out.println(max(land[length-1]));
	}//solution2() end
	
	public static int max(int num1, int num2, int num3) {
		return Math.max(num1, Math.max(num2, num3));
	}//max() end
	
	public static int max(int[] numArr) {
		int max=0;
		for(int num : numArr) {
			if(max<num) max = num;
		}
		return max;
	}//max() end
	
}
