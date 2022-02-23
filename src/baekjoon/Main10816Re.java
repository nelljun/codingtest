package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10816Re {

public static void main (String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] intArr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			intArr[i] = Integer.parseInt(st.nextToken());
		}//for end
	
		Arrays.sort(intArr);
		
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<m; i++) {
			int key = Integer.parseInt(st.nextToken());
			
			sb.append(upperBound(intArr, key)-lowerBound(intArr, key)).append(" ");
		}//for end
		
		System.out.println(sb);
	}//main() end

	static int lowerBound(int[] intArr, int key) {
		int pl = 0;
		int pr = intArr.length;
		
		while(pl<pr) {
			int pc = (pl+pr) / 2;
			
			if(intArr[pc]>=key) {
				pr = pc;
			} else {
				pl = pc+1;
			}//if end
		}//while end
		return pl;
	}//lowerBound() end
	
	static int upperBound(int[] intArr, int key) {
		int pl = 0;
		int pr = intArr.length;
		
		while(pl<pr) {
			int pc = (pl+pr) / 2;
			
			if(intArr[pc]<=key) {
				pl = pc+1;
			} else {
				pr = pc;
			}//if end
		}//while end
		return pr;
	}//lowerBound() end
}
