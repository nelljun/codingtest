package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Set<Integer> coinSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            coinSet.add(Integer.parseInt(bf.readLine()));
        }//for end

        int[] coins = coinSet.stream()
                                .sorted()
                                .mapToInt(Integer::intValue)
                                .toArray();

        int[] dp = new int[k+1];

        Arrays.fill(dp, Integer.MAX_VALUE-100);

        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
            }//for end
        }//for end

        System.out.println((dp[k]==Integer.MAX_VALUE-100)? -1 : dp[k]);
    }
}
