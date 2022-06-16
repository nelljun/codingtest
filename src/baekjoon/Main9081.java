package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main9081 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int totalCnt = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();

        LinkedList<Character> charList = new LinkedList<>();

        /**
         * 1. 뒤에서부터 바로 앞 요소와 비교한다.
         * 1-1 바로 앞 요소가 더 크거나 같으면 다음 요소로 넘어간다.
         * 1-2 바로 앞 요소가 더 작으면 아래 과정을 진행한다.
         *
         * 2. 바로 앞 요소를, 여태까지 지나왔던 요소들 중 바로 앞 요소보다 큰 수 중 최솟값으로 바꾼다.
         * 3. 그 뒤는 오름차순으로 정렬
         */

        for (int i = 0; i < totalCnt; i++) {
            //list 초기화
            charList.clear();

            String word = bf.readLine();
            int length = word.length();

            //문자를 list에 저장
            for (int j = 0; j < length; j++) {
                charList.add(word.charAt(j));
            }//for end

            for (int j = length-1; j >= 1; j--) {
                Character now = charList.get(j);
                Character prev = charList.get(j-1);

                if (now>prev) {
                    //prev보다 큰 수 중 최솟값 찾기
                    Character greaterMin = now;
                    int greaterMinIdx = j;

                    for (int k = j+1; k < length; k++) {
                        Character c = charList.get(k);
                        if (c>prev && greaterMin>c) {
                            greaterMin = c;
                            greaterMinIdx = k;
                        }//if end
                    }//for end

                    //prev 위치에 위에서 찾은 prev보다 큰 최솟값 넣기
                    charList.remove(greaterMinIdx);
                    charList.remove(j-1);
                    charList.add(j-1, greaterMin);
                    charList.add(prev);

                    //j~length-1 위치에 있는 문자들을 오름차순으로 정렬
                    Collections.sort(charList.subList(j, length));

                    break;
                }//if end
            }//for end

            //정렬한 list 순서대로 문자 출력
            for (Character character : charList) {
                sb.append(character);
            }//for end

            //줄바꿈
            sb.append("\n");
        }//for end

        System.out.println(sb);
    }
}
