package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1012 {
    static class Point {
        int row;
        int col;
        boolean isChecked;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static List<Point> pointList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        int[] answerArr = new int[T];

        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int cabCnt = Integer.parseInt(st.nextToken());

            if (cabCnt==1) {
                answerArr[i] = 1;
                continue;
            }

            for (int j = 0; j < cabCnt; j++) {
                st = new StringTokenizer(bf.readLine(), " ");
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());

                pointList.add(new Point(row, col));
            }//for end

            int bugCnt = 0;
            int tempCabCnt = 0;

            for (int j = 0; j < cabCnt; j++) {
                if (tempCabCnt<cabCnt) {
                    if (!pointList.get(j).isChecked) {
                        bugCnt++;
                        tempCabCnt += bfs(pointList.get(j));
                    }
                } else {
                    break;
                }
            }//for end

            answerArr[i] = bugCnt;
        }//for end

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            sb.append(answerArr[i]).append("\n");
        }//for end

        System.out.println(sb);
    }

    public static int bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();

        int result = 0;

        queue.add(point);
        result++;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < pointList.size(); i++) {
                if (!pointList.get(i).isChecked) {
                    Point target = pointList.get(i);

                    if (isAdjacent(now, target)) {
                        queue.add(target);
                        result++;
                    }
                }
            }//for end
        }//while end

        return result;
    }

    public static boolean isAdjacent(Point now, Point target) {
        int rowGap = now.row-target.row;
        int colGap = now.col-target.col;

        if ((rowGap==0 && (colGap==1 || colGap==-1))
                || (colGap==0 && (rowGap==1 || rowGap==-1))) {
            return true;
        }

        return false;
    }
}
