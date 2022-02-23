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
	//�迭 ���� ��, �������� ������ �Ǵ� ��
	static int check=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		combination(0);
	}//main() end
	
	//���ǿ� �´� �迭 ����� print
	public static void combination(int index) {
		if(index==M) {
			printArr(arr);
			return;
		} else {
			for(int i=check+1; i<=N; i++) {
				arr[index] = i;
				//���� ���� ���ο� �������� ������ �ȴ�
				check = i;
				combination(index+1);
			}//for end
		}//if~else end
	}//combination() end
	
	//�迭 print method
	public static void printArr(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]+" ");
		}//for end
		System.out.println(sb);
		//�ش� �迭 print�� sb �ʱ�ȭ
		sb.setLength(0);
	}//printArr() end
}
