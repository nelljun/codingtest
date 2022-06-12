package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main1660 {
    /**
     * 1. N개 이하의 최대 개수로 만들 수 있는 사면체를 만든다.
     * 2. 남은 개수 이하의 최대 개수로 만들 수 있는 사면체를 만든다.
     * 3. 남은 개수가 0이 될 때까지 2의 과정을 반복한다.
     */

    static List<Integer> cntList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int totalCnt = Integer.parseInt(bf.readLine());

//        int num = 1;
//        int sum = 0;
//        while (sum<=300000) {
//            sum += (num*(num+1))/2;
//            num++;
//        }//while end
//
//        System.out.println("num = " + num);

        int num = 1;
        int sum = 0;
        int totalSum = 0;

        int index = 0;

        int[] cntArr = new int[122];

        while (true) {
            sum += num++;
            totalSum += sum;

            if (totalSum<=totalCnt) {
                cntArr[index++] = totalSum;
            } else {
                break;
            }
        }//while end

        int[] dp = new int[totalCnt+1];

        for (int i = 0; i <= totalCnt; i++) {
            dp[i] = i;
        }//for end

        for (int i = 2; i <= totalCnt; i++) {
            for (int j = 0; j < cntList.size(); j++) {
                if (i>=cntList.get(j)) {
                    dp[i] = Math.min(dp[i], dp[i - cntList.get(j)] + 1);
                }
            }//for end
        }//for end

        System.out.println(dp[totalCnt]);

    }

    public static void fillCntList(int totalCnt) {
        int totalSum = 0;
        int sum = 0;
        int num = 1;

        while (true) {
            sum += num++;
            totalSum += sum;

            if (totalSum<=totalCnt) {
                cntList.add(totalSum);
            } else {
                break;
            }
        }//while end
    }

}
