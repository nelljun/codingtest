package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14888Re {
	
	static int[] numbers;
	static int[] operators;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(bf.readLine());
		numbers = new int[num];
		operators = new int[4];
		
		StringTokenizer tokenizer = new StringTokenizer(bf.readLine(), " ");
		for(int i=0; i<num; i++) {
			numbers[i] = Integer.parseInt(tokenizer.nextToken());
		}//for end
		
		tokenizer = new StringTokenizer(bf.readLine(), " ");
		for(int i=0; i<4; i++) {
			operators[i] = Integer.parseInt(tokenizer.nextToken());
		}//for end
		
	}//main() end
	
	public static void dfs() {
		
	}//dfs() end
}
