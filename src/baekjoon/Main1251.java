package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1251 {

    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String original = bf.readLine();

        set = new HashSet<>();

        dfs(1,2, original);

        List<String> list = new ArrayList<>(set);
        Collections.sort(list);

        System.out.println(list.get(0));
    }

    public static void dfs(int idx1, int idx2, String original) {
        int length = original.length();

        if (idx2==length-1 && idx1==length-2) {
            return;
        }

        String str1 = reverse(original.substring(0, idx1));
        String str2 = reverse(original.substring(idx1, idx2));
        String str3 = reverse(original.substring(idx2, length));

        set.add(str1+str2+str3);

        if (++idx2==length) {
            idx1++;
            idx2 = idx1+1;
        }

        dfs(idx1, idx2, original);
    }
    static StringBuilder sb = new StringBuilder();

    public static String reverse(String str) {
        sb.setLength(0);
        char[] chars = str.toCharArray();
        for (int i = chars.length-1; i >= 0 ; i--) {
            sb.append(chars[i]);
        }//for end
        return sb.toString();
    }

    //simple solution (no set, no dfs)
    public static void main2(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String original = bf.readLine();

        int length = original.length();

        List<String> list = new ArrayList<>();

        for (int i = 1; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                String str1 = reverse(original.substring(0, i));
                String str2 = reverse(original.substring(i, j));
                String str3 = reverse(original.substring(j, length));

                sb.setLength(0);
                sb.append(str1).append(str2).append(str3);
                list.add(sb.toString());
            }//for end
        }//for end

        Collections.sort(list);

        System.out.println(list.get(0));
    }
}
