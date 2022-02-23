package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15649 {
	
	static int N;
	static int M;
	static int[] arr;
	static boolean[] isUsed; 
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		isUsed = new boolean[N];
		
		combination(0);
		
	}//main() end
	
	//���ǿ� �´� �迭 ����� print
	public static void combination(int index) {
		if(index==M) {
			printArr(arr);
			return;
		} else {
			for(int i=1; i<=N; i++) {
				//�ش� ���ڰ� ��뿩�� Ȯ��
				if(!isUsed[i-1]) {
					//����������, arr[index]�� �ش� �� �����ϰ� ��� ���� üũ
					arr[index] = i;
					isUsed[i-1] = true;
					//���� �ε����� ���ؼ� ���� �۾�
					combination(index+1);
					//arr�� ����index�� ���� i�϶� ��� ��� ��������
					//arr�� ����index�� �� �ݳ�
					isUsed[i-1] = false;
				}//if else
			}//for end
		}//if else end
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
