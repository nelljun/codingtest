package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2565 {
    static class Line {
        int left;
        int right;

        public Line(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    static List<Line> lineList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        StringTokenizer st;
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            lineList.add(new Line(left, right));
        }//for end

        //left 오름차순으로 정렬
        Collections.sort(lineList, new Comparator<Line>() {
            @Override
            public int compare(Line l1, Line l2) {
                return Integer.compare(l1.left, l2.left);
            }
        });

        int prevRight = 0;
        int answer = 0;

        for (int i = 0; i < cnt; i++) {
            Line nowLine = lineList.get(i);

            if (prevRight<nowLine.right) {
                prevRight = nowLine.right;
            } else {
                //현재 라인 지우는 경우 vs 현재 라인 유지하고 이전까지 라인 중 현재 라인보다 right이 큰 라인들 지우는 경우 비교
                int countOverRight = countOverRight(i, nowLine.right);
                if (answer+1 < countOverRight) {
                    //현재 라인 지우기
                    answer++;
                } else {
                    //현재 라인 유지하면서 이전 라인 중 현재 라인보다 right이 큰 라인 지우기
                    prevRight = nowLine.right;
                    answer = countOverRight;
                }
            }
        }//for end

        System.out.println(answer);
    }

    public static int countOverRight(int index, int nowRight) {
        int cnt = 0;

        for (int i = 0; i < index; i++) {
            if (lineList.get(i).right > nowRight) cnt++;
        }//for end

        return cnt;
    }//solution() end
}
