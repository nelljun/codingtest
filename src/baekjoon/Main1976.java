package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1976 {
    static int[] rootArr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        rootArr = new int[N];

        for (int i = 0; i < N; i++) {
            rootArr[i] = i;
        }//for end

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken())==1) {
                    union(i, j);
                }
            }//for end
        }//for end

        st = new StringTokenizer(bf.readLine());

        int root = find(Integer.parseInt(st.nextToken())-1);

        for (int i = 1; i < M; i++) {
            int nowCity = Integer.parseInt(st.nextToken())-1;
            int nowRoot = find(nowCity);

            if (nowRoot!=root) {
                System.out.println("NO");
                return;
            }//if end
        }//for end

        System.out.println("YES");
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x<y) {
            rootArr[y] = x;
        } else {
            rootArr[x] = y;
        }
    }//solution() end

    //root 찾기
    public static int find(int city) {
        if (rootArr[city] == city) {
            return city;
        }

        return find(rootArr[city]);
    }
}
