package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1967 {
    static class Node {
        int num;
        int parent;
        int distFromParent;

        public Node(int num, int parent, int distFromParent) {
            this.num = num;
            this.parent = parent;
            this.distFromParent = distFromParent;
        }
    }

    static ArrayList<Node> graph = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> routeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        //index 맞추기 위해 root node 추가
        graph.add(new Node(0, -1, 0));

        boolean[] isParent = new boolean[N];

        StringTokenizer st = null;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int parent = Integer.parseInt(st.nextToken())-1;
            int child = Integer.parseInt(st.nextToken())-1;
            int dist = Integer.parseInt(st.nextToken());

            graph.add(new Node(child, parent, dist));
            isParent[parent] = true;
        }//for end

        ArrayList<Integer> noParentList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (isParent[i]) {
                routeList.add(new ArrayList<>());
            } else {
                routeList.add(routeFromRoot(i));
                noParentList.add(i);
            }
        }//for end

        long maxDist = 0L;
        int size = noParentList.size();

        for (int i = 0; i < size-1; i++) {
            for (int j = i+1; j < size; j++) {
                maxDist = Math.max(maxDist, getDistFromTwoLeafs(noParentList.get(i), noParentList.get(j)));
            }//for end
        }//for end

        System.out.println(maxDist);
    }

    public static long getDistFromTwoLeafs(int leaf1, int leaf2) {
        int lastSameAncestor = getLastSameAncestor(leaf1, leaf2);

        long dist1 = getDistFromLeafToAncestor(leaf1, lastSameAncestor);
        long dist2 = getDistFromLeafToAncestor(leaf2, lastSameAncestor);

        return dist1 + dist2;
    }//getDistFromTwoLeafs() end

    public static int getLastSameAncestor(int leaf1, int leaf2) {
        ArrayList<Integer> route1 = routeList.get(leaf1);
        ArrayList<Integer> route2 = routeList.get(leaf2);

        int lastSameAncestor = 0;
        int index = 0;
        while (true) {
            int node1 = route1.get(index);
            int node2 = route2.get(index);

            if (node1==node2) {
                lastSameAncestor = node1;
                index++;
            } else {
                break;
            }//if~else end
        }//while end

        return lastSameAncestor;
    }//getLastSameParent() end

    public static long getDistFromLeafToAncestor(int leaf, int ancestor) {
        long dist = 0L;

        while (leaf != ancestor) {
            Node leafNode = graph.get(leaf);

            dist += (long)leafNode.distFromParent;
            leaf = leafNode.parent;
        }//while end

        return dist;
    }//getDistFromLeafToAncestor() end

    public static ArrayList<Integer> routeFromRoot(int target) {
        ArrayList<Integer> route = new ArrayList<>();

        while (target!=-1) {
            route.add(0, target);

            target = graph.get(target).parent;
        }//while end

        return route;
    }//routeFromRoot() end
}
