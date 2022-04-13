package src.programmers;

public class 등굣길 {
    public static void main(String[] args) {

    }

    public static int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];

        for (int[] puddle : puddles) {
            map[puddle[1]-1][puddle[0]-1] = -1;
        }//for end

        //집
        map[0][0] = 1;

        //맨 윗줄
        for (int i = 1; i < m; i++) {
            map[0][i] = (map[0][i]==-1)? 0 : map[0][i-1];
        }//for end

        //맨 왼쪽 줄
        for (int i = 1; i < n; i++) {
            map[i][0] = (map[i][0]==-1)? 0 : map[i-1][0];
        }//for end

        //웅덩이는 0으로 고정
        //나머지는 왼+위 = 본인
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                map[i][j] = (map[i][j]==-1)? 0 : (map[i][j-1] + map[i-1][j]) % 1000000007;
            }//for end
        }//for end

        return map[n-1][m-1];
    }//solution() end
}
