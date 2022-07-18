package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int totalCnt = Integer.parseInt(bf.readLine());

        Map<Character, Integer> alphabetMap = new HashMap<>();

        for (int i = 0; i < totalCnt; i++) {
            String word = bf.readLine();
            int length = word.length();

            for (int j = 0; j < length; j++) {
                char now = word.charAt(j);
                int size = (int)Math.pow(10, length-1-j);

                alphabetMap.put(now, alphabetMap.getOrDefault(now, 0) + size);
            }//for end
        }//for end

        ArrayList<Integer> valueList = new ArrayList<>(alphabetMap.values());

        Collections.sort(valueList, (o1, o2) -> Integer.compare(o2, o1));

        int size = valueList.size();

        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += valueList.get(i) * (9-i);
        }//for end

        System.out.println(sum);
    }
}
