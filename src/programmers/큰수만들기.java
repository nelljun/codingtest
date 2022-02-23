package src.programmers;

public class ū������� {

	public static void main(String[] args) {
		String number = "1231234";
		solution(number, 3);
	}//main() end
	
	public static void solution(String number, int k) {
		
		StringBuilder sb = new StringBuilder();
		
		int length = number.length();
		int[] intArr = new int[length];
		int index = -1;
		int max = -1;
		
		//string -> int[] ��ȯ
		for(int i=0; i<length; i++) {
			intArr[i] = number.charAt(i)-'0';
		}//for end
		
		for(int n=1; n<=length-k; n++) {
			for(int i=index+1; i<k+n; i++) {
				if(max<intArr[i]) {
					max = intArr[i];
					index = i;
				}//if end
				if(max==9)	break; //9�� ��� �ִ밪�̹Ƿ� ���̻� ����x
			}//for end
			sb.append(max);
			max = -1;
		}//for end
		
		System.out.println(sb.toString());
		
	}//solution() end
}
