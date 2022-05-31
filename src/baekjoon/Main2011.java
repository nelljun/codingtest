package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2011 {
    public static void main(String[] args) throws IOException {
        /**
         * dp[n] =
         * dp[n-1](맨 마지막 숫자가 0이 아닌 경우) + dp[n-2] (뒤 두 자리의 수가 10이상 26이하일 때)
         *
         * 0 앞자리가 1, 2가 아닐 경우 잘못된 암호
         */

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char[] charArr = bf.readLine().toCharArray();

        //맨 첫 숫자가 0일 때에도 잘못된 암호
        if (charArr[0]=='0') {
            System.out.println(0);
            return;
        }

        //dp 저장할 배열
        long[] dp = new long[charArr.length+1];
        //초기값 (dp[1]은 맨 첫 숫자가 0일 때를 제외했으므로 1로 초기화)
        dp[0] = 1;
        dp[1] = 1;

        //직전 자리의 숫자
        char prev = charArr[0];

        for (int i = 1; i < charArr.length; i++) {
            //현재 자릿수(i+1)에서 해석 가능한 경우의 수
            long cnt = 0L;
            //현재 숫자가 0이고 이전 숫자가 1 혹은 2가 아닐 때 잘못된 암호
            if (charArr[i]=='0' && !(prev == '1'||prev == '2')) {
                System.out.println(0);
                return;
            }
            //마지막 숫자가 0이 아닐 경우 + dp[n-1]
            if (charArr[i]!='0') {
                cnt += dp[i];
            }
            //마지막 두 자리의 숫자가 10이상 26이하일 경우 + dp[n-2]
            int lastTwo = (charArr[i-1]-'0')*10 + (charArr[i]-'0');
            if (lastTwo>=10 && lastTwo<=26) {
                cnt += dp[i-1];
            }
            //최종 cnt를 1000000으로 나눈 나머지로 dp[i+1] 갱신
            dp[i+1] = cnt%1000000;
            //직전 자리 숫자 갱신
            prev = charArr[i];
        }//for end

        System.out.println(dp[charArr.length]);
    }//main() end
}
