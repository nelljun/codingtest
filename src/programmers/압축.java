package src.programmers;

import java.util.*;

public class 압축 {

    public static void main(String[] args) {
        solution("A");
    }

    //사전을 Map으로
    public static int[] solution(String msg) {
        //사전
        Map<String, Integer> dictionary = new HashMap<>();

        for (int i = 65; i < 91; i++) {
            dictionary.put((char)(i)+"", i-64);
        }//for end

        //답
        List<Integer> answerList = new ArrayList<>();

        int index = 0;
        int msgLength = msg.length();

        while(index < msgLength) {

            for (int k = 1; k <= msgLength; k++) {
                try {
                    //인덱스 범위 벗어나면 발생하는 exception 잡아서 catch 구문 실행
                    String subStr = msg.substring(index, index + k+1);
            
                    if (!dictionary.containsKey(subStr)) {
                        //색인 번호 출력
                        answerList.add(dictionary.get(msg.substring(index, index + k)));
                        //사전 등록
                        dictionary.put(subStr, dictionary.size() + 1);
                        //인덱스 이동
                        index += k;
                        //for 탈출
                        break;
                    }//if end
                } catch (Exception e) {
                    //인덱스 범위 벗어났으면
                    //현재 인덱스서부터 끝까지의 문자열의 색인 번호 출력
                    answerList.add(dictionary.get(msg.substring(index)));
                    //인덱스 이동
                    index += k;
                    //for 탈출
                    break;
                }
            }//for end
        }//while end

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }//for end

        return answer;

    }//solution() end

    //사전을 List로
    public static int[] solution2(String msg) {
        //사전
        List<String> dictionary = new ArrayList<>();

        for (int i = 65; i < 91; i++) {
            dictionary.add((char)(i)+"");
        }//for end

        //답
        List<Integer> answerList = new ArrayList<>();

        int index = 0;
        int msgLength = msg.length();

        while(index < msgLength) {

            for (int k = 1; k <= msgLength; k++) {
                try {
                    String subStr = msg.substring(index, index + k+1);

                    if (!dictionary.contains(subStr)) {
                        //색인 번호 출력
                        answerList.add(dictionary.indexOf(msg.substring(index, index + k))+1);
                        //사전 등록
                        dictionary.add(subStr);
                        //인덱스 이동
                        index += k;
                        //반복문 탈출
                        break;
                    }//if end
                } catch (Exception e) {
                    answerList.add(dictionary.indexOf(msg.substring(index))+1);
                    index += k;
                    break;
                }
            }//for end
        }//while end

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }//for end

        return answer;

    }//solution() end

}