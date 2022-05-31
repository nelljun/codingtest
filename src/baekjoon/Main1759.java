package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main1759 {
    static char[] alphabet;
    static List<Character> vowelList = new ArrayList<>();
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder tempSb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //서로 다른 L개의 알파벳 소문자
        //최소 1개의 모음, 최소 2개의 자음
        //암호 내에서 증가하는 순서로 배열

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int length = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());

        String str = bf.readLine().replaceAll(" ", "");
        int strLen = str.length();
        alphabet = new char[strLen];
        for (int i = 0; i < strLen; i++) {
            char c = str.charAt(i);
            alphabet[i] = c;
            if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
                vowelList.add(c);
            }
        }//for end
        Arrays.sort(alphabet);

        isUsed = new boolean[alphabet.length];

        dfs(-1, 0, length, 0, 0);

        System.out.println(sb);
    }//main() end

    public static void dfs(int index, int nowLen, int len, int con, int vowel) {
        if (nowLen==len
                && con>=2
                && vowel>=1) {
            sb.append(tempSb.toString()).append("\n");
            return;
        }

        for (int i = index+1; i < alphabet.length; i++) {
            if (!isUsed[i]) {
                tempSb.append(alphabet[i]);
                isUsed[i] = true;
                if (vowelList.contains(alphabet[i])) {
                    //모음 추가
                    dfs(i, nowLen+1, len, con, vowel+1);
                } else {
                    //자음 추가
                    dfs(i, nowLen+1, len, con+1, vowel);
                }
                tempSb.deleteCharAt(tempSb.length()-1);
                isUsed[i] = false;
            }
        }//for end
    }//dfs() end

}
