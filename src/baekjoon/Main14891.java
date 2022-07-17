package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main14891 {
    static ArrayList<LinkedList<Integer>> gearList = new ArrayList<>();
    static boolean[] isSame = new boolean[3];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            LinkedList<Integer> gear = new LinkedList<>();
            String gearStr = bf.readLine();

            for (int j = 0; j < 8; j++) {
                gear.add(gearStr.charAt(j)-'0');
            }//for end

            gearList.add(gear);
        }//for end



        int rotationCnt = Integer.parseInt(bf.readLine());

        StringTokenizer st;
        for (int i = 0; i < rotationCnt; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int gearIdx = Integer.parseInt(st.nextToken())-1;
            int rotation = Integer.parseInt(st.nextToken());

            //각 톱니바퀴들끼리 같은 극인지 확인
            checkIfSame();

            //톱니바퀴 회전
            rotate(gearIdx, rotation);

            //왼쪽으로 이동
            int gearIdxLeft = gearIdx-1;
            int rotationLeft = -rotation;

            while (gearIdxLeft>=0) {
                if (!isSame[gearIdxLeft]) {
                    rotate(gearIdxLeft, rotationLeft);
                    gearIdxLeft--;
                    rotationLeft = -rotationLeft;
                } else {
                    break;
                }
            }//while end

            // 오른쪽으로 이동
            int gearIdxRight = gearIdx+1;
            int rotationRight = -rotation;

            while (gearIdxRight<4) {
                if (!isSame[gearIdxRight-1]) {
                    rotate(gearIdxRight, rotationRight);
                    gearIdxRight++;
                    rotationRight = -rotationRight;
                } else {
                    break;
                }
            }//while end
        }//for end

        int score = 0;

        for (int i = 0; i < 4; i++) {
            score += gearList.get(i).get(0).equals(0)? 0 : (int)Math.pow(2, i);
        }//for end

        System.out.println(score);
    }

    public static void checkIfSame() {
        Integer first = gearList.get(0).get(2);
        Integer second = gearList.get(1).get(6);
        Integer third = gearList.get(1).get(2);
        Integer fourth = gearList.get(2).get(6);
        Integer fifth = gearList.get(2).get(2);
        Integer sixth = gearList.get(3).get(6);

        isSame[0] = (first.equals(second));
        isSame[1] = (third.equals(fourth));
        isSame[2] = (fifth.equals(sixth));
    }

    public static void rotate(int gearIdx, int rotation) {
        LinkedList<Integer> gear = gearList.get(gearIdx);

        if (rotation == 1) {
            //시계 방향
            Integer last = gear.removeLast();
            gear.addFirst(last);
        } else {
            Integer first = gear.removeFirst();
            gear.addLast(first);
        }
    }//rotate() end

}
