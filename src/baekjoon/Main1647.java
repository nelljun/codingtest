package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1647 {

    static int N, M;
    static ArrayList<ArrayList<Node>> nodeListArr;
    static boolean[] isVisited;

    static class Node implements Comparable<Node>{
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nodeListArr = new ArrayList<>();
        isVisited = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            nodeListArr.add(new ArrayList<>());
        }//for end

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine(), " ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodeListArr.get(from).add(new Node(to, cost));
            nodeListArr.get(to).add(new Node(from, cost));
        }//for end

        System.out.println(search());
    }

    public static int search() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(1, 0));

        int sum = 0;
        int maxCost = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (!isVisited[now.num]) {
                isVisited[now.num] = true;
            } else {
                continue;
            }

            maxCost = Math.max(maxCost, now.cost);
            sum += now.cost;

            ArrayList<Node> nodeListFromNow = nodeListArr.get(now.num);
            int size = nodeListFromNow.size();

            for (int i = 0; i < size; i++) {
                Node next = nodeListFromNow.get(i);
                if (!isVisited[next.num]) {
                    pq.add(next);
                }
            }//for end

        }//while end

        return sum - maxCost;
    }//search() end

}
