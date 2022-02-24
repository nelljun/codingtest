package src.programmers;

import java.util.Arrays;
import java.util.HashMap;

public class 전화번호목록 {
	
	public boolean solutionHash(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        
	    for(int i=0; i<phone_book.length; i++) {
	    	hashMap.put(phone_book[i], i);
	    }//for end
	   
	    for(int i=0; i<phone_book.length; i++) {
	    	//자신을 앞에서부터 하나씩 잘라가면서 해당 string이 map의 key에 존재하는지 확인
	    	for(int j=0; j<phone_book[i].length(); j++) {
	    		if(hashMap.containsKey(phone_book[i].substring(0, j))) {
	    			answer = false;
	    		}//if end
	    	}//for end
	    }//for end
        
        
        return answer;
    }
	
	public boolean solutionSortLoop(String[] phone_book) {
		boolean answer = true;
		
		Arrays.sort(phone_book);
		
		for(int i=0; i<phone_book.length-1; i++) {
			if(phone_book[i+1].startsWith(phone_book[i])) answer = false;
		}//for end
		
		//string 정렬하면 시작 숫자를 기준으로 하기 때문에
		//바로 뒤 요소와만 비교해보면 된다. 
		//11 21 111 이런식이 아닌 11 111 21로 정렬되기 때문이다
		return answer;
	}
}
