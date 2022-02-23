package src.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main15651 {
	
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		combination(0);
		bw.flush();
	}//main() end
	
	//���ǿ� �´� �迭 ����� print
	public static void combination(int index) throws IOException {
		if(index==M) {
			printArr(arr);
			return;
		} else {
			for(int i=1; i<=N; i++) {
				arr[index] = i;
				combination(index+1);
			}//for end
		}//if~else end
	}//combination() end
	
	//�迭 print method
	public static void printArr(int[] arr) throws IOException {
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]+" ");
		}//for end
		bw.write(sb.toString());
		bw.newLine();
		//�ش� �迭 print�� sb �ʱ�ȭ
		sb.setLength(0);
	}//printArr() end
}
