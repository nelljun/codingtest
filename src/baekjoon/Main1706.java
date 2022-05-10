package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main1706 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<String> wordList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int rowLeng = Integer.parseInt(st.nextToken());
        int colLeng = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = null;

        char[][] board = new char[rowLeng][colLeng];

        for (int i = 0; i < rowLeng; i++) {
            String str = bf.readLine();

            st2 = new StringTokenizer(str, "#");
            //가로 단어
            while (st2.hasMoreTokens()) {
                String token = st2.nextToken();
                if (token.length()>=2) {
                    wordList.add(token);
                }
            }//while end
            for (int j = 0; j < colLeng; j++) {
                board[i][j] = str.charAt(j);
            }//for end
        }//for end

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < colLeng; i++) {
            sb.setLength(0);
            for (int j = 0; j < rowLeng; j++) {
                if (board[j][i]!='#') {
                    sb.append(board[j][i]);
                } else {
                    if (sb.length()>=2) {
                        wordList.add(sb.toString());
                    }
                    sb.setLength(0);
                }
            }//for end
            if (sb.length()>=2) {
                wordList.add(sb.toString());
            }
        }//for end

        Collections.sort(wordList);

        System.out.println(wordList.get(0));
    }

}
