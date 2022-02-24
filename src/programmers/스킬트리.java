package src.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class 스킬트리 {

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skillTrees = {"BACDE", "CBADF", "AECB", "BDA"};
        solution3(skill, skillTrees);
    }//main() end

    public static void solution(String skill, String[] skillTrees) {

        char[] charArr = skill.toCharArray();
        //skill 탐색 위한 index (index+1부터)
        int index = -1;
        int cnt = 0;
        //선행 스킬에 포함되지만 순서 맞지 않는 경우,
        //연산을 빠져나오기 위한 flag
        boolean check = true;
        for (String skillTree : skillTrees) {
            //새 skillTree마다 check, index 변수 초기화
            check = true;
            index = -1;
            int length = skillTree.length();
            for (int i = 0; i < length; i++) {
                for (int j = index+1; j < charArr.length; j++) {
                    if (skillTree.charAt(i) == charArr[j]) {
                        //skillTree의 스킬이 skill에 포함된 경우
                        if (j!=index+1) {
                            //포함되었지만 순서가 맞지 않은 경우
                            //해당 skillTree에서의 연산(for문)을 빠져나가기 위해
                            check = false;
                            break;
                        } else {
                            //포함되고, 현재 순서가 맞은 경우
                            index++;
                        }//if else end
                    }//if end
                }//for end
                if(!check) break;
            }//for end
            if(check) {
                cnt++;
            }//if end
        }//for() end

        System.out.println(cnt);
    }//solution() end

    //String의 method들 활용 (런타임 에러)
    //contains(), indexOf()
    public static void solution2(String skill, String[] skillTrees) {
        int cnt = 0;

        for(String skillTree : skillTrees) {
            for(int i=0; i<skillTrees.length; i++) {
                String s = skillTree.substring(i, i+1);
                if(skill.contains(s)) {
                    if(skill.indexOf(s)==0) {
                        cnt++;
                    } else {
                        break;
                    }//if end
                }//if end
            }//for end
        }//for end

        System.out.println(cnt);
    }//solution2() end

    //정규표현식 활용
    //[^skill]로 skill에 해당하지 않는 문자를 빈 문자로 치환
    //해당 변환 문자열
    //replaceAll() indexOf()
    public static void solution3(String skill, String[] skillTrees ) {
        int cnt = 0;

        for(String skillTree : skillTrees) {
            if(skill.indexOf(skillTree.replaceAll("[^"+skill+"]", ""))==0) cnt++;
        }
        System.out.println(cnt);
    }//solution3() end
}
