package src.programmers;

public class 카카오프렌즈컬러링북 {

    static boolean[][] isIncluded;
    static int numOfArea;
    static int max;
    static int sizeOfArea;

    public static void main(String[] args) {
        int[][] picture = {{1,1,1,0},{1,1,1,0},{0,0,0,1},{0,0,0,1},{0,0,0,1},{0,0,0,1}};
        solution(6, 4, picture);
    }//main() end

    public static void solution(int m, int n, int[][] picture) {

        isIncluded = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                isIncluded[i][j] = false;
            }//for end
        }//for end

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!isIncluded[i][j] && picture[i][j]!=0) {
                    numOfArea++;
                    sizeOfArea =0;
                    max = Math.max(max, search(i, j, picture[i][j], picture));
                }//if end
            }//for end
        }//for end

        int[] answer = new int[]{numOfArea, max};
    }//solution() end

    public static int search(int row, int column, int color, int[][] picture) {
        if(picture[row][column]==color && !isIncluded[row][column]) {
            isIncluded[row][column] = true;
            sizeOfArea++;
            if(column < picture[0].length-1) {
                search(row, column+1, color, picture);
            }
            if(row < picture.length-1) {
                search(row + 1, column, color, picture);
            }
        }

        return sizeOfArea;
    }//search() end
}
