package src.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Test2 {

	public static void main(String[] args) {
		String[] records1 = {"john share", "mary comment", 
		                     "jay share", "check notification", 
		                     "check notification", "sally comment", 
		                     "james share", "check notification", 
		                     "lee share", "laura share", "will share", 
		                     "check notification", "alice comment", 
		                     "check notification"};
		
		String[] records2 = {"john share", "mary share", "jay share", 
				"james comment", "lee share", "check notification", 
				"sally comment", "laura comment", "check notification", 
				"will share", "ruby share", "check notification"};
		
		solution(records1);
	}//main() end
	
	public static void solution(String[] records) {
		
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		//�˸�â
		Stack<String> notifications = new Stack<>();
		//������
		Queue<String> storage = new LinkedList<>();
		
		String firstToken = null;
		String secondToken = null;
		String prevFirstToken = null;
		String prevSecondToken = null;
		
		for(String record : records) {
//			System.out.println("record : "+record);
			if(notifications.isEmpty()) {
				notifications.add(record);
				continue;
			}
			st = new StringTokenizer(record);
			firstToken = st.nextToken();
			secondToken = st.nextToken();
//			System.out.println("firstToken : "+ firstToken);
//			System.out.println("secondToken : "+ secondToken);
			if(firstToken.equals("check")) {
				//check notification�� ��
//				System.out.println("check notification�� ���");
				//�˸�â���� ���������� �̵�
				storage.add(notifications.pop());
			} else {
				//�˸� ǥ��
				//firstToken : �̸�
				//secondToken : �˸�����
//				System.out.println("�˸�ǥ��");
				//�˸��� ������ ���� �˸��� ������ ������ Ȯ��
				st = new StringTokenizer(notifications.peek());
				prevFirstToken = st.nextToken();
				prevSecondToken = st.nextToken();
//				System.out.println("prevFirstToken : "+prevFirstToken);
//				System.out.println("prevSecondToken : "+prevSecondToken);
				if(secondToken.equals(prevSecondToken)) {
//					System.out.println("���� �˸� ���� ���� ���");
					//���� �˸� ���� ���� ���
					if(st.hasMoreTokens()) {
						//���� ���� �˸� �̹� 2�� �̻��� ��
						String prevThirdToken = st.nextToken();
						if(prevThirdToken.length()==1) {
							//���� �˸��� 3��° ��ū�� 1������ ��, �� ������ ��, ���� �˸����� �̹� 3�� �̻��� ��
							String prevNotifications = notifications.pop();
							String newNotifications = prevNotifications.substring(0, prevNotifications.length()-1);
							newNotifications += (Integer.valueOf(prevThirdToken)+1);
//							System.out.println("newNotifications : "+newNotifications);
							notifications.add(newNotifications);
						} else {
							//�̸��� ��, �� ���� �˸����� 2���� ��
							String prevNotifications = notifications.pop();
							String newNotifications = prevNotifications.substring(0, prevNotifications.length()-prevThirdToken.length()-1);
							newNotifications += " 2";
//							System.out.println("newNotifications : "+newNotifications);
							notifications.add(newNotifications);
						}//if~else end
					} else {
						//���� �˸����� ���� ������ ��
						//���� �˸��� ���� ó���ϴ� �˸� �̸� �ٿ���
						String prevNotifications = notifications.pop();
//						System.out.println("prevNotifications : "+prevNotifications);
						prevNotifications += " "+firstToken;
//						System.out.println(prevNotifications);
						notifications.add(prevNotifications);
					}//if~else end
				} else {
					//���� �˸� ���� �ٸ� ���
					notifications.add(record);
				}//if~else end
			}//if~else end
		}//for end
		
		
		List<String> result = new ArrayList<>(); 
		
		while(!storage.isEmpty()) {
			String notification = storage.poll();
			st = new StringTokenizer(notification);
			firstToken = st.nextToken();
			secondToken = st.nextToken();
			sb.append(firstToken+" ");
			if(st.hasMoreTokens()) {
				String thirdToken = st.nextToken();
				if(thirdToken.length()==1) {
					sb.append("and "+thirdToken+" others ");
				} else {
					sb.append("and "+thirdToken+" ");
				}
			}
			if(secondToken.equals("share")) {
				sb.append(secondToken).append("d").append(" your post");
			} else {
				sb.append(secondToken).append("ed").append(" on your post");
			}
			result.add(sb.toString());
			System.out.println(sb);
			sb.setLength(0);
		}
		
		String[] answer = new String[result.size()];
		for(int i =0; i<answer.length; i++) {
			answer[i] = result.get(i);
		}//for end
		
		
		
	}//solution() end
}
