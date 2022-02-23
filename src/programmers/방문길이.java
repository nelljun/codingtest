package src.programmers;

public class 방문길이 {

	public static void main(String[] args) {
		String dirs = "LULLLLLLU";
		solution(dirs);
	}//main() end
	
	//캐릭터 이동
	public static void solution(String dirs) {
		
		//가로선
		boolean[][] isVisitedHor = new boolean[11][10];
		//세로선
		boolean[][] isVisitedVer = new boolean[10][11];
		
		char[] dirArr = dirs.toCharArray();
		
		//캐릭터 위치 (0,0) -> {0, 0}로 저장
		//그래프의 (-5, -5)를 (0, 0)으로 가정
		//시작위치 = (5,5)
		int[] location = {5, 5};
		
		int count = 0;
		
		for(char dir : dirArr) {
//			System.out.println("location = {"+location[0]+", "+location[1]+"}");
			int x = location[0];
			int y = location[1];
			switch(dir) {
			case 'U': if(y==10) break;
					  if(!isVisitedVer[y+1][x+1]) {
							isVisitedVer[y+1][x+1] = true;
							count++;
					  }
					  location[1] += 1;
					  break;
			case 'D': if(y==0) break;
					  if(!isVisitedVer[y][x+1]) {
						  isVisitedVer[y][x+1] = true;
						  count++;
					  }
			  		  location[1] -= 1;
			  		  break; 
			case 'L': if(x==0) break;
					  if(!isVisitedHor[y+1][x]) {
						  isVisitedHor[y+1][x] = true;
						  count++;
					  }
				      location[0] -= 1;
				      break; 
			case 'R': if(x==10) break;
					  if(!isVisitedHor[y+1][x+1]) {
						  isVisitedHor[y+1][x+1] = true;
						  count++;
					  }
					  location[0] += 1;
					  break; 
			}//switch case end
		}//for end
		
		System.out.println(count);
	}//solution() end
}
