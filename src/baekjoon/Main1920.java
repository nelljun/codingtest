package src.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main1920 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] intArr1 = new int[n];
		
		for(int i=0; i<n; i++) {
			intArr1[i] = scanner.nextInt();
		}//for end
		
		Arrays.sort(intArr1);
		
		int m = scanner.nextInt();
		int[] intArr2 = new int[m];
		
		for(int i=0; i<m; i++) {
			intArr2[i] = scanner.nextInt();
		}//for end
		
		for(int j=0; j<m; j++) {
			System.out.println(binarySearch(intArr1, intArr2[j]));
		}//for end
		
		
	}//main() end
	
	static int binarySearch(int[] intArr, int key) {
		int pl = 0;
		int pr = intArr.length-1;
		
		while(pl<=pr) {
			int pc = (pl+pr)/2;
			if(intArr[pc]==key) {
				return 1;
			} else if(intArr[pc]>key) {
				pr = pc-1;
			} else {
				pl = pc+1;
			}
		}//while end
		
		return 0;
	}//binarySearch() end
}
