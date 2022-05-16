package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1713 {

    static Map<Integer, Integer> map = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int totalCnt = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        while (st.hasMoreTokens()) {
            int recomm = Integer.parseInt(st.nextToken());

            update(recomm, N);
        }//while end

        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < keyList.size(); i++) {
            sb.append(keyList.get(i)).append(" ");
        }//for end

        System.out.println(sb);
    }

    public static void update(int recomm, int N) {
        if (map.containsKey(recomm)) {
            map.put(recomm, map.get(recomm)+1);
        } else {
            if (map.size()<N) {
                map.put(recomm, 1);
            } else {
                //빈 자리 없는데 새 학생이 추천을 받은 경우
                ArrayList<Integer> values = new ArrayList<>(map.values());
                Collections.sort(values);
                //최소 추천 수
                int min = values.get(0);

                //LinkedHashMap으로 구현했기 때문에 가장 앞 index의 최소 추천 수 가진 학생을 삭제하면 된다.
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

                while (iterator.hasNext()) {
                    if(iterator.next().getValue().equals(min)) {
                        iterator.remove();
                        break;
                    }
                }

                map.put(recomm, 1);
            }
        }
    }
}
