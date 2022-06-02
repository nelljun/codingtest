package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11047 {
    public static void main(String[] args) throws IOException {
        //N종류
        //target value : K

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(bf.readLine());
        }//for end

        int sum = 0;
        int cnt = 0;

        for (int i = N-1; i >= 0; i--) {
            if (K>=coins[i]) {
                cnt += K/coins[i];
                K %= coins[i];
            }
        }//for end

        System.out.println(cnt);
    }
}
