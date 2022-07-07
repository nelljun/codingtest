package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] bookArr = new int[N];

        st = new StringTokenizer(bf.readLine(), " ");

        //양수 개수
        int positive = 0;
        //음수 개수
        int negative = 0;

        for (int i = 0; i < N; i++) {
            int book = Integer.parseInt(st.nextToken());
            bookArr[i] = book;

            if(book<0) {
                negative++;
            } else {
                positive++;
            }
        }//for end

        //책 위치 오름차순 정렬
        Arrays.sort(bookArr);

        /**
         * 1. 각 부호에서 끝에서부터 최대 갯수로 그룹핑(음수:왼쪽부터, 양수:오른쪽부터) - 마지막 그룹은 남은 갯수만큼만 (다른 부호끼리는 그룹x)
         * 2. 각 그룹에서 절대값이 가장 큰 수의 2배만큼 이동거리 증가. 단, 그룹 대표 절대값 중 가장 큰 수는 1번만
         */
        int answer = 0;

        //음수
        int negativeIdx = 0;
        while (negativeIdx < negative) {
            answer -= bookArr[negativeIdx] * 2;
            negativeIdx += M;
        }//while end


        //양수
        int positiveIdx = N-1;
        while ((N-positive) <= positiveIdx) {
            answer += bookArr[positiveIdx] * 2;
            positiveIdx -= M;
        }//while end

        //양수 음수 중 가장 큰 절대값 빼주기
        answer = (-bookArr[0] < bookArr[N-1])? answer - bookArr[N-1] : answer + bookArr[0];

        System.out.println(answer);
    }
}
