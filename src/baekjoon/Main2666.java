package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2666 {
    static int[] openedDoor = new int[2];
    static int[] doorArr;
    static int minMoveCnt = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int totalCnt = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        openedDoor[0] = Integer.parseInt(st.nextToken());
        openedDoor[1] = Integer.parseInt(st.nextToken());

        int cnt = Integer.parseInt(bf.readLine());
        doorArr = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            doorArr[i] = Integer.parseInt(bf.readLine());
        }//for end

        dfs(0, 0);

        System.out.println(minMoveCnt);
    }

    public static void dfs(int nowSum, int nowIndex) {
        if (nowIndex == doorArr.length) {
            minMoveCnt = Math.min(minMoveCnt, nowSum);
            return;
        }

        for (int i = 0; i < 2; i++) {
            int temp = openedDoor[i];
            openedDoor[i] = doorArr[nowIndex];
            dfs(nowSum + Math.abs(doorArr[nowIndex] - temp), nowIndex+1);
            openedDoor[i] = temp;
        }//for end
    }

    static int[][][] dp;

    public static void main2(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int totalCnt = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        openedDoor[0] = Integer.parseInt(st.nextToken());
        openedDoor[1] = Integer.parseInt(st.nextToken());

        int cnt = Integer.parseInt(bf.readLine());
        doorArr = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            doorArr[i] = Integer.parseInt(bf.readLine());
        }//for end

        dp = new int[21][21][21];

        System.out.println(dfs2(0, openedDoor[0], openedDoor[1]));
    }

    public static int dfs2(int nowIndex, int firstPos, int secondPos) {
        if (nowIndex==doorArr.length) {
            return 0;
        }

        if (dp[nowIndex][firstPos][secondPos]!=0) return dp[nowIndex][firstPos][secondPos];

        dp[nowIndex][firstPos][secondPos]
                = Math.min(dfs2(nowIndex+1, doorArr[nowIndex], secondPos) + Math.abs(firstPos - doorArr[nowIndex]),
                           dfs2(nowIndex+1, firstPos, doorArr[nowIndex]) + Math.abs(secondPos - doorArr[nowIndex]));

        return dp[nowIndex][firstPos][secondPos];
    }
}
