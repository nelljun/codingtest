package src.programmers;

public class 행렬의곱셈 {

    public static void main(String[] args) {

    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int a = arr1.length;
        int b = arr1[0].length;
        int c = arr2.length;
        int d = arr2[0].length;

        int[][] answer = new int[a][d];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < d; j++) {
                for (int k = 0; k < b; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }//for end
            }//for end
        }//for end

        return answer;
    }//solution() end
}
