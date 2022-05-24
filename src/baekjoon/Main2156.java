package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2156 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //전체 와인잔 개수
        int totalCnt = Integer.parseInt(bf.readLine());
        //와인 양을 저장할 배열
        int[] glassArr = new int[totalCnt+1];

        for (int i = 1; i <= totalCnt; i++) {
            glassArr[i] = Integer.parseInt(bf.readLine());
        }//for end

        //중간값 저장할 dp 배열
        int dp[][] = new int[totalCnt+1][3];

        //3가지 경우에 대한 계산
        for (int i = 1; i <= totalCnt; i++) {
            dp[i][0] = maxOfThree(dp[i-1][0], dp[i-1][1], dp[i-1][2]);
            dp[i][1] = dp[i-1][0] + glassArr[i];
            dp[i][2] = dp[i-1][1] + glassArr[i];
        }//for end

        //최종적으로 dp[마지막 와인]에서의 3가지 경우 중 최댓값을 출력
        int max = maxOfThree(dp[totalCnt][0], dp[totalCnt][1], dp[totalCnt][2]);

        System.out.println(max);
    }

    //3가지 숫자 중 최댓값 리턴하는 메소드
    public static int maxOfThree(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

}
