package src.programmers;

import java.util.*;

public class 후보키 {

    public static void main(String[] args) {
        String[][] relation = { {"100","ryan","music","2"},
                                {"200","apeach","math","2"},
                                {"300","tube","computer","3"},
                                {"400","con","computer","4"},
                                {"500","muzi","music","3"},
                                {"600","apeach","music","2"} };
        solution(relation);
    }//main() end

    //후보키 저장 리스트
    static List<Integer> keys = new ArrayList<>();

    //최소성 확인 메소드
    static boolean checkIfMin(int i) {
        for (Integer key : keys) {
            //기존 키와 현재 키를 & 비트연산한 값이
            //기존 키와 같다면 현재 키는 최소성을 만족하지 않는다.
            //ex) 0011 & 1011 = 0011
            if ((key & i)==key) return false;
        }//for end
        return true;
    }

    public static int solution(String[][] relation) {
        int rowNum = relation.length; //행수
        int colNum = relation[0].length; //열수

        //한 키당 해당 컬럼의 튜플 값 저장할 set
        Set<String> set = new HashSet<>();
        //키에서 값이 1인 자릿수의 문자열 붙일 sb
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < (1<<colNum); k++) {
            //현재 키 최소성 체크
            if(!checkIfMin(k)) continue;

            //set 초기화
            set.clear();

            for (int i = 0; i < rowNum; i++) {
                //sb 초기화
               sb.setLength(0);

                for (int j = 0; j < colNum; j++) {

                    if (((1<<j) & k) > 0) {
                        //현재 키에서 값이 1인 자릿수에 해당하는 j 인덱스에
                        //해당하는 문자열을 sb에 붙인다.
                        sb.append(relation[i][j]);
                    }
                }//for end

                //조립한 문자열을 set에 넣었을 때 false라면
                //유일성이 만족하지 않은 것이므로 해당 key에 대해 break
                if (!set.add(sb.toString())) break;
            }//for end

            //해당 키에서의 set 사이즈가 튜플의 수와 같다면
            //유일성 만족하므로 후보키 저장 리스트에 추가
            if(set.size()==rowNum) keys.add(k);
        }//for end

        return keys.size();
    }//solution() end
}
