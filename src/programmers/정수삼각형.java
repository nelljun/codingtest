package src.programmers;

public class 정수삼각형 {

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        solution(triangle);
    }

    static int max = 0;

    public static void solution(int[][] triangle) {
        //첫번째 줄 값 계산 후 완전 탐색
        dfs(triangle[0][0], 1, 0, triangle);
    }//solution() end

    //모든 경우 탐색 (dfs) - 시간 초과
    public static void dfs(int sum, int row, int column, int[][] triangle) {
        //중단조건 : row값이 triangle 길이와 같아지면 max 값 갱신 후 리턴
        if (row == triangle.length) {
            max = Math.max(max, sum);
            return;
        }

        /**
         * 1
         * 11
         * 111
         * 1111
         * 11111
         * 형태로 보면 아래 row로 갈 때 선택 가능한 column이
         * 현재 column 값, column+1 값이다.
         */
        for (int i = column; i <= column+1; i++) {
            dfs(sum+triangle[row][i], row+1, i, triangle);
        }//for end
    }

    //동적 계획법 (dp)
    public static int solution2(int[][] triangle) {
        /**
         * 7            7
         * 3 8    ->    10 11
         * 8 1 0        18 12 11 처럼
         * 윗 줄까지 합 구한 후 아랫 줄에서 가능한 최댓값 구해나간다.
         */
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j==0) {
                    //column 0은 윗 수(row만 -1)랑만 계산 가능
                    triangle[i][j] = triangle[i-1][j] + triangle[i][j];
                } else if (j==i) {
                    //마지막 column은 왼쪽 대각선 수(row-1, column-1)랑만 계산 가능
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i][j];
                } else {
                    //중간 column은 윗 수, 왼쪽 대각선 수 중 큰 수랑 계산
                    triangle[i][j] = Math.max(triangle[i-1][j-1], triangle[i-1][j]) + triangle[i][j];
                }
            }//for end
        }//for end

        //마지막 row에서 최댓값
        int max = 0;
        for (int i = 0; i < triangle.length; i++) {
            max = Math.max(triangle[triangle.length-1][i], max);
        }//for end

        return max;
    }//solution() end

}
