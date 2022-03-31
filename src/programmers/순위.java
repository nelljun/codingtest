package src.programmers;

public class 순위 {

    public static void main(String[] args) {
        int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};
        solution(5, results);
    }

    public static int solution(int n, int[][] results) {
        int[][] matrix = new int[n][n];
        int answer = 0;

        for (int[] result : results) {
            int win = result[0];
            int lose = result[1];

            matrix[win-1][lose-1] = 1;
            matrix[lose-1][win-1] = -1;
        }//for end

        //중간
        for (int k = 0; k < n; k++) {
            //시작
            for (int i = 0; i < n; i++) {
                //끝
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k]==1 && matrix[k][j]==1) {
                        matrix[i][j] = 1;
                        matrix[j][i] = -1;
                    } else if (matrix[i][k]==-1 && matrix[k][j]==-1) {
                        matrix[i][j] = -1;
                        matrix[j][i] = 1;
                    }
                }//for end
            }//for end
        }//for end

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]!=0) {
                    count++;
                }
            }//for end
            if (count==n-1) answer++;
        }//for end

        return answer;
    }//solution() end

}
