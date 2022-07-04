package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19539 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //전체 사과나무 개수
        int N = Integer.parseInt(bf.readLine());


        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int totalSum = 0;
        int spaceForTwo = 0;

        for (int i = 0; i < N; i++) {
            int tree = Integer.parseInt(st.nextToken());

            totalSum += tree;
            spaceForTwo += tree/2;
        }//for end

        String answer = "";

        if(totalSum%3!=0) {
            answer = "NO";
        } else {
            int times = totalSum/3;
            answer = (times <= spaceForTwo)? "YES" : "NO";
        }

        System.out.println(answer);
    }
}
