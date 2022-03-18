package src.programmers;

import java.util.*;

public class 뉴스클러스터링2 {

    static final int INTEGER = 65536;

    public static void main(String[] args) {
        solution("handshake", "shake hands");

    }//main() end

    public static int solution(String str1, String str2) {
        String newStr1 = str1.toLowerCase();
        String newStr2 = str2.toLowerCase();

        List<String> subStrList1 = makeList(newStr1);
        List<String> subStrList2 = makeList(newStr2);

        int result = compareLists(subStrList1, subStrList2);

        return result;
    }//solution() end

    public static List<String> makeList(String str) {
        int length = str.length();

        List<String> subStrList = new LinkedList<>();

        for (int i = 0; i < length-1; i++) {
            String subStr = str.substring(i, i + 2);
            if((subStr.charAt(0)>='a' && subStr.charAt(0)<='z')
                    && (subStr.charAt(1)>='a' && subStr.charAt(1)<='z')) {
                subStrList.add(subStr);
            }
        }
        return subStrList;
    }//makeList() end

    public static int compareLists(List<String> list1, List<String> list2) {

        if(list1.size()==0 && list2.size()==0) return INTEGER;

        List<String> interSection = new ArrayList<>();
        List<String> union = new ArrayList<>();

        for (String subStr1 : list1) {

            if(list2.remove(subStr1)) {
                //list2에서 같은 요소가 있어 remove에 성공하면 true
                //그리고 해당 요소를 교집합에 추가한다.
                interSection.add(subStr1);
            }
            //list1의 모든 요소를 합집합에 추가한다.
            union.add(subStr1);
        }

        //교집합 요소가 빠진 list2 요소 전부 합집합에 추가한다.
        union.addAll(list2);

        return (INTEGER * interSection.size()) / union.size();
    }//compareLists() end

}
