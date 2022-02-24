package src.programmers;

public class 단어변환 {

	static boolean[] visited;
	static int answer;
	
	public static void main(String[] args) {
		
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		solution(begin, target, words);
		
	}//main() end
	
	public static void solution(String begin, String target, String[] words) {
		
		visited = new boolean[words.length];
		
		dfs(begin, target, words, 0);
		
	}//solution() end
	
	public static void dfs(String now, String target, String[] words, int count) {
		if(now.equals(target)) {
			answer = (answer<=count) ? answer : count;
			return;
		}
		for(int i=0; i<words.length; i++) {
			if(!visited[i] && compareStr(now, words[i])) {
				now = words[i];
				visited[i] = true;
				dfs(now, target, words, ++count);
				visited[i] = false;
			}//if end
		}//for end
		
	}//dfs() end
	
	public static boolean compareStr(String word1, String word2) {
		int length = word1.length();
		int count = 0;
		
		for(int i=0; i<length && count<2; i++) {
			if(word1.charAt(i)!=word2.charAt(i)) count++;
		}//for end
		
		return count==1;
	}//compare
}
