package src.programmers;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class 공이동시뮬레이션 {
    public static void main(String[] args) {
        int[][] queries = {{0, 100001},{2,100001}};
        solution(1000,1000,1,1,queries);
    }

    public static long solution(int n, int m, int x, int y, int[][] queries) {
        int queryLength = queries.length;

        int minRow = x;
        int maxRow = x;
        int minCol = y;
        int maxCol = y;

        for (int i = queryLength-1; i >= 0; i--) {
            int direction = queries[i][0];
            int dist = queries[i][1];

            switch (direction) {
                case 0:
                    //열 감소
                    if (minCol!=0) {
                        if (minCol+dist>=m) {
                            return 0;
                        } else {
                            minCol += dist;
                        }
                    }
                    maxCol = Math.min(m-1, maxCol+dist);
                    break;
                case 1:
                    //열 증가
                    minCol = Math.max(0, minCol-dist);
                    if (maxCol!=m-1) {
                        if (maxCol-dist<0) {
                            return 0;
                        } else {
                            maxCol -= dist;
                        }
                    }
                    break;
                case 2:
                    //행 감소
                    if (minRow!=0) {
                        if (minRow+dist>=n) {
                            return 0;
                        } else {
                            minRow += dist;
                        }
                    }
                    maxRow = Math.min(n-1, maxRow+dist);
                    break;
                case 3:
                    //행 증가
                    minRow = Math.max(0, minRow-dist);
                    if (maxRow!=n-1) {
                        if (maxRow-dist<0) {
                            return 0;
                        } else {
                            maxRow -= dist;
                        }
                    }
                    break;
            }
        }//for end

        return (maxRow-minRow+1) * (long)(maxCol-minCol+1);
    }//solution() end
}
