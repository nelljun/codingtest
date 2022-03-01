package src.programmers;

public class 삼각달팽이 {

    public static void main(String[] args) {
        solution(4);
    }//main() end

    public static int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];

        //숫자를 왼쪽 벽으로 붙인 후 2차원 배열로 생각
        //*
        //**
        //***
        //****
        //*****
        int[][] board = new int[n][n];

        int x=0, y=-1;
        int num = 1;

        //아래, 오른쪽, 왼쪽위대각선 순서로 n개, n-1개, n-2개 ... 1개까지 숫자 채운다.
        for(int k=0; k<n; k++) {
            for(int i=k; i<n; i++) {
                if(k%3==0) {
                    //아래로 진행
                    y++;
                } else if(k%3==1) {
                    //오른쪽으로 진행
                    x++;
                } else {
                    //왼,위 대각선으로 진행
                    x--;
                    y--;
                }//if~else end
                board[y][x] = num++;
            }//for end
        }//for end

        int index = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j]==0) break;
                answer[index++] = board[i][j];
            }//for end
        }//for end

        return answer;
    }//solution() end
}
