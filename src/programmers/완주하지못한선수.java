package src.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class 완주하지못한선수 {
	
    public String solution(String[] participant, String[] completion) {
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        //두 배열을 정렬하면, 같은 index에서의 요소가 다르다면 해당 participant배열의 요소가 완주하지 못한 참가자
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
    	
    	//map<참가자 이름, 해당 이름의 참가자 수>
    	//map.getOrDefault()
    	for(String player : participant) {
    		map.put(player, map.getOrDefault(player, 0) + 1);
    	}//for end
    	//참가자를 모두 추가한 map에서 완주한 사람을 뺀다
    	for(String player : completion) {
    		map.put(player, map.get(player)-1);
    	}//for end
    	
    	//EntrySet, Iterator
    	Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
       	Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
    	
       	//완주자를 모두 뺐을 때 해당 map에서 value값이 0이 아닌 key가 완주하지 못한 참가자
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
