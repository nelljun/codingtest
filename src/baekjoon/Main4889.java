package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int index = 1;

        while (true) {
            String str = bf.readLine();
            int length = str.length();

            int answer = 0;

            if (str.contains("-")) {
                break;
            }//if end

            //stack 초기화
            stk.clear();

            for (int i = 0; i < length; i++) {
                char now = str.charAt(i);

                switch (now) {
                    case '{' :
                        stk.push(now);
                        break;
                    case '}' :
                        if (stk.isEmpty()) {
                            answer++;
                            stk.push('{');
                        } else {
                            stk.pop();
                        }//if~else end
                        break;
                }
            }//for end

            int left = stk.size();

            answer += (left / 2);

            sb.append(index)
                .append(". ")
                .append(answer)
                .append("\n");

            index++;
        }//while end

        System.out.println(sb);
    }
}
