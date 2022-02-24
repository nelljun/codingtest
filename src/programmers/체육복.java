package src.programmers;

import java.util.Arrays;

public class 체육복 {

	public static void main(String[] args) {
		
		int n = 5;
		int[] lost = {2,4};
		int[] reserve = {3};
		
		
		solution(n, lost, reserve);
		
	}//main() end
	
	public static void solution(int n, int[] lost, int[] reserve) {
		
		Arrays.sort(lost);
		Arrays.sort(reserve);
		
		int count = 0;
		boolean flag = false;
		boolean[] isUsed = new boolean[reserve.length];
		
		for(int i=0; i<lost.length; i++) {
			for(int j=0; j<reserve.length; j++) {
				if(lost[i]==reserve[j]) {
					lost[i] = reserve[j] = 0;
					count++;
				}//if end
			}//for end
		}//for end
		
		for(int i=0; i<lost.length; i++) {
			if(lost[i]==0) continue;
				//flag 초기화	
				flag = false;
				for(int j=0; j<reserve.length; j++) {
					if(reserve[j]==0) continue;
					if(!isUsed[j]) {
						switch(lost[i]-reserve[j]) {
						case 1: count++;
								flag = true;
								isUsed[j] = true;
								break;
						case -1: count++;
								 flag = true;
								 isUsed[j] = true;
								 break;
						}//switch case end
					}//if end
					if(flag) break;
				}//for end
		}//for end
		System.out.println("count : "+count);
		System.out.println(n-lost.length+count);
	}//solution() end
}
