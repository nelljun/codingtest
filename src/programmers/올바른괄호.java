package src.programmers;

import java.util.Stack;

public class 올바른괄호 {
	
	public static void main(String[] args) {
		String s = "))";
		solution2(s);
	}//main() end

	public static boolean solution(String s) {
		
		boolean answer = true;
		
		int openCnt = 0;
		int closeCnt = 0;
		
		char[] charArr = s.toCharArray();
		
		for(char charParen : charArr) {
			if(charParen=='(')  {
				openCnt++;
			} else {
				if(++closeCnt>openCnt) {
					return false;
				}
			}//if else end
		}//for end
		
		return (openCnt==closeCnt);
		
	}//solution() end
	
	//Stack 활용
	public static boolean solution2(String s) {
		
		Stack<Character> openStk = new Stack<>();
		
		char[] charArr = s.toCharArray();
		
		for(char charParen : charArr) {
			if(charParen=='(') {
				openStk.add(charParen);
			} else {
				if(openStk.isEmpty()) {
					return false;
				} else {
					openStk.pop();
				}
			}//if else end
		}//for end
		
		return openStk.isEmpty();
	}//solution2() end
}
