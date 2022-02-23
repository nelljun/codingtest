package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15650 {
	
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	//배열 생성 시, 오름차순 기준이 되는 수
	static int check=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		combination(0);
	}//main() end
	
	//조건에 맞는 배열 만들고 print
	public static void combination(int index) {
		if(index==M) {
			printArr(arr);
			return;
		} else {
			for(int i=check+1; i<=N; i++) {
				arr[index] = i;
				//현재 값이 새로운 오름차순 기준이 된다
				check = i;
				combination(index+1);
			}//for end
		}//if~else end
	}//combination() end
	
	//배열 print method
	public static void printArr(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]+" ");
		}//for end
		System.out.println(sb);
		//해당 배열 print후 sb 초기화
		sb.setLength(0);
	}//printArr() end
}
