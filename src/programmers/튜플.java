package src.programmers;

import java.util.*;
import java.util.Map.Entry;

public class 튜플 {

    public static void main(String[] args) {
        solution2("{{1,2,3},{2,1},{1,2,4,3},{2}}");
    }//main() end

    public static void solution(String s) {
        String[] strSplit = s.substring(2).split("([{}],?[{}])");

        String[][] finalSplit = new String[strSplit.length][];

        for(int i=0; i<strSplit.length; i++) {
            finalSplit[i] = strSplit[i].split(",");
        }//for end

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<finalSplit.length; i++) {
            for (String str : finalSplit[i]) {
                map.put(str, map.getOrDefault(str, 0)+1);
            }
        }//for end

        List<Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());

        Collections.sort(entries, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        int[] answer = new int[entries.size()];

        for(int i=0; i<answer.length; i++) {
            answer[i] = Integer.parseInt(entries.get(i).getKey());
        }

    }//solution() end

    public static void solution2(String s) {
        String[] splitStrArr = s.substring(2).split(",|([{}],?[{}])");

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<splitStrArr.length; i++) {
            map.put(splitStrArr[i], map.getOrDefault(splitStrArr[i], 0)+1);
        }//for end

        List<Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        Collections.sort(entryList, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        int[] answer = new int[entryList.size()];

        for(int i=0; i<answer.length; i++) {
            answer[i] = Integer.parseInt(entryList.get(i).getKey());
        }//for end

    }//solution2() end

    public static void solution3(String s) {

        String newStr = s.replaceAll("[{}]", "");

        String[] splitStrArr = newStr.split(",");

        Map<String, Integer> map = new HashMap<>();

        for (String splitStr : splitStrArr) {
            map.put(splitStr, map.getOrDefault(splitStr, 0) + 1);
        }

        int size = map.size();
        int[] answer = new int[size];

        for (String key : map.keySet()) {
            answer[size-map.get(key)] = Integer.parseInt(key);
        }

    }//solution3() end
}
