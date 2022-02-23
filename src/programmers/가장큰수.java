package src.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {

	public static void main(String[] args) {
		int[] numbers = {3502,4,3,30,300,301,352};
		solution(numbers);
	}
	
	public static String solution(int[] numbers) {
		
		StringBuilder sb = new StringBuilder();
		 
		String[] strArr = new String[numbers.length];
		for(int i=0; i<numbers.length; i++) {
			strArr[i] = String.valueOf(numbers[i]);
		}//for end
		
		Arrays.sort(strArr, new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				String temp1 = str1+str2;
				String temp2 = str2+str1;
				return temp2.compareTo(temp1); //내림차순
			}
		});
		
		if(strArr[0].equals("0")) {
			//모든 숫자가 0인 경우
			sb.append("0");
		} else {
			for(String string : strArr) {
				sb.append(string);
			}//for end
		}//if~else end
		
		return sb.toString();
		
	}
}
