package src.programmers;

public class ������ǥ�� {

	public static void main(String[] args) {
		solution(15);
	}//main() end
	
	public static void solution(int num) {
		//k��, ù �� n
		//k * n + (1+...+k-1) = num�� �����ϴ� n>=1�� �ִٸ� count
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
	
	//1~k���� ��
	public static int sigma(int k) {
		if(k<=0) {
			return 0;
		}
		return sigma(k-1) + k;
	}//sigma() end
}
