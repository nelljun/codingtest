package src.programmers;

public class 네트워크 {

	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
		
		solution(n, computers);
	}
	
	public static void solution(int n, int[][] computers) {
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(computers[i][j]==1) count++;
			}//for end
		}//for end
		
		int pair = (count-n)/2;
		System.out.println("answer : "+(n-pair));
	}
	public static void dfs() {
		
	}//dfs() end
}
