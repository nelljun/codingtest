package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1292 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int sum = 0;
        int num = 1;
        int first = 0;
        int last = 0;

        int result = 0;

        while (true) {
            sum += num;
            if (sum>=A) {
                first = num+1;

            }
            if (sum>=B) {
                last = num+1;
                break;
            }
        }//while end

    }
}
