package src.programmers;

public class 조이스틱 {

	public static void main(String[] args) {
		String name = "JEROEN";
		solution(name);
	}//main() end


	public static int solution(String name) {
		/**
		 * 알파벳 맞추기 + 이동으로 나눠서 생각
		 */
		//알파벳
		int length = name.length();

		int index = -1;

		int minHorMove = 0;
		int minVerMove = length-1;

		for (int i = 0; i < length; i++) {
			char alphabet = name.charAt(i);
			minHorMove += Math.min(alphabet-'A', 'Z'-alphabet+1);

			index = i+1;
			while (index<length && name.charAt(index)=='A') {
				index++;
			}//while end

			minVerMove = Math.min(minVerMove, 2*i + length - index);
			minVerMove = Math.min(minVerMove, 2*(length-index) + i);
		}//for end

		return minHorMove+minVerMove;
	}//solution() end


}
