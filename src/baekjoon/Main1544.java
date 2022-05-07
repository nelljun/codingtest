package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main1544 {
    //겹치지 않는 새로운 단어 저장할 list
    static List<String> list;
    //단어의 알파벳 하나씩 옮길 때 사용할 StringBuilder
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        list = new ArrayList<>();
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            rotate(bf.readLine());
        }//for end

        System.out.println(list.size());
    }

    //단어의 알파벳 한칸씩 rotate 시키면서 기존 list에 포함되는지 확인하는 method
    public static void rotate(String word) {
        //list가 비어있다면(첫번째 단어) list에 add
        if (list.isEmpty()) {
            list.add(word);
        } else {
            int length = word.length();
            //sb 초기화
            sb.setLength(0);
            sb.append(word);

            //list에 추가되었는지 확인하는 flag
            boolean isAdded = false;
            for (int i = 0; i < length; i++) {
                //현재 단어가 list에 포함되는지 확인
                if (list.contains(sb.toString())) {
                    isAdded = true;
                    break;
                }
                //현재 단어의 마지막 알파벳을 index 0에 복사
                sb.insert(0, sb.charAt(length-1));
                //마지막 알파벳 삭제
                sb.deleteCharAt(length);
            }//for end
            //모든 rotate를 거치고 list에 포함되지 않았으면 list에 추가
            if (!isAdded) list.add(word);
        }//if~else end
    }//rotate() end

}
