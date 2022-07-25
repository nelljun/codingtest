package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2458 {
    static int[][] graph;
    static int N;
    static ArrayList<Student> studentList = new ArrayList<>();
    static boolean[] isVisited;
    private static class Student {
        int lowerCnt;
        int higherCnt;

        public Student() {
        }

        public Student(int lowerCnt, int higherCnt) {
            this.lowerCnt = lowerCnt;
            this.higherCnt = higherCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            studentList.add(new Student());
        }//for end

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int low = Integer.parseInt(st.nextToken())-1;
            int high = Integer.parseInt(st.nextToken())-1;

            graph[low][high] = 1;
        }//for end

        int answer = 0;

        for (int i = 0; i < N; i++) {
            Student student = studentList.get(i);
            student.higherCnt = greaterBfs(i);
            student.lowerCnt = lessBfs(i);


            if ((student.higherCnt + student.lowerCnt) == N-1) {
                answer++;
            }
        }//for end

        System.out.println(answer);
    }

    public static int greaterBfs(int studentNum) {
        Arrays.fill(isVisited, false);

        Queue<Integer> queue = new LinkedList<>();

        queue.add(studentNum);
        isVisited[studentNum] = true;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int nowStudentNum = queue.poll();

            Student nowStudent = studentList.get(nowStudentNum);
            if (nowStudent.higherCnt != 0) {
                return cnt + nowStudent.higherCnt;
            }

            for (int i = 0; i < N; i++) {
                if (graph[nowStudentNum][i] == 1 && !isVisited[i]) {
                    queue.add(i);
                    isVisited[i] = true;
                    cnt++;
                }
            }//for end
        }//while end

        return cnt;
    }

    public static int lessBfs(int studentNum) {
        Arrays.fill(isVisited, false);

        Queue<Integer> queue = new LinkedList<>();

        queue.add(studentNum);
        isVisited[studentNum] = true;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int nowStudentNum = queue.poll();

            Student nowStudent = studentList.get(nowStudentNum);
            if (nowStudent.lowerCnt != 0) {
                return cnt + nowStudent.lowerCnt;
            }

            for (int i = 0; i < N; i++) {
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
