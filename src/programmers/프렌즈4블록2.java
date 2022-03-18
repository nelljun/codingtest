package src.programmers;

import java.util.*;

public class 프렌즈4블록2 {

    static class Point {
        int row;
        int column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Point) {
                Point point = (Point) obj;
                return (point.row == this.row) && (point.column == this.column);
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }

    }

    public static void main(String[] args) {
        String[] board = {"AA", "BB", "AA", "BB", "ZZ", "ZZ", "CC"};
        solution(7, 2, board);
    }//main() end

    static char[][] gameBoard;

    public static void solution(int m, int n, String[] board) {
        gameBoard = new char[m][n];

        //게임 보드 알파벳 채우기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                gameBoard[i][j] = board[i].charAt(j);
            }//for end
        }//for end

        while(true) {
            check(m, n);

            if(!pointSet.isEmpty()) {
                count += pointSet.size();
                delete();
                move(m, n);
            } else {
                break;
            }//if~else end
        }//while end

    }//solution() end

    static Set<Point> pointSet = new HashSet<>();

    public static void check(int m, int n) {
        pointSet.clear();

        for (int i = 0; i < m-1; i++) {
            for (int j = 0; j < n-1; j++) {
                if(gameBoard[i][j]==' ') continue;
                if(gameBoard[i][j]==gameBoard[i][j+1]
                        && gameBoard[i][j]==gameBoard[i+1][j]
                        && gameBoard[i][j]==gameBoard[i+1][j+1]) {
                    pointSet.add(new Point(i, j));
                    pointSet.add(new Point(i, j+1));
                    pointSet.add(new Point(i+1, j));
                    pointSet.add(new Point(i+1, j+1));
                }//if end
            }//for end
        }//for end
    }//check() end

    static int count;

    public static void delete() {
        Iterator<Point> iterator = pointSet.iterator();
        while(iterator.hasNext()) {
            Point point = iterator.next();

            gameBoard[point.row][point.column] = ' ';
        }//while end
    }//delete() end


    public static void move(int m, int n) {
        for (int i = m-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if(gameBoard[i][j]==' ') {
                    for (int k = i; k >= 0 ; k--) {
                        if(gameBoard[k][j]!=' ') {
                            gameBoard[i][j] = gameBoard[k][j];
                            gameBoard[k][j] = ' ';
                            break;
                        }//if end
                    }//for end
                }//if end
            }//for end
        }//for end
    }//move2() end

}
