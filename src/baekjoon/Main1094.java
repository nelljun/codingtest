package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(bf.readLine());

        int cnt = 0;

        while (x!=0) {
            if (x%2==1) cnt++;

            x /= 2;
        }//while end

        System.out.println(cnt);

    }
}
