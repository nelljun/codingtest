package src.programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class 피로도 {

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        solution(k, dungeons);
    }//main() end

    public static int solution(int k, int[][] dungeons) {

        isVisited = new boolean[dungeons.length];
        //최댓값을 구하기 위해 최대 priority queue로 생성
        pq = new PriorityQueue<>(Collections.reverseOrder());

        dfs(k, dungeons);
        return pq.poll();

        //dfs2(k, dungeons, 0);
        //return ans;
    }//solution() end

    static boolean[] isVisited;
    //각 중단조건에서 방문한 던전 수 저장할 queue
    static PriorityQueue<Integer> pq;

    public static int countTrue() {
        int count=0;
        for(boolean result : isVisited) {
            if(result==true) count++;
        }//for end
        return count;
    }

    public static void dfs(int k, int[][] dungeons) {
        //각 중단조건때마다 최종 방문한 던전 갯수를 세어(countTrue())
        //priority queue에 저장

        //중단조건 1
        if(k==0) {
            pq.add(countTrue());
            return;
        }//if end

        //중단조건 2. 모든 던전 방문한 경우
        if(countTrue()==isVisited.length) {
            pq.add(isVisited.length);
            return;
        }//if end

        //중단조건 3. 현재 피로도로 남은 던전을 방문하지 못하는 경우
        //남은 던전의 최소 필요 피로도의 최솟값보다 현재 피로도가 작을 때
        int min = 1000;
        for(int[] dungeon : dungeons) {
            min = Math.min(min, dungeon[0]);
        }//for end
        if(k<min) {
            pq.add(countTrue());
            return;
        }

        for(int i=0; i<dungeons.length; i++) {
            if(!isVisited[i] && k>=dungeons[i][0]) {
                isVisited[i] = true;
                dfs(k-dungeons[i][1], dungeons);
                isVisited[i] = false;
            }//if end
        }//for end
    }//dfs() end

    //갱신하기 위해 전역변수로 선언
    static int ans = 0;

    public static void dfs2(int k, int[][] dungeons, int cnt) {
        //앞서 중단조건이 이 for문 안 조건문으로 모두 걸러지기 때문에
        //불필요한 연산을 안할 수 있다.
        //방문한 던전 수를 뜻하는 cnt를 파라미터로 추가해
        //ans를 매 연산마다 ans와 cnt의 최댓값으로 갱신가능

        for(int i=0; i<dungeons.length; i++) {
            if(!isVisited[i] && k>=dungeons[i][0]) {
                isVisited[i] = true;
                dfs2(k-dungeons[i][1], dungeons, cnt+1);
                isVisited[i] = false;
            }//if end
        }//for end

        ans = Math.max(ans, cnt);
    }//dfs2() end
}
