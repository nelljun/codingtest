package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11729 {
	
	private static int count;
	private static final StringBuilder sb = new StringBuilder();
	
	static void hanoi(int n, int from, int to) {
		
		if(n==1) {
			sb.append(from+" "+to+"\n");
			count++;
		} else {
			hanoi(n-1, from, 6-from-to);
			sb.append(from+" "+to+"\n");
			count++;
			hanoi(n-1, 6-from-to, to);
		}
	}//hanoi() end
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		hanoi(n, 1, 3);
		sb.insert(0, count+"\n");
		System.out.println(sb);
	}
}
