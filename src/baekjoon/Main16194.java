package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] cardArr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            cardArr[i] = Integer.parseInt(st.nextToken());
        }//for end

        //dp[i] : 카드 i개의 최소 금액
        int[] dp = new int[N+1];


        /**
         * i개 든 카드팩
         * vs (i-1)개 카드 최소 금액 + 1개 카드 최소 금액
         * vs (i-2)개 카드 최소 금액 + 2개 카드 최소 금액
         * ...
         * vs (i+1)/2개 카드 최소 금액 + 나머지 카드 개수 최소 금액
         *
         * 이 중 최솟값이 dp[i]
         */
        for (int i = 1; i <= N; i++) {
            int end = (i+1)/2;

            //i개 든 카드팩
            dp[i] = cardArr[i];

            //i-1 ~ (i+1)/2까지 두 그룹의 카드를 구하는 최소 금액의 합들의 최솟값이 dp[i]
            for (int j = i-1; j >= end; j--) {
                int temp = dp[j] + dp[i-j];
                dp[i] = Math.min(dp[i], temp);
            }//for end
        }//for end

        System.out.println(dp[N]);
    }

}
