package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main10845 {

	private static int front, rear = 0;
	private static int size = 0;
	private static int[] queue;
	
	static void push(int x) {
		queue[rear++] = x;
		size++;
		rear %= queue.length;
	}
	static int pop() {
		if(size==0) {
			return -1;
		} else {
			int result = queue[front++];
			front %= queue.length;
			size--;
			return result;
		}//if else end
	}
	static int size() {
		return size;
	}
	static int empty() {
		return (size==0)? 1 : 0;
	}
	static int front() {
		return (size==0)? -1 : queue[front];
	}
	static int back() {
		if(size==0) {
			return -1;
		} else {
			return queue[(rear==0)? queue.length-1 : rear-1];
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(bf.readLine());
		queue = new int[num];
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<num; i++) {
			
			String str = bf.readLine();
			StringTokenizer tokenizer = new StringTokenizer(str);
			
			switch(tokenizer.nextToken()) {
			case "push" : 
				push(Integer.parseInt(tokenizer.nextToken()));
				break;
			case "pop" :
				sb.append(pop()).append("\n");
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
