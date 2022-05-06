package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1059 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bf.readLine());

        int[] arr = new int[num];
        int index = 0;

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(bf.readLine());

        while (st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }//while end

        Arrays.sort(arr);
        int i = 0;
        for (; i < num; i++) {
            if (arr[i]==n) {
                System.out.println(0);
                return;
            }
            if (arr[i]>n) break;
        }//for end

        int left = (i==0)? 0 : arr[i-1];
        int right = arr[i];

        System.out.println((n-left)*(right-n)-1);
    }
}
