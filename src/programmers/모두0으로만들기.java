package src.programmers;

import java.util.LinkedList;

public class 모두0으로만들기 {

    public static void main(String[] args) {
        int[] a = {-5,0,2,1,2};
        int[][] edges = {{0,1},{3,4},{2,3},{0,3}};

        solution(a, edges);
    }

    static LinkedList<Integer>[] edgeList;

    public static long solution(int[] a, int[][] edges) {
        int nodeSize = a.length;
        long sum = 0L;

        long[] longA = new long[nodeSize];

        for (int i = 0; i < nodeSize; i++) {
            longA[i] = a[i];
        }//for end

        if (hasAllZero(longA)) return 0;

        for (int i = 0; i < nodeSize; i++) {
            sum += longA[i];
        }//for end

        if (sum!=0) return -1;

        edgeList = new LinkedList[nodeSize];

        for (int i = 0; i < nodeSize; i++) {
            edgeList[i] = new LinkedList<>();
        }//for end

        int edgeSize = edges.length;

        for (int i = 0; i < edgeSize; i++) {
            int[] edge = edges[i];
            //각 node에 연결된 node를 list에 추가
            edgeList[edge[0]].add(edge[1]);
            edgeList[edge[1]].add(edge[0]);
        }//for end

        long cnt = 0L;

        while (!hasAllZero(longA)) {
            for (int i = 0; i < nodeSize; i++) {
                if (edgeList[i].size()==1 && longA[i]!=0) {
                    int target = edgeList[i].get(0);
                    longA[target] += longA[i];
                    cnt += (longA[i]<0)? -longA[i] : longA[i];
                    longA[i] = 0;

                    edgeList[i].remove(0);
                    edgeList[target].remove((Integer)i);
                }//if end
            }//for end
        }//while end

        return cnt;
    }//solution() end

    public static boolean hasAllZero(long[] longA) {
        for (int i = 0; i < longA.length; i++) {
            if (longA[i]!=0) return false;
        }//for end

        return true;
    }
}
