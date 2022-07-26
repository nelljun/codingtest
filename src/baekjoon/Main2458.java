package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2458 {
    //학생들 간의 관계 저장할 2차원 배열
    static int[][] graph;
    static int N;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        isVisited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int low = Integer.parseInt(st.nextToken())-1;
            int high = Integer.parseInt(st.nextToken())-1;

            graph[low][high] = 1;
        }//for end

        int answer = 0;

        for (int i = 0; i < N; i++) {
            //(i+1)번 학생을 기준으로 큰 키의 학생 수
            int greaterCnt = greaterBfs(i);
            //(i+1)번 학생을 기준으로 작은 키의 학생 수
            int lessCnt = lessBfs(i);

            //기준 학생보다 크거나 작은 학생 수의 합이 N-1이면 키 순위 정해짐
            if ((greaterCnt + lessCnt) == N-1) {
                answer++;
            }
        }//for end

        System.out.println(answer);
    }

    /**
     * greaterBfs() : 기준 학생보다 큰 키의 학생들을 bfs로 탐색
     * @param studentNum : 기준이 될 학생 번호
     * @return : 기준 학생보다 큰 키의 학생 수
     */
    public static int greaterBfs(int studentNum) {
        //방문 여부 배열 초기화
        Arrays.fill(isVisited, false);

        Queue<Integer> queue = new LinkedList<>();

        queue.add(studentNum);
        isVisited[studentNum] = true;
        //조건에 해당하는 학생 수
        int cnt = 0;

        while (!queue.isEmpty()) {
            int nowStudentNum = queue.poll();

            for (int i = 0; i < N; i++) {
                //graph[작은 학생 번호][큰 학생 번호] 이므로 뒤 index를 바꿔가며 탐색
                if (graph[nowStudentNum][i] == 1 && !isVisited[i]) {
                    queue.add(i);
                    isVisited[i] = true;
                    cnt++;
                }
            }//for end
        }//while end

        return cnt;
    }

    /**
     * lessBfs() : 기준 학생보다 작은 키의 학생들을 bfs로 탐색
     * @param studentNum : 기준이 될 학생 번호
     * @return : 기준 학생보다 작은 키의 학생 수
     */
    public static int lessBfs(int studentNum) {
        Arrays.fill(isVisited, false);

        Queue<Integer> queue = new LinkedList<>();

        queue.add(studentNum);
        isVisited[studentNum] = true;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int nowStudentNum = queue.poll();

            for (int i = 0; i < N; i++) {
                //greaterBfs와는 반대로 작은 키 학생을 찾아야 하므로 앞 index를 바꿔가며 거꾸로 탐색
                if (graph[i][nowStudentNum] == 1 && !isVisited[i]) {
                    queue.add(i);
                    isVisited[i] = true;
                    cnt++;
                }
            }//for end
        }//while end

        return cnt;
    }



}
