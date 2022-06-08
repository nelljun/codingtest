package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1062 {
    static int words, max, total = 0;
    //a-z까지 배운 알파벳 체크하는 배열
    static boolean[] isLearned = new boolean[26];
    //a, n, t, i, c를 제외하고, 단어를 읽기 위해 배워야하는 알파벳 list
    static ArrayList<Character> alphabetList;
    //단어의 앞 "anta"와 뒤 "tica"를 제외한 가운데 부분을 저장할 배열
    static String[] wordArr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        words = Integer.parseInt(st.nextToken());
        total = Integer.parseInt(st.nextToken());

        //a, n, t, i, c는 기본적으로 배워야하기 때문에 5이상이어야 한다.
        //26은 모든 알파벳을 배우는 거니까 모든 단어를 다 배울 수 있다.
        if (total<5) {
            System.out.println(0);
            return;
        } else if (total==26) {
            System.out.println(words);
            return;
        }

        //a n t i c : 5개는 기본적으로 배워야만 한다.
        isLearned['a'-'a'] = true;
        isLearned['n'-'a'] = true;
        isLearned['t'-'a'] = true;
        isLearned['i'-'a'] = true;
        isLearned['c'-'a'] = true;

        wordArr = new String[words];
        //추가로 배워야할 알파벳을 저장할 임시 set
        Set<Character> tempSet = new HashSet<>();

        for (int i = 0; i < words; i++) {
            String word = bf.readLine();

            //"anta", "tica" 제거
            word = word.replace("anta", "").replace("tica", "");
            wordArr[i] = word;
            int length = word.length();

            for (int j = 0; j < length; j++) {
                char now = word.charAt(j);
                //가운데 부분에서 a, n, t, i, c가 아닌 알파벳이 있다면 set에 저장
                if (now!='a' && now!='n' && now!='t' && now!='i' && now!='c') {
                    tempSet.add(now);
                }
            }//for end
        }//for end

        //set -> list
        alphabetList = new ArrayList<>(tempSet);

        dfs(-1, 5);

        System.out.println(max);
    }

    public static void dfs(int index, int num) {
        /**
         * 해당 과정은 num==total이 아닐 때에도 진행해야 한다.
         * num이 total보다 작을 때에도,
         * (즉, 총 가르칠 알파벳 숫자를 다 채우지 않았을 때에도) 단어를 커버할 수 있기 때문에
         */
        //현재 상태까지 읽을 수 있는 단어의 수 변수
        int cnt = 0;
        //각 단어의 가운데 부분이 저장된 wordArr 탐색
        for (int i = 0; i < words; i++) {
            //flag
            boolean isOk = true;
            String nowStr = wordArr[i];
            int length = nowStr.length();

            for (int j = 0; j < length; j++) {
                char nowChar = nowStr.charAt(j);
                //만일 배우지 않은 알파벳이 있다면 flag = false, 반복 중단
                if (!isLearned[nowChar-'a']) {
                    isOk = false;
                    break;
                }
            }//for end
            //해당 단어에서 모든 알파벳을 다 배웠다면 cnt+1
            if (isOk) cnt++;
        }//for end
        //max와 cnt 중 큰 값으로 max를 갱신
        max = Math.max(max, cnt);

        //배울 수 있는 최대 알파벳 수만큼 배웠으면 이전 분기로 return
        if (num==total) return;

        int size = alphabetList.size();
        //조합이기 때문에 현재까지 선택한 알파벳의 다음 알파벳부터 탐색(index+1)
        for (int i = index+1; i < size; i++) {
            Character nowChar = alphabetList.get(i);
            //현재 알파벳을 배우지 않았다면 새로 배운다.
            if (!isLearned[nowChar-'a']) {
                isLearned[nowChar-'a'] = true;
                dfs(i, num+1);
                isLearned[nowChar-'a'] = false;
            }
        }//for end
    }
}
