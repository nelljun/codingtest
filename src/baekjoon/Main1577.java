package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1577 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //점 배열
        long[][] dp = new long[N+1][M+1];

        //선 배열 (1 : 부실공사)
        //가로 선
        int[][] horizontal = new int[N][M+1];
        //세로 선
        int[][] vertical = new int[N+1][M];

        int K = Integer.parseInt(bf.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (y1==y2) {
                //가로 도로
                horizontal[Math.min(x1, x2)][y1] = 1;
            } else {
                //세로 도로
                vertical[x1][Math.min(y1, y2)] = 1;
            }//if~else end
        }//for end

        //가로 (세로값 0인 지점) 1로 초기화
        for (int i = 1; i <= N; i++) {
            //부실공사 도로면 그 뒤 다 0으로 초기화
            if (horizontal[i-1][0] == 1) break;

            dp[i][0] = 1L;
        }//for end

        //세로 (가로값 0인 지점) 1로 초기화
        for (int i = 1; i <= M; i++) {
            //부실공사 도로면 그 뒤 다 0으로 초기화
            if (vertical[0][i-1] == 1) break;

            dp[0][i] = 1L;
        }//for end

        //이동
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];

                //가로 도로 부실공사 여부
                if (horizontal[i-1][j] == 1) {
                    dp[i][j] -= dp[i-1][j];
                }

                //세로 도로 부실공사 여부
                if (vertical[i][j-1] == 1) {
                    dp[i][j] -= dp[i][j-1];
                }
            }//for end
        }//for end

        System.out.println(dp[N][M]);
    }
}
