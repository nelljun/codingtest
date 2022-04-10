package src.programmers;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

	public static void main(String[] args) {
		String numbers = "011";
		solution(numbers);
	}//main() end

	static Set<Integer> primeSet;
	static char[] numCharArr;
	static boolean[] isUsed;
	static StringBuilder sb;
	
	public static int solution(String numbers) {
		int totalLength = numbers.length();
		primeSet = new HashSet<>();
		numCharArr = numbers.toCharArray();
		isUsed = new boolean[totalLength];
		sb = new StringBuilder();

		dfs(0, totalLength);

		return primeSet.size();
	}//solution() end

	public static void dfs(int length, int totalLength) {
		if (sb.length()>0) {
			int nowNum = Integer.parseInt(sb.toString());
			if (isPrime(nowNum)) {
				primeSet.add(nowNum);
			}
		}
		if (length==totalLength) return;

		for (int i = 0; i < numCharArr.length; i++) {
			if (!isUsed[i]) {
				isUsed[i] = true;
				sb.append(numCharArr[i]);
				dfs(length+1, totalLength);
				isUsed[i] = false;
				sb.deleteCharAt(sb.length()-1);
			}
		}//for end
	}//dfs() end

	public static boolean isPrime(int n) {
		if (n==0 || n==1) return false;

		for (int i = 3; i <= (int)(Math.sqrt(n)); i+=2) {
			if (n%i == 0) return false;
		}//for end

		return true;
	}//isPrime() end
}
