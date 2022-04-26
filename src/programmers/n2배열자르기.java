package src.programmers;


import java.util.ArrayList;
import java.util.List;

public class n2배열자르기 {

    public static void main(String[] args) {
        solution(5, 5, 9);
    }//main() end

    public static int[] solution(int n, long left, long right) {
        List<Integer> answerList = new ArrayList<>();

        //left보다 작은 n의 배수 중 최댓값 구해 몇 번째 행인지 파악하기
        int leftQuo = (int)(left/n); //index가 leftQuo값인 행
        int leftRmd = (int)(left%n); //본인 행에 속하는 열
        //right보다 작은 n의 배수 중 최댓값 구해 몇 번째 행인지 파악하기
        int rightQuo = (int)(right/n);
        int rightRmd = (int)(right%n);

        if (leftQuo==rightQuo) {
            //left, right 같은 행
            for (int i = leftRmd; i <= rightRmd; i++) {
                if (i>=leftQuo) {
                    answerList.add(i+1);
                } else {
                    answerList.add(leftQuo+1);
                }
            }//for end
        } else {
            //left, right 다른 행

            //left 속하는 행
            for (int i = leftRmd; i < n; i++) {
                if (i>=leftQuo) {
                    answerList.add(i+1);
                } else {
                    answerList.add(leftQuo+1);
                }
            }//for end

            //중간 행
            while (++leftQuo<rightQuo) {
                for (int i = 0; i < n; i++) {
                    if (i>=leftQuo) {
                        answerList.add(i+1);
                    } else {
                        answerList.add(leftQuo+1);
                    }
                }//for end
            }//while end

            //right 속하는 행
            for (int i = 0; i <= rightRmd; i++) {
                if (i>=rightQuo) {
                    answerList.add(i+1);
                } else {
                    answerList.add(rightQuo+1);
                }
            }//for end
        }

        int size = answerList.size();
        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            answer[i] = answerList.get(i);
        }//for end

        return answer;
    }//solution() end

    public static void solution2(int n, long left, long right) {
        int size = (int)(right-left+1);

        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            int row = (int)(left/n + 1);
            int col = (int)(left%n + 1);

            if (row<col) {
                answer[i] = col;
            } else {
                answer[i] = row;
            }

            left++;
        }//for end
    }//solution() end
}
