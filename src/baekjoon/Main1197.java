package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1197 {
    static int[] rootArr;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    private static class Edge implements Comparable<Edge>{
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
            return Integer.compare(this.cost, e.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        rootArr = new int[V];
        for (int i = 0; i < V; i++) {
            rootArr[i] = i;
        }//for end

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            pq.add(new Edge(start, end, cost));
        }//for end

        System.out.println(mst(V));
    }

    public static long mst(int V) {
        int edgeCnt = 0;
        long costSum = 0L;

        while ((edgeCnt<V) && !pq.isEmpty()) {
            Edge now = pq.poll();

            int startRoot = find(now.start);
            int endRoot = find(now.end);

            if (startRoot==endRoot) {
                continue;
            }//if end

            costSum += (long)now.cost;
            union(now.start, now.end);
            edgeCnt++;

        }//while end

        return costSum;
    }

    private static void union(int node1, int node2) {
        node1 = find(node1);
        node2 = find(node2);

        if (node1<node2) {
            rootArr[node2] = node1;
        } else {
            rootArr[node1] = node2;
        }
    }

    public static int find(int node) {
        if (rootArr[node] == node) {
            return node;
        }//if end

        return find(rootArr[node]);
    }


}
