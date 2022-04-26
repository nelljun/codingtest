package src.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 빛의경로사이클 {

    public static void main(String[] args) {
        String[] grid = {"S"};
        solution(grid);
    }

    //up, right, down, left 방향 순
    static final int[] DIRECTION_ROW = {-1, 0, 1, 0};
    static final int[] DIRECTION_COL = {0, 1, 0, -1};
    //격자 map
    static String[][] map;
    //격자 1개당 up, right, down, left 순으로 경로 저장할 배열
    static int[][][] route;
    //순환 경로 길이 저장할 list
    static List<Integer> answerList;

    public static int[] solution(String[] grid) {
        answerList = new ArrayList<>();
        
        //grid를 2차원 배열(변수 map)로
        int row = grid.length;
        int col = grid[0].length();

        map = new String[row][col];
        for (int i = 0; i < row; i++) {
            map[i] = grid[i].split("");
        }//for end

        route = new int[row][col][4];

        //모든 경로에 대해서 move()호출
        //단, 현재 값이 0이 아닌 경우 -> 즉, 순환 경로에 포함되지 않은 경로에서만!
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < 4; k++) {
                    if (route[i][j][k]==0) {
                        int nowRow = i;
                        int nowCol = j;
                        int length = 1;
                        int dirIndex = k;

                        while (true) {
                            //0이 아니란 뜻은 이미 체크된 경로란 뜻이므로 break
                            if (route[nowRow][nowCol][dirIndex]!=0) {
                                answerList.add(length-1);
                                break;
                            }
                            //현재까지 경로길이 저장
                            route[nowRow][nowCol][dirIndex] = length;

                            //다음 격자로 이동
                            nowRow = nowRow + DIRECTION_ROW[dirIndex];
                            nowCol = nowCol + DIRECTION_COL[dirIndex];

                            //범위 벗어나는 row, col 값 후처리
                            nowRow = makeInRange(nowRow, row);
                            nowCol = makeInRange(nowCol, col);

                            //다음 격자에서의 새로운 이동방향
                            dirIndex = changeDir(map[nowRow][nowCol], dirIndex);

                            length++;
                        }//while end
                    }
                }//for end
            }//for end
        }//for end

        int answerSize = answerList.size();
        int[] answer = new int[answerSize];

        for (int i = 0; i < answerSize; i++) {
            answer[i] = answerList.get(i);
        }//for end

        Arrays.sort(answer);

        return answer;
    }//solution() end

    //격자와 현재 방향에 따른 새로운 방향 index 리턴
    public static int changeDir(String point, int dirIndex) {
        switch (point) {
            case "L": dirIndex--;
            break;
            case "R": dirIndex++;
            break;
        }
        return makeInRange(dirIndex, 4);
    }//changeDir() end

    //범위 벗어나는 값 후처리하는 method
    public static int makeInRange(int now, int range) {
        return (now==range)? 0 : (now==-1)? range-1 : now;
    }

}
