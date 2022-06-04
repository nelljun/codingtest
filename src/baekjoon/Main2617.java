package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2617 {
    static Map<Integer, ArrayList<Integer>> greaterMap = new HashMap<>();
    static Map<Integer, ArrayList<Integer>> lessMap = new HashMap<>();
    static Set<Integer> answerSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int total = Integer.parseInt(st.nextToken());
        int criteria = (total+1)/2;
        int pair = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= total; i++) {
            greaterMap.put(i, new ArrayList<>());
            lessMap.put(i, new ArrayList<>());
        }//for end

        for (int i = 0; i < pair; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int heavy = Integer.parseInt(st.nextToken());
            int light= Integer.parseInt(st.nextToken());

            ArrayList<Integer> greaterValue = greaterMap.get(light);
            greaterValue.add(heavy);

            greaterMap.put(light, greaterValue);

            ArrayList<Integer> lessValue = lessMap.get(heavy);
            lessValue.add(light);

            lessMap.put(heavy, lessValue);
        }//for end

        for (Integer key : greaterMap.keySet()) {
            bfs(key, criteria, greaterMap);
        }//for end

        for (Integer key : lessMap.keySet()) {
            bfs(key, criteria, lessMap);
        }//for end

        System.out.println(answerSet.size());
    }

    public static void bfs(Integer from, int criteria, Map<Integer, ArrayList<Integer>> map) {
        Queue<Integer> queue = new LinkedList<>();

        int cnt = 0;
        queue.add(from);

        while (!queue.isEmpty()) {
            Integer nowKey = queue.poll();

            ArrayList<Integer> nowValue = map.get(nowKey);
            int size = nowValue.size();

            if (size!=0) {
                cnt += size;

                if (cnt>=criteria) {
                    answerSet.add(from);
                    return;
                }

                for (int next : nowValue) {
                    queue.add(next);
                }//for end
            }

        }//while end
    }
}
