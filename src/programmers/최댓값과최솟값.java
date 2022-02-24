package src.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 최댓값과최솟값 {

	public static void main(String[] args) {
		String s = "1 2 3 4";
		solution1(s);
	}//main() end
	
	public static void solution1(String s) {
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer	st = new StringTokenizer(s);
		List<Integer> list = new ArrayList<>();
		
		while(st.hasMoreTokens()) {
			list.add(Integer.valueOf(st.nextToken()));
		}//while end
		
		Collections.sort(list);
		
		sb.append(list.get(0)).append(" ").append(list.get(list.size()-1));
		
		System.out.println(sb.toString());
		
	}//solution() end
	
	public static void solution2(String s) {
		
		StringBuilder sb = new StringBuilder();
		
		//split();
		String[] strArr = s.split(" ");
		
		int min, max;
		min = max = Integer.valueOf(strArr[0]);
		
		for(int i=0; i<strArr.length; i++) {
			int num = Integer.valueOf(strArr[i]);
			
			if(min>num) min = num;
			if(num>max) max = num;
		}//for end
		
		sb.append(min).append(" ").append(max);
		
		System.out.println(sb.toString());
	}//solution() End
}
