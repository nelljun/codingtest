package src.programmers;

import java.util.Arrays;

public class 구명보트 {
	
	public static void main(String[] args) {
		int[] people = {40,40,40};
		int limit = 80;
		
		solution(people, limit);
	}//main() end
	
	public static void solution(int[] people, int limit) {
		
		Arrays.sort(people);
		//짝의 수
		int count = 0;
		//최대한 무게 차이가 많이 나는 사람끼리 짝해야 최소값
		int index = people.length;
		//짝 지어진 (무거운)사람의 index
		//다음 cycle 때 index-1부터 탐색
		
		for(int n=0; n<index; n++) {
			for(int i=index-1; i>n; i--) {
				if((people[n]+people[i])<=limit) {
					index = i;
					count++;
					break;
				}
			}//for end
			//가장 가벼운 사람과 짝없는 경우 break;
			if(index==people.length) break;
		}//for end
		
		System.out.println(people.length-count);
	}//solution() end
}
