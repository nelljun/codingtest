package src.programmers;

import java.util.HashSet;

public class 영어끝말잇기 {

    public static void main(String[] args) {
        String[] arr1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        String[] arr2 = {"hello", "observe", "effect", "take", "either",
                "recognize", "encourage", "ensure", "establish",
                "hang", "gather", "refer", "reference", "estimate", "executive"};
        String[] arr3 = {"hello", "one", "even", "never", "now", "world", "draw"};

        solution2(3, arr1);
    }//main() end

    public static void solution(int n, String[] words) {
        String prevLast = words[0].substring(0,1);

        int[] answer = new int[2];

        int size = words.length;
        for(int i=0; i<size; i++) {

            int length = words[i].length();
            //잘못된 시작 알파벳
            if(!words[i].substring(0,1).equals(prevLast)) {
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                break;
            }//if end

            //앞에 나왔던 단어와 반복
            boolean isRepeated = false;
            for(int j=0; j<i; j++) {
                if(words[i].equals(words[j])) {
                    isRepeated = true;
                    answer[0] = i%n + 1;
                    answer[1] = i/n + 1;
                    break;
                }//if end
            }//for end
            if(isRepeated) break;

            prevLast = words[i].substring(length-1, length);

        }//for end

        System.out.println("{"+answer[0]+", "+answer[1]+"}");
    }//solution() end

    //다른풀이
    //substring 대신 charAt 사용
    //반복 확인 위해 Set 사용
    public static void solution2(int n, String[] words) {

        //말한 단어 담을 Set
        HashSet<String> wordSet = new HashSet<>();

        char prevLast = words[0].charAt(0);

        int[] answer = new int[2];

        int size = words.length;

        for(int i=0; i<size; i++) {

            int length = words[i].length();
            //전 단어 끝과 현재 단어 시작 알파벳 비교
            if(words[i].charAt(0)!=prevLast) {
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                break;
            }//if end

            //앞에 나왔던 단어와 반복 확인
            //현재 단어 set에 add하고 size확인
            wordSet.add(words[i]);
            if(wordSet.size() != i+1) {
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                break;
            }//if end

            prevLast = words[i].charAt(length-1);

        }//for end

        System.out.println("{"+answer[0]+", "+answer[1]+"}");
    }//solution2() end
}
