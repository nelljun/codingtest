package src.programmers;

public class ���̽�ƽ {

	public static void main(String[] args) {
		String name = "JEROEN";
		solution(name);
	}//main() end
	
	public static void solution(String name) {
		int count = 0;
		int length = name.length();
		
		for(int i=0; i<length; i++) {
			//���� �̵�
			char character = name.charAt(i);
			if(character!='A') {
				count += Math.min(character-'A', 'Z'-character+1);
			}//if end
			
			
		}//for end
		System.out.println(count-1);
	}//solution() end
}
