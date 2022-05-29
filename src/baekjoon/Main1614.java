package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1614 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        long maxNum = 0L;

        int sickFinger = Integer.parseInt(bf.readLine());
        int maxCnt = Integer.parseInt(bf.readLine());

        if (sickFinger==1 || sickFinger==5) {
            //엄지, 새끼
            maxNum += (8 * (long)maxCnt) + sickFinger-1;
        } else {
            //나머지 손가락
            maxNum += 8 * (((long)maxCnt+1)/2);

            if (maxCnt%2==0) {
                maxNum += sickFinger-1;
            } else {
                maxNum -= sickFinger-1;
            }
        }

        System.out.print(maxNum);

    }
}
