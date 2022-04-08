package src.programmers;

import java.util.ArrayList;
import java.util.List;

public class 줄서는방법 {
    public static void main(String[] args) {
        solution(4, 6);
    }

    public static int[] solution(int n, long k) {
        //1~n까지 담을 list
        List<Integer> numList = new ArrayList<>();
        //index와 수를 맞추기 위해 index 0 채움
        numList.add(0);
        long factorial = 1L;

        for (int i = 1; i <= n; i++) {
            factorial *= i;
            numList.add(i);
        }//for end

        //k번째 배열의 숫자 순서대로 담을 list
        List<Integer> answerList = new ArrayList<>();

        //한 자리에서 다음 숫자로 넘어갈 기준 
        long criteria = factorial;

        for (int i = n; i >= 1; i--) {
            criteria /= i;

            /**
             * 현재 자리에서 몇 번째 그룹인지? num!
             * k / criteria 값의 올림값! 
             */
            int num = (int)(k / criteria);
            num += (k % criteria == 0)? 0 : 1;

            /**
             * num번째 그룹에 속하므로 
             * 남은 수 중에서 num번째 수 배치 후 numList에서 삭제
             */
            answerList.add(numList.get(num));
            numList.remove(num);

            //직전 그룹까지의 숫자 빼고 남은 값으로 k 세팅
            k %= criteria;

            /**
             * k ==0은 남은 그룹에서 맨 마지막에 해당하는 요소이므로
             * 남은 자리에 남은 숫자를 역순으로 배치!하면 배열 끝
             */
            if (k==0) {
                while (numList.size()!=1) {
                    answerList.add(numList.get(numList.size()-1));
                    numList.remove(numList.size()-1);
                }//while end
                break;
            }
        }//for end

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = answerList.get(i);
        }//for end

        return answer;

    }//solution() end
}
