package src.programmers;

import java.util.Arrays;

public class HIndex {

	public static void main(String[] args) {
		int[] citations = {3,0,6,1,5};
		System.out.println(solution(citations));
	}//main() end
	
	public static int solution(int[] citations) {
		int length = citations.length;
		//H-Index가 될 수 있는 최대값
		//논문 수(citations.length)와 최대 논문 인용 수의 min보다 H-Index값이 커질 수 없다.
		Arrays.sort(citations);
		int maxH = Math.min(length, citations[length-1]);
		
		//h와 요소 값 비교
		int i = 0;
		int h = 0;
		for(h=maxH; h>=0; h--) {
			
			for(i=length-1; i>=0; i--) {
				if(h>citations[i]) break;
			}//for end
			
			//(length-1)-i : h번 이상 인용된 논문 수
			if(length-1-i>=h) break;
		}//for end
		
		return h;
	}//solution() end
	
	public static int solution2(int[] citations) {
		int answer = 0;
		int length = citations.length;
		
		Arrays.sort(citations);
		
		for(int i=0; i<length; i++) {
			int h = length-i;
			
			if(citations[i]>=h) {
				answer = h;
			}//if end
		}//for end
		
		return answer;
	}//solution() end
}
