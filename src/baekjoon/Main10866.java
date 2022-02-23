package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main10866 {

	private static int front, rear, size = 0;
	private static int[] deque;
	
	static void pushFront(int x) {
		if(--front<0) { 
			front = deque.length-1;
		}//if end
		size++;
		deque[front] = x;
	}
	static void pushBack(int x) {
		deque[rear++] = x;
		rear %= deque.length;
		size++;
	}
	static int popFront() {
		if(size==0) {
			return -1;
		} else {
			int result = deque[front++];
			front %= deque.length;
			size--;
			return result;
		}
	}
	static int popBack() {
		if(size==0) {
			return -1;
		} else {
			if(--rear<0) {
				rear = deque.length-1;
			}
			size--;
			return deque[rear];
		}
	}
	static int size() {
		return size;
	}
	static int empty() {
		return (size==0)? 1:0;
	}
	static int front() {
		return (size==0)? -1 : deque[front];
	}
	static int back() {
		if(size==0) {
			return -1;
		} else {
			return deque[(rear==0)? deque.length-1 : rear-1];
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		deque = new int[num];
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<num; i++) {
			
			String str = bf.readLine();
			StringTokenizer tokenizer = new StringTokenizer(str);
			
			switch(tokenizer.nextToken()) {
			case "push_front" :
				pushFront(Integer.parseInt(tokenizer.nextToken()));
				break;
			case "push_back" :
				pushBack(Integer.parseInt(tokenizer.nextToken()));
				break;
			case "pop_front" :
				sb.append(popFront()).append("\n");
				break;
			case "pop_back" :
				sb.append(popBack()).append("\n");
				break;
			case "size" :
				sb.append(size()).append("\n");
				break;
			case "empty" :
				sb.append(empty()).append("\n");
				break;
			case "front" :
				sb.append(front()).append("\n");
				break;
			case "back" :
				sb.append(back()).append("\n");
				break;
			}//switch end
			
		}//for end
		
		System.out.println(sb);
		
	}//main() end
}
