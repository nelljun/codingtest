package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2447 {
	
	private static String[][] plate;
	private static StringBuilder sb;

	static void star(String[][] plate, int x, int y, int size) {
		if(size==1) {
			plate[x][y] = "*";
			return;
		}
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(!(i==1 && j==1)) {
					star(plate, x+i*(size/3), y+j*(size/3), size/3);
				}
			}//for end
		}//for end
	}//star() end
	
	static void print() {
		sb = new StringBuilder();
		for(int i=0; i<plate.length; i+=1) {
			for(int j=0; j<plate.length; j+=1) {
				sb.append((plate[i][j]==null)? " " : "*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		plate = new String[n][n];
		star(plate, 0, 0, n);
		print();
		
	}
}
