package src.programmers;

public class �湮���� {

	public static void main(String[] args) {
		String dirs = "LULLLLLLU";
		solution(dirs);
	}//main() end
	
	//ĳ���� �̵�
	public static void solution(String dirs) {
		
		//���μ�
		boolean[][] isVisitedHor = new boolean[11][10];
		//���μ�
		boolean[][] isVisitedVer = new boolean[10][11];
		
		char[] dirArr = dirs.toCharArray();
		
		//ĳ���� ��ġ (0,0) -> {0, 0}�� ����
		//�׷����� (-5, -5)�� (0, 0)���� ����
		//������ġ = (5,5)
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
