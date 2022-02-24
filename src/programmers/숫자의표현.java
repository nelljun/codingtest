package src.programmers;

public class 숫자의표현 {

	public static void main(String[] args) {
		solution(15);
	}//main() end
	
	public static void solution(int num) {
		//k개, 첫 수 n
		//k * n + (1+...+k-1) = num을 만족하는 n>=1이 있다면 count
		int k=1;
		int count=0;
		while(sigma(k-1)<num) {
			if((num-sigma(k-1)) % k == 0) {
				System.out.println("k : "+k);
				count++;
			}//if end
			k++;
		}//while end
	
		System.out.println(count);
	}//solution() end
	
	//1~k까지 합
	public static int sigma(int k) {
		if(k<=0) {
			return 0;
		}
		return sigma(k-1) + k;
	}//sigma() end
}
