package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1309 {
    //dp
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] dp = new int[N+1];

        dp[1] = 3;

        if (N > 1) {
            dp[2] = 7;

            for (int i = 3; i < N + 1; i++) {
                /**
                 * 첫 번째. dp[i-1] : 직전 경우의 수
                 * 두 번째. 2*dp[i-2] + (dp[i-1] - dp[i-2]) : 새로 더해진 2칸의 우리를 포함한 새로운 경우의 수
                 *
                 * 첫 번째. + 두 번재. = 2 * dp[i-1] + dp[i-2];
                 */
                dp[i] = 2 * dp[i - 1] + dp[i - 2];
                dp[i] %= 9901;
            }//for end
        }

        System.out.println(dp[N]);
    }
}
