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
            st = new StringTokenizer(bf.readLine());
            //gear index
            int gearIdx = Integer.parseInt(st.nextToken())-1;
            //gear 회전 방향
            int rotation = Integer.parseInt(st.nextToken());

            //각 톱니바퀴들끼리 같은 극인지 확인
            checkIfSame();

            //톱니바퀴 회전
            rotate(gearIdx, rotation);

            //왼쪽으로 이동
            int gearIdxLeft = gearIdx-1;
            //회전 방향 반대로
            int rotationLeft = -rotation;

            //첫 번째 톱니바퀴까지
            while (gearIdxLeft>=0) {
                //다른 극일 때
                if (!isSame[gearIdxLeft]) {
                    //회전
                    rotate(gearIdxLeft, rotationLeft);
                    //왼쪽으로 하나 이동
                    gearIdxLeft--;
                    //회전 방향 반대로
                    rotationLeft = -rotationLeft;
                } else {
                    //이동한 현재 톱니바퀴가 회전하지 않으면
                    //그 다음 톱니바퀴부터도 회전하지 않으므로 break
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
