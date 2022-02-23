package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main14888 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(bf.readLine());
		
		StringTokenizer tokenizer = new StringTokenizer(bf.readLine(), " ");
		
		int result = Integer.parseInt(tokenizer.nextToken());//ù��° ��
//		System.out.println(result);
		
		Set<int[]> set = new HashSet<int[]>();
		int[] data = new int[num-1];
		int factorial = factorial(num-1);
		
		for(int i=0; i<factorial; i++) {
			for(int j=0; j<num-1; j++) {
				data[j] = 4;
			}//for end
			set.add(data);
		}//for end
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int[] operationArr : set) {
			for(int i=0; i<num-1; i++) {
				switch(operationArr[i]) {
				case 1: result += Integer.parseInt(tokenizer.nextToken());
				break;
				case 2: result -= Integer.parseInt(tokenizer.nextToken());
				break;
				case 3: result *= Integer.parseInt(tokenizer.nextToken());
				break;
				case 4: result /= Integer.parseInt(tokenizer.nextToken());
				break;
				}//switch end
			}//for end
			pq.add(result);
		}//for end
		
		System.out.println(pq.poll());
		
	}//main() end
	
	static public int factorial(int n) {
		if(n==0) {
			return 1;
		}
		
		return n*factorial(n-1);
	}//factorial() end
}
