package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main1010 {
    //BigInteger solution
    public static void main1(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cnt; i++) {
            StringTokenizer tokenizer = new StringTokenizer(bf.readLine(), " ");
            BigInteger N = new BigInteger(tokenizer.nextToken());
            BigInteger M = new BigInteger(tokenizer.nextToken());

            BigInteger result = new BigInteger("1");

            for (int j = 0; j < N.intValue(); j++) {
                BigInteger nowBigInteger = BigInteger.valueOf(j);

                result = result.multiply(M.subtract(nowBigInteger));
                result = result.divide(nowBigInteger.add(BigInteger.valueOf(1)));
            }//for end

            sb.append(result).append('\n');
        }//for end

        System.out.println(sb);
    }

    //dp solution
    public static void main2(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[31][31];

        for (int i = 1; i <= 30; i++) {
            dp[1][i] = i;
        }//for end
        for (int j = 2; j <= 30; j++) {
            for (int k = j; k <= 30; k++) {
                for (int l = k; l >= j; l--) {
                    dp[j][k] += dp[j-1][l-1];
                }//for end

            }//for end
        }//for end
        for (int i = 0; i < cnt; i++) {
            StringTokenizer tokenizer = new StringTokenizer(bf.readLine(), " ");
            int N = Integer.parseInt(tokenizer.nextToken());
            int M = Integer.parseInt(tokenizer.nextToken());
            sb.append(dp[N][M]).append('\n');
        }

        System.out.println(sb);
    }

}
