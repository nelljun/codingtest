package src.programmers;

public class ī�� {

	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;
		solution(brown, yellow);
	}
	
	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		
		//����1. width>=length
		//����2. width, length>=3
		int width = 0, length = 0;
		
		//width * length = brown+yellow;
		int multiple = brown + yellow;
		//width + length = (brown+4)/2;
		int sum = (brown+4)/2;
		
		//w*l = multiple�̹Ƿ�
		//multiple�� �μ��� ã��, �� �� w+l = sum�� �Ǵ� ���� ����
		//����1, 2������ i�� 3����, ���� ������ Ž���ϹǷ� i�� length�� ��
		//i�� multiple�� �����ٱ����� Ž��
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
