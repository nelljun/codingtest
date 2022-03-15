package src.programmers;

import java.util.Stack;

public class 짝지어제거하기 {

    public static void main(String[] args) {

    }//main() end

    public static int solution(String s) {
        Stack<Character> stk = new Stack<>();

        int length = s.length();

        for(int i=0; i<length; i++) {
            char strChar = s.charAt(i);
            if(!stk.isEmpty() && stk.peek()==strChar) {
                stk.pop();
            } else {
                stk.push(strChar);
            }//if~else end
        }//for end

        return stk.isEmpty()? 1 : 0;
    }//solution() end
}
