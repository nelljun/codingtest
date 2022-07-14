package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine(), " ");

        int[] students = new int[N];

        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }//for end

        int[] diffArr = new int[N-1];

        for (int i = 0; i < N - 1; i++) {
            diffArr[i] = (students[i+1] - students[i]);
        }//for end



    }
}
