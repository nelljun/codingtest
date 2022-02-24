package src.programmers;

import java.util.*;

public class 전력망둘로나누기 {

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}};
        solution(n, wires);
    }//main() end

    static ArrayList<Integer>[] wireList;
    static boolean[] isIncluded;
    static int count;

    public static void fillList(int n, int[][] wires) {
        wireList = new ArrayList[n];

        for(int i=0; i<n; i++) {
            wireList[i] = new ArrayList<>();
        }//for end

        for(int[] wire : wires) {
            wireList[wire[0]-1].add(wire[1]-1);
            wireList[wire[1]-1].add(wire[0]-1);
        }
    }

    public static void solution(int n, int[][] wires) {

        isIncluded  = new boolean[n];
        count = 0;

        fillList(n, wires);

        int min = 100;
        for(int[] wire : wires) {
            isIncluded[wire[1]-1] = true;
            searchBFS(wire[0]-1);
            min = Math.min(Math.abs(n-2*count), min);
            //초기화
            Arrays.fill(isIncluded, false);
            count = 0;
        }//for end

        System.out.println(min);

    }//solution() end

    public static void searchBFS(int node) {

        Queue<Integer> queue = new LinkedList<>();
        isIncluded[node] = true;
        count++;
        queue.add(node);

        while(queue.size()!=0) {
            node = queue.poll();
            Iterator<Integer> iter = wireList[node].iterator();
            while(iter.hasNext()) {
                int next = iter.next();
                if(!isIncluded[next]) {
                    isIncluded[next] = true;
                    count++;
                    queue.add(next);
                }//if end
            }//while end
        }//while end

    }//search() end

}
