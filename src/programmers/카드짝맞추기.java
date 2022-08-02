package src.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 카드짝맞추기 {
    public static void main(String[] args) {
        int[][] board = {{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}};
        solution(board, 0, 1);
    }

    static class Card {
        int row;
        int col;
        int move;

        public Card(int row, int col, int move) {
            this.row = row;
            this.col = col;
            this.move = move;
        }
    }

    static ArrayList<String> pairOrderList = new ArrayList<>();
    static boolean[] pairCheck;
    static StringBuilder sb = new StringBuilder();
    static final int[] DIRECTIONS_ROW = {1, 0, -1, 0};
    static final int[] DIRECTIONS_COL = {0, -1, 0, 1};

    public static int solution(int[][] board, int r, int c) {
        //키 조작 횟수 최솟값

        int pairCnt = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    pairCnt = Math.max(pairCnt, board[i][j]);
                }//if end
            }//for end
        }//for end

        pairCheck = new boolean[pairCnt];

        //탐색할 카드 번호 순서
        permutation(0, pairCnt);

        //카드 탐색
        int min = Integer.MAX_VALUE;
        for (String pairOrder : pairOrderList) {

            int moveCnt = 0;
            //하나의 order 안에서 카드 하나 탐색할 때마다 현재 position 변경
            int[] position = new int[2];
            position[0] = r;
            position[1] = c;

            int[][] copyBoard = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    copyBoard[i][j] = board[i][j];
                }//for end
            }//for end

            for (int i = 0; i < pairCnt; i++) {
                int target = pairOrder.charAt(i) - '0';

                //첫 번째 카드로 이동
                moveCnt += search(position, target, copyBoard);
                //첫 번째 카드 뒤집기
                moveCnt++;
                //카드 삭제
                copyBoard[position[0]][position[1]] = 0;


                //두 번째 카드로 이동
                moveCnt += search(position, target, copyBoard);
                //두 번째 카드 뒤집기
                moveCnt++;
                //카드 삭제
                copyBoard[position[0]][position[1]] = 0;
            }//for end

            min = Math.min(min, moveCnt);

        }//for end

        return min;
    }//solution() end

    //현재 위치(position)에서 둘 중 가까운 target 카드를 bfs 탐색으로 찾아가는 메서드
    private static int search(int[] position, int target, int[][] copyBoard) {
        Queue<Card> queue = new LinkedList<>();
        boolean[][] check = new boolean[4][4];
        int row = position[0];
        int col = position[1];

        queue.add(new Card(row, col, 0));
        check[row][col] = true;

        while (!queue.isEmpty()) {
            Card now = queue.poll();
            int nowRow = now.row;
            int nowCol = now.col;
            int nowMove = now.move;

            if (copyBoard[nowRow][nowCol] == target) {
                //position 이동
                position[0] = nowRow;
                position[1] = nowCol;

                return nowMove;
            }//if end

            //한 칸씩 이동
            for (int i = 0; i < 4; i++) {
                int newRow = nowRow + DIRECTIONS_ROW[i];
                int newCol = nowCol + DIRECTIONS_COL[i];

                if ((newRow>=0 && newRow<4)
                    && (newCol>=0 && newCol<4)
                    && !check[newRow][newCol]) {
                    check[newRow][newCol] = true;
                    queue.add(new Card(newRow, newCol, nowMove+1));
                }//if end
            }//for end

            //ctrl 이동
            for (int i = 0; i < 4; i++) {
                Card card = getCardInRoute(nowRow, nowCol, i, copyBoard);
                int cardRow = card.row;
                int cardCol = card.col;

                if (!check[cardRow][cardCol]) {
                    check[cardRow][cardCol] = true;
                    queue.add(new Card(cardRow, cardCol, nowMove+1));
                }//if end
            }//for end
        }//while end

        return -1;
    }//search() end

    //현재 방향으로 ctrl 이동했을 때 만나는 카드 리턴하는 메서드 (없으면 끝 위치 리턴)
    private static Card getCardInRoute(int nowRow, int nowCol, int direction, int[][] copyBoard) {
        nowRow += DIRECTIONS_ROW[direction];
        nowCol += DIRECTIONS_COL[direction];

        while ((nowRow>=0 && nowRow<4)
                && (nowCol>=0 && nowCol<4)) {
            //현재 방향의 길목에 카드 있으면 이동
            if (copyBoard[nowRow][nowCol] != 0) {
                return new Card(nowRow, nowCol, 0);
            }//if end

            nowRow += DIRECTIONS_ROW[direction];
            nowCol += DIRECTIONS_COL[direction];
        }//while end

        return new Card(nowRow-DIRECTIONS_ROW[direction],
                        nowCol - DIRECTIONS_COL[direction],
                        0);
    }//getCardInRoute() end

    //카드 제거 순서 리스트 만드는 메서드
    private static void permutation(int length, int pairCnt) {
        if (length == pairCnt) {
            pairOrderList.add(sb.toString());
            return;
        }//if end

        for (int i = 0; i < pairCnt; i++) {
            if (!pairCheck[i]) {
                pairCheck[i] = true;
                sb.append(i+1);

                permutation(length+1, pairCnt);

                pairCheck[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }//if end
        }//for end
    }//permutation() end
}
