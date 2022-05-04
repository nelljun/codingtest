package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main1010 {

    public static void main(String[] args) throws IOException {

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

}
