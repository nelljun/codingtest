package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main9081 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int totalCnt = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();

        ArrayList<Character> charList = new ArrayList<>();
        for (int i = 0; i < totalCnt; i++) {
            charList.clear();

            String word = bf.readLine();
            int length = word.length();

            for (int j = 0; j < length; j++) {
                charList.add(word.charAt(i));
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

                    charList.remove(j-1);
                    charList.add(j-1, greaterMin);
                    charList.add(prev);


                    break;
                }
            }//for end

            /**
             * 1. 뒤에서부터 바로 앞 요소와 비교한다.
             * 1-1 바로 앞 요소가 더 크거나 같으면 다음 요소로 넘어간다.
             * 1-2 바로 앞 요소가 더 작으면 아래 과정을 진행한다.
             *
             * 2. 바로 앞 요소를, 여태까지 지나왔던 요소들 중 바로 앞 요소보다 큰 수 중 최솟값으로 바꾼다.
             * 3. 그 뒤는 최소값으로 만든다.
             */

        }//for end
    }
}
