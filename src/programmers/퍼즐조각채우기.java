package src.programmers;

import java.util.*;

public class 퍼즐조각채우기 {

    public static void main(String[] args) {
        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};

        int[][] game_board2 = {{0,0,0},{1,1,0},{1,1,1}};
        int[][] table2 = {{1,1,1}, {1,0,0}, {0,0,0}};

        solution(game_board2, table2);
    }
    static final int[] DIRECTIONS_ROW = {1, 0, -1, 0};
    static final int[] DIRECTIONS_COL = {0, 1, 0, -1};

    static List<Space> emptyList;
    static List<Space> puzzleList;
    static boolean[][] isCheckedEmpty;
    static boolean[][] isCheckedPuzzle;

    static class Space {
        int count;
        int[][] matrix;

        public Space(int count, int[][] matrix) {
            this.count = count;
            this.matrix = matrix;
        }
    }

    public static int solution(int[][] game_board, int[][] table) {
        int length = game_board.length;

        emptyList = new ArrayList<>();
        puzzleList = new ArrayList<>();

        isCheckedEmpty = new boolean[length][length];
        isCheckedPuzzle = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (game_board[i][j]==0 && !isCheckedEmpty[i][j]) exploreGameBoard(i, j, game_board);
                if (table[i][j]==1 && !isCheckedPuzzle[i][j]) exploreTable(i, j, table);
            }//for end
        }//for end

        int answer = 0;

        int emptySpaceCnt = emptyList.size();

        for (int i = 0; i < emptySpaceCnt; i++) {
            Space emptySpace = emptyList.get(i);

            int puzzleSpaceCnt = puzzleList.size();
            for (int j = 0; j < puzzleSpaceCnt; j++) {
                Space puzzleSpace = puzzleList.get(j);

                if (emptySpace.count==puzzleSpace.count && isSameMatrix(emptySpace, puzzleSpace)) {
                    answer += emptySpace.count;
                    puzzleList.remove(j);
                    break;
                }
            }//for end
        }//for end

        return answer;
    }//solution() end

    public static void exploreGameBoard(int row, int col, int[][] game_board) {
        List<int[]> pointList = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        int[] point = new int[]{row, col};

        queue.add(point);
        pointList.add(point);
        isCheckedEmpty[point[0]][point[1]] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowRow = now[0];
            int nowCol = now[1];

            for (int i = 0; i < 4; i++) {
                int newRow = nowRow + DIRECTIONS_ROW[i];
                int newCol = nowCol + DIRECTIONS_COL[i];

                if (newRow>=0 && newRow<game_board.length
                && newCol>=0 && newCol< game_board.length
                && game_board[newRow][newCol]==0
                && !isCheckedEmpty[newRow][newCol]) {
                    int[] newPoint = new int[]{newRow, newCol};
                    isCheckedEmpty[newRow][newCol] = true;
                    queue.add(newPoint);
                    pointList.add(newPoint);
                }
            }//for end
        }//while end

        emptyList.add(makeSpace(pointList));
    }

    public static void exploreTable(int row, int col, int[][] table) {
        List<int[]> pointList = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        int[] point = new int[]{row, col};

        queue.add(point);
        pointList.add(point);
        isCheckedPuzzle[point[0]][point[1]] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowRow = now[0];
            int nowCol = now[1];

            for (int i = 0; i < 4; i++) {
                int newRow = nowRow + DIRECTIONS_ROW[i];
                int newCol = nowCol + DIRECTIONS_COL[i];

                if (newRow>=0 && newRow<table.length
                && newCol>=0 && newCol< table.length
                && table[newRow][newCol]==1
                && !isCheckedPuzzle[newRow][newCol]) {
                    int[] newPoint = new int[]{newRow, newCol};
                    isCheckedPuzzle[newRow][newCol] = true;
                    queue.add(newPoint);
                    pointList.add(newPoint);
                }
            }//for end
        }//while end

        puzzleList.add(makeSpace(pointList));
    }

    public static Space makeSpace(List<int[]> pointList) {
        int minRow = 50, minCol = 50;
        int maxRow = 0, maxCol = 0;

        Iterator<int[]> iterator = pointList.iterator();
        while (iterator.hasNext()) {
            int[] point = iterator.next();
            minRow = Math.min(minRow, point[0]);
            maxRow = Math.max(maxRow, point[0]);
            minCol = Math.min(minCol, point[1]);
            maxCol = Math.max(maxCol, point[1]);
        }//while end

        int[][] matrix = new int[maxRow-minRow+1][maxCol-minCol+1];

        iterator = pointList.iterator();
        while (iterator.hasNext()) {
            int[] point = iterator.next();
            matrix[point[0]-minRow][point[1]-minCol] = 1;
        }//while end

        return new Space(pointList.size(), matrix);
    }

    public static boolean isSameMatrix(Space empty, Space puzzle) {
        int[][] newMatrix = puzzle.matrix;

        boolean isSame = true;
        for (int i = 0; i < 4; i++) {
            isSame = true;

            if (empty.matrix.length!=newMatrix.length
                    || empty.matrix[0].length!=newMatrix[0].length) {
                isSame = false;
                newMatrix = rotateCW(newMatrix);
                continue;
            }
            for (int k = 0; k < empty.matrix.length; k++) {
                for (int j = 0; j < empty.matrix[0].length; j++) {
                    if(empty.matrix[k][j]!=newMatrix[k][j]) {
                        isSame = false;
                        break;
                    }
                }//for end
                if (!isSame) break;
            }//for end
            if (isSame) break;

            newMatrix = rotateCW(newMatrix);
        }//for end

        return isSame;
    }

    public static int[][] rotateCW(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] newMatrix = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j]==1) {
                    newMatrix[j][row-1-i] = 1;
                }
            }//for end
        }//for end

        return newMatrix;
    }
}
