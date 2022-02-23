package src.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15655 {
	
	static int N;
	static int M;
	static int[] arr;
	static int[] givenArr;
	static int check = -1;
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	

	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		givenArr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			givenArr[i] = Integer.parseInt(st.nextToken());
		}//for end
		
		Arrays.sort(givenArr);
		
		arr = new int[M];
		
		combination(0);
		bw.flush();
	}//main() end
	
	//조건에 맞는 배열 만들고 print
	public static void combination(int index) throws IOException {
		if(index==M) {
			printArr(arr);
			return;
		} else {
			for(int i=check+1; i<N; i++) {
				arr[index] = givenArr[i];
				check = i;
				combination(index+1);
			}//for end
		}//if~else end
	}//combination() end
	
	//배열 print method
	public static void printArr(int[] arr) throws IOException {
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]+" ");
		}//for end
		bw.write(sb.toString());
		bw.newLine();
		//해당 배열 print후 sb 초기화
		sb.setLength(0);
	}//printArr() end
}
