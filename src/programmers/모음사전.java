package src.programmers;

import java.util.ArrayList;
import java.util.List;

public class 모음사전 {

    static List<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solutionDFS("I");
    }//main() end

    public static void solution(String word) {
        int answer = 0;

        char[] charWord = word.toCharArray();

        int[] intArr = {781, 156, 31, 6, 1};

        for(int i=0; i<charWord.length; i++) {
            int num = -1;
            switch(charWord[i]) {
                case 'A' : num = 0;
                break;
                case 'E' : num = 1;
                break;
                case 'I' : num = 2;
                break;
                case 'O' : num = 3;
                break;
                case 'U' : num = 4;
                break;
            }//switch case end
            answer += intArr[i] * num + 1;
        }//for end

        System.out.println(answer);
    }//solution() end

    //dfs 풀이1
    public static void solutionDFS(String word) {
        dfs("", 0);
        System.out.println(list.indexOf(word));
    }//solutionDFS() end

    public static void dfs(String str, int length) {
        if(length>5) return;
        list.add(str);
        for(int i=0; i<5; i++) {
            dfs(str+"AEIOU".charAt(i), length+1);
        }//for end
    }//dfs() end

    //dfs 풀이2. StringBuilder 활용
    public static void solutionDFS2(String word) {
        dfs2();
        System.out.println(list.indexOf(word));
    }//solutionDFS2() end

    public static void dfs2() {
        if(sb.length()>5) return;
        list.add(sb.toString());
        for(int i=0; i<5; i++) {
            sb.append("AEIOU".charAt(i));
            dfs2();
            sb.deleteCharAt(sb.length()-1);
        }//for end
    }//dfs() end

}
