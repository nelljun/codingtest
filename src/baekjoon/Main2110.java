package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int house = Integer.parseInt(st.nextToken());
        int router = Integer.parseInt(st.nextToken());

        int[] houseArr = new int[house];

        for (int i = 0; i < house; i++) {
            houseArr[i] = Integer.parseInt(bf.readLine());
        }//for end

        Arrays.sort(houseArr);


    }
}
