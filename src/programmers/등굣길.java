package src.programmers;

public class 등굣길 {
    public static void main(String[] args) {

    }
    //dp
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

    static int[][] board;
    static int answer = 0;
    static final int[] DIRECTIONS_X = {1, 0};
    static final int[] DIRECTION_Y = {0, 1};

    //dfs(정확성 ok, 효율성 x)
    public static int solution2(int m, int n, int[][] puddles) {
        board = new int[n][m];

        //웅덩이 -1로 표시
        for (int[] puddle : puddles) {
            board[puddle[1]-1][puddle[0]-1] = -1;
        }//for end

        dfs(0, 0, m, n);

        return answer;
    }//solution() end

    public static void dfs(int x, int y, int m, int n) {
        if (x==m-1 && y==n-1) {
            answer = (answer+1)%1000000007;
            return;
        }

        for (int i = 0; i < 2; i++) {
            int newX = x + DIRECTIONS_X[i];
            int newY = y + DIRECTION_Y[i];

            if (newX<m && newY<n && board[newY][newX]!=-1) {
                dfs(newX, newY, m, n);
            }
        }//for end
    }//dfs() end
}
