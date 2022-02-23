package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main10828 {
	
	private static int pointer = 0;
	private static int[] stack;

	static void push(int x) {
		stack[pointer++] = x;
	}//push() end
	static int pop() {
		return (pointer!=0)? stack[--pointer] : -1;
	}
	static int size() {
		return pointer;
	}
	static int empty() {
		return (pointer==0)? 1:0; 
	}
	static int top() {
		return (pointer!=0)? stack[pointer-1] : -1; 
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String s = bf.readLine();
		int num = Integer.parseInt(s);
		stack = new int[num];
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<num; i++) {
			
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			switch(st.nextToken()) {
			case "push" : 
				push(Integer.parseInt(st.nextToken()));
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
			case "top" :
				sb.append(top()).append("\n");
				break;
			}//switch end
		}//for end
		
		System.out.println(sb);
		
	}//main() end
}
