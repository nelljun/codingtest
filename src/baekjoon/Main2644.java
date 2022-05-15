package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2644 {

    static int[] parentArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        parentArr = new int[n+1];

        for (int i = 0; i < n; i++) {
            parentArr[i] = i;
        }//for end

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int target1 = Integer.parseInt(st.nextToken());
        int target2 = Integer.parseInt(st.nextToken());

        int cnt = Integer.parseInt(bf.readLine());

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            parentArr[child] = parent;
        }//for end

        findRootPath(target1);
        String rootPath1 = sb.toString();
        String[] split1 = rootPath1.split("/");
        int length1 = split1.length;

        sb.setLength(0);

        findRootPath(target2);
        String rootPath2 = sb.toString();
        String[] split2 = rootPath2.split("/");
        int length2 = split2.length;

        int minLength = Math.min(length1, length2);

        int answer = -1;

        if (split1[0].equals(split2[0])) {
            int i = 1;
            for (; i < minLength; i++) {
                if (!split1[i].equals(split2[i])) break;
            }//for end
            answer += (length1-i)+(length2-i)+1;
        }

        System.out.println(answer);
    }


    public static void findRootPath(int child) {
        sb.insert(0, "/").insert(0, child);

        if (parentArr[child]==child) {
            return;
        }

        findRootPath(parentArr[child]);
    }
}
