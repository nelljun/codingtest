package src.programmers;

import java.util.Stack;

public class 괄호회전하기 {

    public static void main(String[] args) {
        String s = "{}[]()";
        solution(s);
    }//main() end

    static Stack<Integer> stk = new Stack<>();

    public static int solution(String s) {
        int answer = 0;

        int length = s.length();
        //길이 홀수일 땐 무조건 올바르지 않다.
        if(length%2==1) return 0;

        StringBuilder sb = new StringBuilder();

        //하나씩 회전하면서 확인
        for(int i=0; i<length; i++) {
            sb.append(s.substring(i, length)).append(s.substring(0,i));
            if(isAlright(sb.toString())) answer++;
            //sb 초기화
            sb.setLength(0);
        }//for end

        return answer;
    }//solution() end

    //올바른 괄호 문자열 체크
    public static boolean isAlright(String s) {
        boolean result = true;

        int length = s.length();
        int currentNum;
        for(int i=0; i<length; i++) {
            currentNum = changeToNum(s.charAt(i));
            if(currentNum < 4) {
                //왼쪽 방향이면 일단 stack에 저장
                stk.add(currentNum);
            } else {
                //오른쪽 방향이면 stk.peek()과 짝(합이 7)이라면 ok, 아니면 false return;
                if(!stk.isEmpty() && stk.peek()+currentNum == 7) {
                    stk.pop();
                } else {
                    result = false;
                    break;
                }//if~else end
            }//if~else end
        }//for end

        //모든 과정 끝난 후, stack에 남아있다면 올바르지 않은 경우다.
        if(!stk.isEmpty()) result = false;

        return result;
    }//isAlright() end

    public static int changeToNum(char par) {
        int result = 0;

        switch(par) {
            case '(' : result = 1;
            break;
            case '{' : result = 2;
            break;
            case '[' : result = 3;
            break;
            case ']' : result = 4;
            break;
            case '}' : result = 5;
            break;
            case ')' : result = 6;
            break;
        }//switch case end

        return result;
    }//changeToNum() end
}
