package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < cnt; i++) {
            set.add(bf.readLine());
        }//for end

        List<String> list = new ArrayList<>(set);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int leng1 = o1.length();
                int leng2 = o2.length();

                if (leng1==leng2) {
                    return o1.compareTo(o2);
                }
                return leng1-leng2;
            }
        });

        int size = list.size();

        for (int i = 0; i < size; i++) {
            System.out.println(list.get(i));
        }//for end

    }
}
