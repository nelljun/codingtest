package src.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ������ {
	
	static Integer[] dump = {0, -1};
	
	public static void main(String[] args) {
		int[] priorities = {1,1,9,1,1,1};
		int location = 0;
		int result = solution(priorities, location);
		System.out.println(result);
	}
	
	public static int solution(int[] priorities, int location) {

		//��û����Ʈ
		Queue<Integer[]> reqList = new LinkedList<>();
		//���� �μ⸮��Ʈ
		List<Integer> printList = new ArrayList<>();
		
		//{�߿䵵, �ε���}������ Integer�迭�� Queue������ ����
		int nodeIdx = 0;
		for(int priority : priorities) {
			Integer[] newNode = {priority, nodeIdx++};
			reqList.add(newNode);
		}//for end
		
		//�߿䵵�� ������ (���⼱ ��������)
		//���� poll�� ����Ʈ�� �߿䵵�� �����ִ� ����Ʈ ��û ����Ʈ���� ���� ������ Ȯ���ϱ� ����
		Arrays.sort(priorities);
		
		Integer[] top = dump;
		
		//queue���� poll�� ����� �߿䵵��, sort�� priorities�迭�� �� ���(�������� ���������Ƿ�)�� ��
		int index = priorities.length-1;
		while(printList.size()<priorities.length) {
			top = reqList.poll();
			if(top[0]==priorities[index]) {
				//���� top�� �߿䵵�� priorities�迭 ���� �����Ƿ�
				//printList�� �ش� top�� location(index)�� add
				printList.add(top[1]);
				//���� index�� priorities��Ұ� print�����Ƿ�
				//�� ���� index�� �̵� (�������� �����̹Ƿ� -1)
				index--;
			} else {
				//�ٸ��ٸ�, ���� top�� �߿䵵�� ���� ��û ����Ʈ�� �߿䵵 �߿���
				//���� ���� ���� �ƴϹǷ� ��û ����Ʈ�� �� �ڷ� add
				reqList.add(top);
			}
		}
		
		int i = 0;
		for(i=0; i<printList.size(); i++) {
			if(printList.get(i)==location) break;
		}//for end
		
		return i+1;
    }
	
}

//1. �μ� ������� ���� �տ� �ִ� ����(J)�� ����Ͽ��� �����ϴ�.
//2. ������ �μ� ����Ͽ��� J���� �߿䵵�� ���� ������ �� ���� �����ϸ� J�� ������� ���� �������� �ֽ��ϴ�.
//3. �׷��� ������ J�� �μ��մϴ�.