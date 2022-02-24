package src.programmers;


public class 다음큰숫자 {

	public static void main(String[] args) {
		int n = 15;
		solution(n);
	}//main() end
	
	public static void solution(int n) {
		
		//countOne()에 해당하는 Integer.bitCount(int n)이 존재한다.
		
		int theNumOfOne = countOne(n);
		
		while(true) {
			n++;
			if(theNumOfOne==countOne(n)) break;
		}//while end
		
		System.out.println(n);
		
	}//solution() end
	
	public static int countOne(int n) {
		String binStr = Integer.toBinaryString(n);
		char[] binArr = binStr.toCharArray();
		int count = 0;
		for(char bin : binArr) {
			if(bin=='1') count++;
		}//for end
		
		return count;
	}
}
