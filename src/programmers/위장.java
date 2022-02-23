package src.programmers;

import java.util.HashMap;
import java.util.Iterator;

public class ���� {

	public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
        	hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1], 0)+1);
        }//�ǻ��� ������ value, �ش� ������ ������ key�� ����
        
//        Set<String> keySet = hashMap.keySet();
//        Iterator<String> keyIterator = keySet.iterator();
        //value iterator
        Iterator<Integer> iterator = hashMap.values().iterator();
        
        //intValue() vs parseInt()
        while(iterator.hasNext()) {
        	answer *=  iterator.next().intValue()+1;
        }//while() end
        
        //��� ���� ������ ���ؼ� ���� �ʴ� ��츦 �����Ͽ� ���� ������
        //��� ���� ���� ���� ��츦 ���ָ� ��ü ����� ���� ���´�.
        
        return answer-1;
    }
	
}
