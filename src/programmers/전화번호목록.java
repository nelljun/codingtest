package src.programmers;

import java.util.Arrays;
import java.util.HashMap;

public class ��ȭ��ȣ��� {
	
	public boolean solutionHash(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        
	    for(int i=0; i<phone_book.length; i++) {
	    	hashMap.put(phone_book[i], i);
	    }//for end
	   
	    for(int i=0; i<phone_book.length; i++) {
	    	//�ڽ��� �տ������� �ϳ��� �߶󰡸鼭 �ش� string�� map�� key�� �����ϴ��� Ȯ��
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
		
		//string �����ϸ� ���� ���ڸ� �������� �ϱ� ������
		//�ٷ� �� ��ҿ͸� ���غ��� �ȴ�. 
		//11 21 111 �̷����� �ƴ� 11 111 21�� ���ĵǱ� �����̴�
		return answer;
	}
}
