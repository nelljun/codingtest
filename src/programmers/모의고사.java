package src.programmers;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {

	public static void main(String[] args) {
		int[] answers1 = {1,2,3,4,5};
		int[] answers2 = {1,3,2,4,2};
		
		solution(answers1);
		solution(answers2);
	}//main() end
	
	public static void solution(int[] answers) {
		int[] student1 = {1,2,3,4,5};
		int[] student2 = {2,1,2,3,2,4,2,5};
		int[] student3 = {3,3,1,1,2,2,4,4,5,5};
		
		int[][] studentArr = {student1, student2, student3};
		int[] results = new int[studentArr.length];
		
		for(int i=0; i<studentArr.length; i++) {
			int count = 0;
			int[] student = studentArr[i];
			for(int j=0; j<answers.length; j++) {
				if(answers[j] == student[j%student.length]) {
					count++;
				}//if end
			}//for end
			results[i] = count;
		}//for end
		
		//최대 정답 수
		int maxResult = 0;
		for(int i=0; i<results.length; i++) {
			if(results[i]>maxResult) maxResult = results[i];
		}//for end
		
		List<Integer> list = new ArrayList<>();
		
		//최대 정답 수에 해당하는 사람 배열
		for(int i=0; i<studentArr.length; i++) {
			if(results[i]==maxResult) {
				list.add(i+1);
			}//if end
		}//for end
		
		int[] answer = new int[list.size()];
		for(int i=0; i<answer.length; i++) {
			answer[i] = list.get(i);
		}//for end
		
	}//solution() end
}
