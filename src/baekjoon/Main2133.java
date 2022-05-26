package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bf.readLine());

        long[] dp1 = new long[num+1];
        long[] dp2 = new long[num+1];

        if (num>=2) {
            dp1[2] = 3;
            dp2[2] = 1;

            for (int i = 4; i <= num; i+=2) {
                dp1[i] = dp1[i-2] * 3 + (2 * dp2[i-2]);
                dp2[i] = dp1[i-2] + dp2[i-2];
            }//for end
        }


        System.out.println(dp1[num]);
    }

}
