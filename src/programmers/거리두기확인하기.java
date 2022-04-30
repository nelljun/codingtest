package src.programmers;

import java.util.ArrayList;
import java.util.List;

public class 거리두기확인하기 {
    public static void main(String[] args) {
        String[][] places = {{"POOOP","OXXOX","OPXPX","OOXOX","POXXP"},
                {"POOPX","OXPXP","PXXXO","OXXXO","OOOPP"},
                {"PXOPX","OXOXP","OXPOX","OXXOP","PXPOX"},
                {"OOOXX","XOOOX","OOOXX","OXOOX","OOOOO"},
                {"PXPXP","XPXPX","PXPXP","XPXPX","PXPXP"}};

        solution(places);
    }


    public static void solution(String[][] places) {
        int[] answer = new int[5];
        char[][] map = new char[5][5];
        List<int[]> pLocList = new ArrayList<>();


        for (int i = 0; i < 5; i++) {
            pLocList.clear();
            //map 채우기, p 위치 저장
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    char now = places[i][j].charAt(k);

                    map[j][k] = now;

                    if (now=='P') {
                        pLocList.add(new int[]{j, k});
                    }
                }//for end
            }//for end

            boolean isFinished = false;
            //모든 p끼리 check
            int numOfP = pLocList.size();
            for (int j = 0; j < numOfP-1; j++) {
                for (int k = 1; k < numOfP; k++) {
                    if (!check(pLocList.get(j), pLocList.get(k), map)) {
                        isFinished = true;
                        break;
                    }
                }//for end
                if (isFinished) break;
            }//for end
            if (!isFinished) answer[i] = 1;
        }//for end
    }//solution() end

    //두 지원자가 거리두기가 지켜졌는지 확인하는 method
    public static boolean check(int[] loc1, int[] loc2, char[][] map) {
        int rowMax = -1;
        int rowMin = -1;
        int colMax = -1;
        int colMin = -1;

        if (loc1[0]>=loc2[0]) {
            rowMax = loc1[0];
            rowMin = loc2[0];
        } else {
            rowMax = loc2[0];
            rowMin = loc1[0];
        }
        if (loc1[1]>=loc2[1]) {
            colMax = loc1[1];
            colMin = loc2[1];
        } else {
            colMax = loc2[1];
            colMin = loc1[1];
        }

        int rowCal = rowMax-rowMin;
        int colCal = colMax-colMin;
        //맨허튼 거리
        int mDist = rowCal + colCal;

        /**
         * 맨허튼 거리가 1이면 무조건 false
         * 2이면, 두 지원자 사이가 파티션일 때만 true, 아니면 false다.
         * 3이상이면, 무조건 true
         */
        if (mDist==1) {
            return false;
        } else if (mDist==2) {
            //같은 가로선, 세로선일 땐 중간 위치만 확인
            /**
             *  1 __ 2 이거나,
             *  1
             *  __
             *  2 인 경우
             */
            if (rowMax==rowMin) {
                if(map[rowMax][colMin+1]!='X') return false;
            } else if (colMax==colMin) {
                if (map[rowMin+1][colMax]!='X') return false;
            } else if (rowMax!=rowMin && colMax!=colMin) {
                //두 지원자가 대각선 위치에 있으면 두 중간 위치 확인
                /**
                 * 1   __
                 * __  2
                 */
                if (map[loc1[0]][loc2[1]]!='X') return false;
                if (map[loc2[0]][loc1[1]]!='X') return false;
            }
        }
        return true;
    }//getMDistance() end

}
