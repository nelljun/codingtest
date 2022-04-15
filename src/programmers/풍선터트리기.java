package src.programmers;

import java.util.Arrays;

public class 풍선터트리기 {
    public static void main(String[] args) {
        int[] a = {9, -1, -1};
        solution(a);
    }


    public static int solution(int[] a) {
        int length = a.length;
        //길이 1이면 전부 가능
        if (length == 1) return length;

        int count = 2; //양 끝은 무조건 가능

        //처음->끝 방향으로 최솟값
        int[] minArrFromFirst = new int[length];
        //끝->처음 방향으로 최솟값
        int[] minArrFromLast = new int[length];

        minArrFromFirst[0] = a[0];
        minArrFromLast[length-1] = a[length-1];

        for (int i = 1; i < length - 1; i++) {
            minArrFromFirst[i] = Math.min(a[i], minArrFromFirst[i-1]);
        }//for end
        for (int i = length-2; i >= 0; i--) {
            minArrFromLast[i] = Math.min(a[i], minArrFromLast[i+1]);
        }//for end

        //중간
        for (int i = 1; i < length - 1; i++) {
            //양 옆 최솟값 2개보다 전부 크지만 않으면 살아남을 수 있다.
            if (a[i] < minArrFromFirst[i-1] || a[i] < minArrFromLast[i+1]) count++;
        }//for end

        return count;
    }//solution() end
}