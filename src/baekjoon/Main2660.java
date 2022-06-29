package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2660 {
    //회원들 간의 관계를 나타내는 그래프
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int memberCnt = Integer.parseInt(bf.readLine());

        //그래프 초기화
        graph = new int[memberCnt][memberCnt];

        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int member1 = Integer.parseInt(st.nextToken());
            int member2 = Integer.parseInt(st.nextToken());

            //-1, -1 나올 때까지만
            if (member1==-1 && member2==-1) break;

            //멤버 번호 -> index로 변환해서 graph에 표시
            graph[member1-1][member2-1] = 1;
            graph[member2-1][member1-1] = 1;
        }//while end

        //scoreArr[i] : (i+1)번 회원이 모든 회원과 친구가 되기 위한 거리 + 1
        int[] scoreArr = new int[memberCnt];

        //50명이 최대니까 최저 점수를 51로 초기화
        //각 회원이 모든 회원가 친구가 되기 위한 거리의 최솟값+1 담을 변수
        int minScore = 51;

        for (int i = 0; i < memberCnt; i++) {
            //(i+1)번 회원으로부터의 거리를 저장하기 위한 거리 배열
            int[] distFromPerson = new int[memberCnt];
            bfs(i, distFromPerson);
            //(i+1)번으로부터 최고 멀리 떨어진 회원까지의 거리 + 1
            int maxDist = Arrays.stream(distFromPerson)
                                    .max()
                                    .getAsInt();

            //minScore 갱신
            minScore = Math.min(minScore, maxDist);

            scoreArr[i] = maxDist;
        }//for end

        //minScore에 해당하는 회원 index 저장할 list
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < memberCnt; i++) {
            if (scoreArr[i]==minScore) {
                answerList.add(i);
            }
        }//for end

        StringBuilder sb = new StringBuilder();

        //회장 후보 점수와 후보 수 append
        sb.append(minScore-1).append(" ")
          .append(answerList.size()).append("\n");

        //회장 후보 번호 append
        answerList.forEach(i -> sb.append(i+1).append(" "));

        System.out.println(sb);
    }

    public static void bfs(int start, int[] distFromPerson) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        //첫 시작 거리를 1로! (distFromPerson으로 방문 여부를 체크하기 위해)
        distFromPerson[start] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            int nowDist = distFromPerson[now];

            for (int i = 0; i < graph.length; i++) {
                //now회원과 i회원이 친구이고, i회원을 방문하지 않았으면
                //queue에 추가, i회원까지의 거리에 현재 거리+1로 세팅
                if (graph[now][i]==1 && distFromPerson[i]==0) {
                    queue.add(i);
                    distFromPerson[i] = nowDist+1;
                }
            }//for end
        }//while end
    }
}
