package src.programmers;

public class πÊπÆ±Ê¿Ã {

	public static void main(String[] args) {
		String dirs = "LRLRL";
		solution(dirs);
	}//main() end
	
	public static void solution(String dirs) {

		char[] charArr = dirs.toCharArray();

		//(y¡¬«•, x¡¬«•, πÊ«‚)
		boolean[][][] isVisited = new boolean[11][11][4];

		int x = 5, y = 5;
		int newX = 0, newY = 0;
		int dir = -1;
		int cnt = 0;
		int[] dirColNum = {1, 0, -1, 0};
		int[] dirRowNum = {0, 1, 0, -1};
		for(char dirChar : charArr) {
			System.out.println("location : ("+x+", "+y+")");
			switch(dirChar) {
				case 'U': dir=0;
				break;
				case 'R': dir=1;
				break;
				case 'D': dir=2;
				break;
				case 'L': dir=3;
				break;
			}//switch case end
			newX = x + dirRowNum[dir];
			newY = y + dirColNum[dir];
			if(!isInRange(newX, newY)) {
				continue;
			}
			if(!isVisited[y][x][dir]) {
				isVisited[y][x][dir] = true;
				cnt++;
				isVisited[newY][newX][(dir+2)%4] = true;
			}
			x = newX;
			y = newY;
		}//for end
		System.out.println(cnt);
	}//solution2() end

	public static boolean isInRange(int x, int y) {
		return (0<=x && x<=10
				&& 0<=y && y<=10);
	}

	public static void printLocation(int[] location) {
		System.out.println("("+location[0]+", "+location[1]+")");
	}
}
