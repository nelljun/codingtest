package src.programmers;

import java.util.Arrays;

public class ����Ʈ {
	
	public static void main(String[] args) {
		int[] people = {40,40,40};
		int limit = 80;
		
		solution(people, limit);
	}//main() end
	
	public static void solution(int[] people, int limit) {
		
		Arrays.sort(people);
		//¦�� ��
		int count = 0;
		//�ִ��� ���� ���̰� ���� ���� ������� ¦�ؾ� �ּҰ�
		int index = people.length;
		//¦ ������ (���ſ�)����� index
		//���� cycle �� index-1���� Ž��
		
		for(int n=0; n<index; n++) {
			for(int i=index-1; i>n; i--) {
				if((people[n]+people[i])<=limit) {
					index = i;
					count++;
					break;
				}
			}//for end
			//���� ������ ����� ¦���� ��� break;
			if(index==people.length) break;
		}//for end
		
		System.out.println(people.length-count);
	}//solution() end
}
