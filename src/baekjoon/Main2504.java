package src.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2504 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();
        int length = str.length();

        Stack<Character> stk = new Stack<>();

        int result = 0;
        int temp = 1;

        for (int i = 0; i < length; i++) {
            char now = str.charAt(i);

            if (now=='(') {
                stk.push(now);
                temp *= 2;
            } else if (now=='[') {
                stk.push(now);
                temp *= 3;
            } else if (now==')') {
                //stack이 비었거나 짝이 안맞으면 출력 후 리턴
                if (stk.isEmpty() || stk.peek()!='(') {
                    System.out.println(0);
                    return;
                }
                if (str.charAt(i-1)=='(') {
                    result += temp;
                }
                stk.pop();
                temp /= 2;
            } else if (now==']') {
                if (stk.isEmpty() || stk.peek()!='[') {
                    System.out.println(0);
                    return;
                }
                if (str.charAt(i-1)=='[') {
                    result += temp;
                }
                stk.pop();
                temp /= 3;
            }
        }//for end

        if (!stk.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
