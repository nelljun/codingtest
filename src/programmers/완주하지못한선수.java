package src.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class �����������Ѽ��� {
	
    public String solution(String[] participant, String[] completion) {
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        //�� �迭�� �����ϸ�, ���� index������ ��Ұ� �ٸ��ٸ� �ش� participant�迭�� ��Ұ� �������� ���� ������
        int i = 0;
        for(i=0; i<completion.length; i++) {
        	if(!participant[i].equals(completion[i])) {
        		break;
        	}//if end
        }//for end
        
        return participant[i];
    }
    
    public String solutionHash(String[] participant, String[] completion) {
    	
    	String answer = "";
    	
    	HashMap<String, Integer> map = new HashMap<>();
    	
    	//map<������ �̸�, �ش� �̸��� ������ ��>
    	//map.getOrDefault()
    	for(String player : participant) {
    		map.put(player, map.getOrDefault(player, 0) + 1);
    	}//for end
    	//�����ڸ� ��� �߰��� map���� ������ ����� ����
    	for(String player : completion) {
    		map.put(player, map.get(player)-1);
    	}//for end
    	
    	//EntrySet, Iterator
    	Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
       	Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
    	
       	//�����ڸ� ��� ���� �� �ش� map���� value���� 0�� �ƴ� key�� �������� ���� ������
    	while(entryIterator.hasNext()) {
    		Map.Entry<String, Integer> entry = entryIterator.next();
    		if(entry.getValue()!=0) {
    			answer = entry.getKey();
    			break;
    		}//if end
    	}//while end
    	
    	return answer;
    	
    }
}
