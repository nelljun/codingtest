package src.programmers;

public class 카펫 {

	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;
		solution(brown, yellow);
	}
	
	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		
		//조건1. width>=length
		//조건2. width, length>=3
		int width = 0, length = 0;
		
		//width * length = brown+yellow;
		int multiple = brown + yellow;
		//width + length = (brown+4)/2;
		int sum = (brown+4)/2;
		
		//w*l = multiple이므로
		//multiple의 인수를 찾고, 그 중 w+l = sum이 되는 것이 정답
		//조건1, 2때문에 i는 3부터, 작은 수부터 탐색하므로 i가 length가 됨
		//i는 multiple의 제곱근까지만 탐색
		for(int i=3; i<=(int)Math.sqrt(multiple); i++) {
			if(multiple%i==0) {
				length = i;
				width = multiple/i;
			}
			if(sum == (width+length)) {
				answer[0] = width;
				answer[1] = length;
				break;
			}
 		}//for end
		
		return answer;
	}//solution() end
}
