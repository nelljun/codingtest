package src.programmers;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

	//만든 수 담을 Set (중복된 값 신경x)
	static Set<Integer> numSet = new HashSet<>();
	
	public static void main(String[] args) {
		String numbers = "1234";
		solution(numbers);
	}//main() end
	
	public static void combination(int level, int length, String[] numStrArr) {
		
	}//combination() end
	
	public static void solution(String numbers) {
		int length = numbers.length();
		String[] numStrArr = new String[length];
		for(int i=0; i<length; i++) {
			numStrArr[i] = numbers.substring(i, i+1);
		}
		
		
		
	}//solution() end
	
	public static boolean isPrime(int num) {
		boolean result = true;
		
		int sqr = (int)Math.sqrt(num);
		
		for(int i=2; i<=sqr; i++) {
			if(num%i == 0) {
				result = false;
				break;
			}//if end
		}//for end
		
		return result;
	}//isPrime() end
	
}
