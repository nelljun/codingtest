package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] boxArr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            boxArr[i] = Integer.parseInt(st.nextToken());
        }//for end

        //dp[i] : i번째 상자까지 한 번에 넣을 수 있는 최대의 상자 개수
        int[] dp = new int[N+1];
        dp[1] = 1;

        /**
         * dp[i] : 1 ~ i-1까지 박스 중 i번째 박스보다 크기가 작은 박스들의 dp 값 중 가장 큰 값 + 1
         */
        int max = 0;
        for (int i = 2; i <= N; i++) {
            int tempMax = 0;
            for (int j = 1; j < i; j++) {
                if (boxArr[j]<boxArr[i]) {
                    tempMax = Math.max(tempMax, dp[j]);
                }
            }//for end
            dp[i] = tempMax + 1;
            max = Math.max(max, dp[i]);
        }//for end

        System.out.println(max);
    }
}
