package src.programmers;


public class ����ū���� {

	public static void main(String[] args) {
		int n = 15;
		solution(n);
	}//main() end
	
	public static void solution(int n) {
		
		//countOne()�� �ش��ϴ� Integer.bitCount(int n)�� �����Ѵ�.
		
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
