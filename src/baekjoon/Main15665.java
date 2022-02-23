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

public class Main15665 {

	static int N;
	static int M;
	static int[] givenArr;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//�Է��� ������� �����ؾ��ϹǷ� LinkedHashSet
	static Set<String> set = new LinkedHashSet<>();
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		givenArr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			givenArr[i] = Integer.parseInt(st.nextToken());
		}//for end
		
		//N���� �� ���� �迭 ����
		Arrays.sort(givenArr);
		
		arr = new int[M];
		
		//�迭 ����
		combination(0);
		printSet(set);
		//bw�� ����� String ���
		bw.flush();
	}//main() end
	
	//�迭 ���� �� set�� ���� method
	public static void combination(int index) throws IOException {
		if(index==M) {
			set.add(arrToStr(arr));
			return;
		} else {
			for(int i=0; i<N; i++) {
				arr[index] = givenArr[i];
				combination(index+1);
			}
		}//if~else end
	}//combination() end
	
	//set�� ����� �迭�� ��� method (bw�� ����)
	public static void printSet(Set<String> set) throws IOException {

		Iterator<String> iter = set.iterator();
		
		while(iter.hasNext()) {
			String numArrStr = iter.next();
			//bw�� ���� �ٹٲ�
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
