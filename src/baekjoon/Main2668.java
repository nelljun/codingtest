package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2668 {
    //사이클 탐색 시 방문 여부
    static boolean[] isVisited;
    //두 번째 줄 각 칸에 해당하는 숫자 배열
    static int[] board;
    //최종 사이클을 이루는 숫자 저장하는 리스트
    static ArrayList<Integer> answerList = new ArrayList<>();
    //사이클 재귀 탐색 시 중간에 거치는 숫자 임시로 저장하는 리스트
    static ArrayList<Integer> tempList = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new int[N+1];
        isVisited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }//for end

        for (int i = 1; i <= N; i++) {
            //이미 사이클을 이루는 숫자는 다른 사이클에 속할 수 없으므로
            //사이클을 이루지 못한 숫자만 재귀 탐색의 시작점으로!
            if (!answerList.contains(i)) {
                //시작지점 방문 true
                isVisited[i] = true;
                //시작지점 임시 리스트 저장
                tempList.add(i);
                //사이클 재귀 탐색
                dfs(i, i);
                //시작지점 방문 false
                isVisited[i] = false;
                //시작지점 임시 리스트에서 제거
                tempList.remove((Integer)i);
            }
        }//for end

        StringBuilder sb = new StringBuilder();
        int size = answerList.size();

        sb.append(size).append("\n");

        answerList.stream()
                .sorted()
                .forEach(num -> sb.append(num).append("\n"));

        System.out.println(sb);
    }

    public static void dfs(int now, int start) {
        //중단조건
        //다음 탐색값이 탐색 시작점과 같으면 사이클을 이룸
        //임시 리스트에 저장된 값을 정답 리스트에 저장
        if (board[now]==start) {
            answerList.addAll(tempList);
            return;
        }

        //다음 탐색값이 현재 탐색 동안 방문하지 않았고, 이미 사이클을 이루지 않았으면 방문!
        if (!isVisited[board[now]] && !answerList.contains(board[now])) {
            isVisited[board[now]] = true;
            tempList.add(board[now]);
            dfs(board[now], start);
            isVisited[board[now]] = false;
            tempList.remove((Integer)board[now]);
        }
    }
}
