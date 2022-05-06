package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1037 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bf.readLine());

        int[] arr = new int[num];
        int index = 0;

        StringTokenizer st = new StringTokenizer(bf.readLine());

        while (st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }//while end

        Arrays.sort(arr);

        System.out.println(arr[0] * arr[num-1]);
    }
}
