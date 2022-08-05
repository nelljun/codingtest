package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2805 {
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tree = new int[N];

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }//for end

        int result = binarySearch(0, 1000000000, M);

        System.out.println(result);
    }

    private static int binarySearch(int left, int right, int M){
        int answer = 0;

        while (left<=right) {
            int mid = (left + right) / 2;
            int leftSum = leftSum(mid);

            if (leftSum < M) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = Math.max(answer, mid);
            }//if~else end
        }//while end

        return answer;
    }

    private static int leftSum(int criteria) {
        int sum = 0;

        for (int i = 0; i < tree.length; i++) {
            if (tree[i] > criteria) {
                sum += (tree[i] - criteria);
            }//if end
        }//for end

        return sum;
    }
}
