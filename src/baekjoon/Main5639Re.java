package src.baekjoon;

import java.util.Scanner;

public class Main5639Re {

	static int[] tree = new int[10001];
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int idx = 0;
		while(scanner.hasNext()) {
			tree[idx++] = scanner.nextInt();
		}//while end
		postOrder(0,idx-1);
	}//main() end
	
	static void postOrder(int n, int end) {
		if(n>end) return;
		
		int mid = n+1;
		while(mid<=end && tree[mid]<tree[n]) {
			mid++;
		}//while end
		
		postOrder(n+1, mid-1);
		postOrder(mid, end);
		System.out.println(tree[n]);
	}//postOrder() end
}
