package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1018 {

    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bf.readLine(), " ");

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }//for end
        }//for end

        int min = 64;

        for (int i = 0; i < N+1 - 8; i++) {
            for (int j = 0; j < M+1 - 8; j++) {
                min = Math.min(min, count(i, j));
            }//for end
        }//for end

        System.out.println(min);
    }

    public static int count(int row, int col) {
        //행+열이 짝수일 때 W, 홀수일 때 B인 체스판을 만든다.
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int newRow = row+i;
                int newCol = col+j;
                if ((newRow+newCol)%2==0) {
                    //합 짝수
                    if (board[newRow][newCol]=='B') {
                        //W로 색칠한다.
                        cnt++;
                    }
                } else {
                    //합 홀수
                    if (board[newRow][newCol]=='W') {
                        //B로 색칠한다.
                        cnt++;
                    }
                }
            }//for end
        }//for end

        return (cnt<32)? cnt : 64-cnt;
    }//count() end

}
