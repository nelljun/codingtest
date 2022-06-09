package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(bf.readLine());

        StringTokenizer st;
        for (int i = 0; i < test; i++) {
            st = new StringTokenizer(bf.readLine(), " ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            sb.append(getCnt(to-from)).append("\n");
        }//for end

        System.out.println(sb);
    }

    public static int getCnt(int dist) {
        int n = (int)Math.sqrt(dist);

        if (n*n == dist) {
            return 2*n-1;
        } else if (n*n<dist && dist<=n*(n+1)) {
            return 2*n;
        }

        return 2*n+1;
    }
}
