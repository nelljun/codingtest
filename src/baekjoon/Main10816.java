package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10816 {

	public static void main (String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] intArr1 = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			intArr1[i] = Integer.parseInt(st.nextToken());
		}//for end
	
		Arrays.sort(intArr1);
		
		int m = Integer.parseInt(br.readLine());
		int[] intArr2 = new int[m];
		
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<m; i++) {
			intArr2[i] = Integer.parseInt(st.nextToken());
			
			sb.append(binarySearch(intArr1, intArr2[i])).append(" ");
		}//for end
		
		System.out.println(sb);
	}//main() end
	
	static int binarySearch(int[] intArr, int key) {
		//키 값이 같은 요소 갯수 리턴
		//있으면 갯수, 없으면 0
		int pl = 0;
		int pr = intArr.length-1;
		int count = 0;
		
		while(pl<=pr) {
			int pc = pl+(pr-pl)/2;
			
			if(intArr[pc]==key) {
				int temp = pc;
				count++;
				for(; pl<temp; temp--) {
					if(intArr[temp-1]!=key) {
						break;
					}//if end
					count++;
				}//for end
				temp = pc;
				for(; temp<pr; temp++) {
					if(intArr[temp+1]!=key) {
						break;
					}//if end
					count++;
				}//for end
				return count;
			} else if(intArr[pc]<key) {
				pl = pc+1;
			} else {
				pr = pc-1;
			}//if~ end
		}//while end
				
		return count;
	}//binarySearch() end
}
