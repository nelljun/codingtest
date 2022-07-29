package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1922 {
    static int[] rootArr;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    private static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        rootArr = new int[N];

        for (int i = 0; i < N; i++) {
            rootArr[i] = i;
        }//for end

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            pq.add(new Edge(start, end, cost));
        }//for end

        System.out.println(mst(N));
    }

    public static int mst(int N) {
        int edgeCnt = 0;
        int costSum = 0;

        while ((edgeCnt<N) && !pq.isEmpty()) {
            Edge now = pq.poll();

            int startRoot = find(now.start);
            int endRoot = find(now.end);

            //cycle
            if (startRoot==endRoot) {
                continue;
            }//if end

            union(now.start, now.end);
            costSum += now.cost;
            edgeCnt++;

        }//while end

        return costSum;
    }//solution() end

    public static int find(int node) {
        if (rootArr[node] == node) {
            return node;
        }//if end

        return find(rootArr[node]);
    }//find() end

    public static void union(int node1, int node2) {
        node1 = find(node1);
        node2 = find(node2);

        if (node1<node2) {
            rootArr[node2] = node1;
        } else {
            rootArr[node1] = node2;
        }//if~else end
    }//union() end


}
