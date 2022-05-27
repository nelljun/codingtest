package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15486 {
    static int n;
    static int[] dayArr;
    static int[] payArr;
    static boolean[] isChecked;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        dayArr = new int[n];
        payArr = new int[n];
        isChecked = new boolean[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            dayArr[i] = Integer.parseInt(st.nextToken());
            payArr[i] = Integer.parseInt(st.nextToken());
        }//for end

    }

    public static void dfs(int index) {

        for (int i = index; i < n; i++) {

        }//for end

    }//solution() end
}
