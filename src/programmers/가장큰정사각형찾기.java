package src.programmers;

public class 가장큰정사각형찾기 {

	public static void main(String[] args) {
		int[][] board = {{0,1,1,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		solution(board);
	}//main() end

	public static int solution(int[][] board) {
		
		if(isAllZero(board)) return 0; 
		
		int max = 1;
		for(int i=1; i<board.length; i++) {
			for(int j=1; j<board[0].length; j++) {
				if(board[i][j]!=0) {
					board[i][j] = Math.min(Math.min(board[i][j-1], board[i-1][j-1]), board[i-1][j]) + 1;
					max = Math.max(board[i][j], max);
				}
			}//for end
		}//for end
		
		return max*max;
	}//solution() end
	
	public static boolean isAllZero(int[][] board ) {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(board[i][j]==1) return false;
			}//for end
		}//for end
		return true;
	}//isAllZero() end
	
}
