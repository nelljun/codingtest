package src.programmers;

public class 조이스틱 {

	public static void main(String[] args) {
		String name = "JEROEN";
		solution(name);
	}//main() end
	
	public static void solution(String name) {
		int count = 0;
		int length = name.length();
		
		for(int i=0; i<length; i++) {
			//상하 이동
			char character = name.charAt(i);
			if(character!='A') {
				count += Math.min(character-'A', 'Z'-character+1);
			}//if end
			
			
		}//for end
		System.out.println(count-1);
	}//solution() end
}
