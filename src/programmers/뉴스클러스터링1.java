package src.programmers;

import java.util.*;

public class 뉴스클러스터링1 {

    static final int INTEGER = 65536;

    public static void main(String[] args) {
        solution("handshake", "shake hands");
        
    }//main() end

    public static int solution(String str1, String str2) {
        String newStr1 = str1.toLowerCase();
        String newStr2 = str2.toLowerCase();

        Map<String, Integer> subStrMap1 = makeMap(newStr1);
        Map<String, Integer> subStrMap2 = makeMap(newStr2);

        int result = compareMaps(subStrMap1, subStrMap2);

        return result;

    }//solution() end

    public static Map<String, Integer> makeMap(String str) {
        int length = str.length();

        Map<String, Integer> subStrMap = new HashMap();

        for (int i = 0; i < length-1; i++) {
            String subStr = str.substring(i, i + 2);
            if((subStr.charAt(0)>='a' && subStr.charAt(0)<='z')
                    && (subStr.charAt(1)>='a' && subStr.charAt(1)<='z')) {
                subStrMap.put(subStr, subStrMap.getOrDefault(subStr, 0)+1);
            }
        }
        
        return subStrMap;
    }//splitStr() end


    public static int compareMaps(Map<String, Integer> map1, Map<String, Integer> map2) {

        if(map1.isEmpty() && map2.isEmpty()) {
            return INTEGER;
        }
        //교집합 갯수
        int interSection = 0;
        //합집합 갯수
        int union = 0;

        //두 맵의 key 비교를 위한 keySet
        Set<String> keySet1 = map1.keySet();
        Set<String> keySet2 = map2.keySet();


        for (String keyStr : keySet1) {
            if(keySet2.contains(keyStr)) {
                interSection += Math.min(map1.get(keyStr), map2.get(keyStr));
            }
        }

        Iterator<String> iterator = keySet1.iterator();
        //각 맵의 value들의 총합
        while(iterator.hasNext()) {
            union += map1.get(iterator.next());
        }
        iterator = keySet2.iterator();
        while(iterator.hasNext()) {
            union += map2.get(iterator.next());
        }

        //총 합에서 교집합 크기 빼줘야 합집합 크기
        union -= interSection;

        return (INTEGER * interSection) / union;

    }//compareMaps() end
}
