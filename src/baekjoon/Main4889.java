package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int index = 1;

        while (true) {
            String str = bf.readLine();

            if (str.contains("-")) {
                break;
            }//if end

            int count = count(str);

            sb.append(index)
                .append(". ")
                .append(count)
                .append("\n");

            index++;
        }//while end

        System.out.println(sb);
    }

    private static int count(String str) {
        int answer = 0;
        int length = str.length();

        int num = 0;

        for (int i = 0; i < length; i++) {
            char now = str.charAt(i);

            switch (now) {
                case '{' :
                    num++;
                    break;
                case '}' :
                    if (num==0) {
                        answer++;
                        num++;
                    } else {
                        num--;
                    }//if~else end
                    break;
            }//switch case end
        }//for end

        answer += (num / 2);

        return answer;
    }//count() end

}
