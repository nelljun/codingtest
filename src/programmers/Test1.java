package src.programmers;

import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		
		int[] arr1 = {1,52,125,10,25,201,244,192,128,23,203,98,154,255};
		int[] arr2 = {0,0,255,255,0,0,255,255,255};
		int[] arr3 = {100, 50, 100, 200};
		solution(arr3);
		
	}//main() end
	
	public static void solution(int[] arr) {
		
		int t = -1;
		int length = arr.length;
		
		Arrays.sort(arr);
		
		int index = (length/2)-1;
		
		int left = 0;
		int right = 0;
		
		if(index<0) {
			t = 0;
		} else if(arr[index]!=arr[index+1]) {
			t = arr[index]+1;
		} else if(arr[index]==arr[index+1]) {
			while((0<=index-left)&&(index+right<length)) {
				if(arr[index]==arr[index-left]) {
					left++;
				}//if end
				if(arr[index]==arr[index+right]) {
					right++;
				}//if end
			}//while end
			System.out.println("left : "+left);
			System.out.println("right : "+right);
		}//if~else end
		
		System.out.println(t);
	}//solution() end
}
