package src.programmers;

import java.util.HashMap;
import java.util.Iterator;

public class 위장 {

	public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
        	hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1], 0)+1);
        }//의상의 종류를 value, 해당 종류의 갯수를 key로 저장
        
//        Set<String> keySet = hashMap.keySet();
//        Iterator<String> keyIterator = keySet.iterator();
        //value iterator
        Iterator<Integer> iterator = hashMap.values().iterator();
        
        //intValue() vs parseInt()
        while(iterator.hasNext()) {
        	answer *=  iterator.next().intValue()+1;
        }//while() end
        
        //모든 옷의 종류에 대해서 입지 않는 경우를 포함하여 곱한 다음에
        //모든 옷을 입지 않은 경우를 빼주면 전체 경우의 수가 나온다.
        
        return answer-1;
    }
	
}
