package src.programmers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class 프렌즈4블록1 {
    static char[][] gameBoard;
    static Set<int[]> set = new HashSet<>();
    static int count;

    public static void main(String[] args) {
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        solution(6, 6, board);
    }//main() end

    public static int solution(int m, int n, String[] board) {
    //m x n 사이즈의 2차원 배열 생성
    gameBoard = new char[m][n];

    //게임 보드 알파벳 채우기
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            gameBoard[i][j] = board[i].charAt(j);
        }//for end
    }//for end

    while(true) {
        //삭제할 블록 있는지 체크(set에 블록 좌표 add)
        check(m, n);

        if(!set.isEmpty()) {
            //삭제할 블록 있는 경우
            //해당 위치의 배열 요소 값 ' ' 으로 초기화
            delete();
            //삭제된 블록 자리 메꾸기
            move(m, n);
        } else {
            //더 이상 삭제할 블록이 없는 경우
            break;
        }//if~else end
    }//while end

    return count;

}//solution() end

    public static void check(int m, int n) {
        //매 사이클마다 set 초기화해준다.
        set.clear();

        for (int i = 0; i < m-1; i++) {
            for (int j = 0; j < n-1; j++) {
                if(gameBoard[i][j]==' ') continue;
                if(gameBoard[i][j]==gameBoard[i][j+1]
                        && gameBoard[i][j]==gameBoard[i+1][j]
                        && gameBoard[i][j]==gameBoard[i+1][j+1]) {
                    set.add(new int[]{i, j});
                }//if end
            }//for end
        }//for end
    }//check() end

    public static void delete() {
        Iterator<int[]> iterator = set.iterator();

        while(iterator.hasNext()) {
            int[] location = iterator.next();

            //2x2블록의 대표 좌표 중심으로 4좌표 모두 ' '로 초기화
            //블록들이 겹치는 부분은 한 번만 카운트 한다.
            if(gameBoard[location[0]][location[1]]!=' ') {
                gameBoard[location[0]][location[1]] = ' ';
                count++;
            }
            if(gameBoard[location[0]][location[1]+1]!=' ') {
                gameBoard[location[0]][location[1]+1] = ' ';
                count++;
            }
            if(gameBoard[location[0]+1][location[1]]!=' ') {
                gameBoard[location[0]+1][location[1]] = ' ';
                count++;
            }
            if(gameBoard[location[0]+1][location[1]+1]!=' ') {
                gameBoard[location[0]+1][location[1]+1] = ' ';
                count++;
            }
        }//while end
    }//delete() end

    public static void move(int m, int n) {
        //아래서부터 채워야 하므로 마지막 row부터 탐색
        for (int i = m-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if(gameBoard[i][j]==' ') {
                    //빈 블록일 때
                    //현재 위치[i][j]서부터 위로 올라가면서
                    //비지 않은 블록의 값으로 현재 위치의 블록을 채우고
                    //값을 가져온 블록은 ' '로 비운다.
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
    }//move() end

}
