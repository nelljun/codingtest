package src.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main15663 {

	static int N;
	static int M;
	static int[] givenArr;
	static int[] arr;
	static boolean[] isUsed;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//입력한 순서대로 정렬해야하므로 LinkedHashSet
	static Set<String> set = new LinkedHashSet<>();
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		givenArr = new int[N];
		isUsed = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			givenArr[i] = Integer.parseInt(st.nextToken());
		}//for end
		
		//N개의 수 담은 배열 정렬
		Arrays.sort(givenArr);
		
		arr = new int[M];
		
		//배열 조합
		combination(0);
		printSet(set);
		//bw에 적재된 String 출력
		bw.flush();
	}//main() end
	
	//배열 조합 후 set에 저장 method
	public static void combination(int index) throws IOException {
		if(index==M) {
			set.add(arrToStr(arr));
			return;
		} else {
			for(int i=0; i<N; i++) {
				if(!isUsed[i]) {
					arr[index] = givenArr[i];
					isUsed[i] = true;
					combination(index+1);
					isUsed[i] = false;
				}//if end
			}
		}//if~else end
	}//combination() end
	
	//set에 저장된 배열들 출력 method (bw에 적재)
	public static void printSet(Set<String> set) throws IOException {

		Iterator<String> iter = set.iterator();
		
		while(iter.hasNext()) {
			String numArrStr = iter.next();
			//bw에 적고 줄바꿈
			bw.write(numArrStr);
			bw.newLine();
		}//while end
		
	}//printSet() end
	
	public static String arrToStr(int[] arr) {
		sb.setLength(0);
		
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]).append(" ");
		}//for end
		
		return sb.toString();
	}//arrToStr() end
}
