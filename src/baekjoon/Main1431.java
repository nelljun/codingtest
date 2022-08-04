package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        ArrayList<String> serialList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            serialList.add(bf.readLine());
        }//for end

        serialList.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int length1 = s1.length();
                int length2 = s2.length();

                if (length1 != length2) {
                    return Integer.compare(length1, length2);
                } else {
                    int sum1 = sum(s1);
                    int sum2 = sum(s2);

                    if (sum1 != sum2) {
                        return Integer.compare(sum1, sum2);
                    } else {
                        return s1.compareTo(s2);
                    }
                }//if~else end
            }
        });

        StringBuilder sb = new StringBuilder();

        serialList.forEach(s -> sb.append(s).append("\n"));

        System.out.println(sb);
    }//main() end

    //문자열 속 숫자 합
    private static int sum(String str) {
        int length = str.length();
        int sum = 0;

        for (int i = 0; i < length; i++) {
            char now = str.charAt(i);

            if (now >= '1' && now <= '9') {
                sum += (now - '0');
            }//if end
        }//for end

        return sum;
    }


}
