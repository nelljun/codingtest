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
	
	//조건에 맞는 배열 만들고 print
	public static void combination(int index) {
		if(index==M) {
			printArr(arr);
			return;
		} else {
			for(int i=1; i<=N; i++) {
				//해당 숫자가 사용여부 확인
				if(!isUsed[i-1]) {
					//사용안했으면, arr[index]에 해당 값 대입하고 사용 여부 체크
					arr[index] = i;
					isUsed[i-1] = true;
					//다음 인덱스에 대해서 같은 작업
					combination(index+1);
					//arr의 현재index의 값이 i일때 모든 경우 끝났으니
					//arr의 현재index의 값 반납
					isUsed[i-1] = false;
				}//if else
			}//for end
		}//if else end
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
