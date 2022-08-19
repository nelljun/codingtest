package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        String S = bf.readLine();

        String target = makeTarget(N);

        int answer = 0;
        
        //절반 풀이
        for (int i = 0; i < M-(2*N+1); i++) {
            if (S.charAt(i) == 'I') {
                if (target.equals(S.substring(i, i+(2*N+1)))) {
                    answer++;
                }//if end
            }//if end
        }//for end
        
        //다른 풀이

        System.out.println(answer);
    }

    private static String makeTarget(int N) {
        StringBuilder sb = new StringBuilder();

        sb.append("I");

        for (int i = 0; i < N; i++) {
            sb.append("OI");
        }//for end

        return sb.toString();
    }
}
