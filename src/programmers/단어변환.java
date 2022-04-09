package src.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
	
	public static void main(String[] args) {
		
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		solution(begin, target, words);
		
	}//main() end

	static boolean[] isUsed;
	
	public static int solution(String begin, String target, String[] words) {

		boolean isOkToGo = false;

		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(target)) {
				isOkToGo = true;
				break;
			}
		}//for end
		if (!isOkToGo) {
			return 0;
		}

		isUsed = new boolean[words.length];

		return bfs(begin, target, words);
		
	}//solution() end
	
	public static int bfs(String begin, String target, String[] words) {

		Queue<String> queue = new LinkedList<>();

		int arrLength = words.length;
		int distFromBegin = 0;
		boolean isFoundTarget = false;

		queue.add(begin);

		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- != 0) {
				String nowStr = queue.poll();

				if (nowStr.equals(target)) {
					isFoundTarget = true;
					break;
				}

				for (int i = 0; i < arrLength; i++) {
					if (compareStr(nowStr, words[i]) && !isUsed[i]) {
						queue.add(words[i]);
					}
				}//for end
			}//while end
			if (isFoundTarget) {
				break;
			}
			distFromBegin++;
		}//while end

		return isFoundTarget? distFromBegin : 0;
	}//dfs() end


	//1개 차이
	public static boolean compareStr(String str1, String str2) {
		char[] charArr1 = str1.toCharArray();
		char[] charArr2 = str2.toCharArray();

		int length = str1.length();

		int count = 0;
		for (int i = 0; i < length; i++) {
			if (charArr1[i]!=charArr2[i]) count++;
		}//for end

		return count==1;
	}

	static int min = 100;


	public static int solution2(String begin, String target, String[] words) {
		boolean isOkToGo = false;

		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(target)) {
				isOkToGo = true;
				break;
			}
		}//for end
		if (!isOkToGo) {
			return 0;
		}

		isUsed = new boolean[words.length];

		dfs(0, begin, target, words);

		return min;
	}//solution() end
	//dfs
	public static void dfs(int count, String now, String target, String[] words) {
		if (now.equals(target)) {
			min = Math.min(min, count);
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (compareStr(now, words[i]) && !isUsed[i]) {
				isUsed[i] = true;
				dfs(count+1, words[i], target, words);
				isUsed[i] = false;
			}
		}//for end
	}

}
