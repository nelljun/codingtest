package src.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {

	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
		int[][] computers2 = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
		
		solution2(4, computers2);
	}

	static int[] parent;

	//union-find
	public static int solution(int n, int[][] computers) {
		//초기화
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}//for end

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i!=j && computers[i][j]==1) {
					//서로 다른 컴퓨터가 연결되어 있다면
					union(i, j);
				}
			}//for end
		}//for end

		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (parent[i]==i) answer++;
		}//for end

		return answer;
	}

	//루트끼리 연결해주는 union
	public static void union(int idx1, int idx2) {
		idx1 = find(idx1);
		idx2 = find(idx2);

		if (idx1<idx2) {
			parent[idx2] = idx1;
		} else {
			parent[idx1] = idx2;
		}
	}

	//해당 index의 루트 노드 찾아주는 find
	public static int find(int index) {
		if (index==parent[index]) {
			return index;
		}

		return find(parent[index]);
	}



	static boolean[] isIncluded;

	//bfs
	public static int solution2(int n, int[][] computers) {
		isIncluded = new boolean[n];

		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (!isIncluded[i]) {
				answer++;
				bfs(i, n, computers);
			}
		}//for end
		return answer;
	}//solution() end

	public static void bfs(int node, int n, int[][] computers) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(node);
		isIncluded[node] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 0; i < n; i++) {
				if (now!=i
						&& computers[now][i]==1
						&& !isIncluded[i]) {
					queue.add(i);
					isIncluded[i] = true;
				}
			}//for end
		}//while end
	}

	//dfs
	public static int solution3(int n, int[][] computers) {
		isIncluded = new boolean[n];

		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (!isIncluded[i]) {
				answer++;
				dfs(i, n, computers);
			}
		}//for end
		return answer;
	}//solution() end

	public static void dfs(int node, int n, int[][] computers) {
		isIncluded[node] = true;

		for (int i = 0; i < n; i++) {
			if (computers[node][i]==1 && !isIncluded[i]) {
				dfs(i, n, computers);
			}
		}//for end
	}
}
