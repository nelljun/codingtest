package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main1021 {

	public static void main(String[] args) throws IOException {
		LinkedList<Integer> deque = new LinkedList<Integer>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		
		
		StringTokenizer tokenizer = new StringTokenizer(bf.readLine(), " ");
		int size = Integer.parseInt(tokenizer.nextToken());
		int theNumber = Integer.parseInt(tokenizer.nextToken());
		int[] arr = new int[theNumber];
		
		for(int i=0; i<size; i++) {
			deque.add(i+1);
		}//for end
		
		tokenizer = new StringTokenizer(bf.readLine(), " ");
		
		for(int i=0; i<theNumber; i++) {
			arr[i] = Integer.parseInt(tokenizer.nextToken());
		}//for end
		
		int currentIdx = 0;
		int target = 0;
		int currentDequeSize = 0;
		for(int i=0; i<theNumber; i++) {
			currentIdx = deque.indexOf(arr[i])+1;
			currentDequeSize = deque.size();
			if(currentIdx-1<=currentDequeSize-currentIdx+1) {
				//왼쪽 방향으로 이동 (2번 연산) - 맨 앞 요소를 맨 뒤로 이동
				while(currentIdx>1) {
					target = deque.removeFirst();
					deque.addLast(target);
					count++;
					currentIdx--;
				}//while end
				deque.removeFirst();
			} else {
				//오른쪽 방향으로 이동 (3번 연산) - 맨 뒷 요소를 맨 앞으로 이동
				while(currentIdx!=1) {
					target = deque.removeLast();
					deque.addFirst(target);
					count++;					
					currentIdx = (++currentIdx)%currentDequeSize;
				}//while end
				deque.removeFirst();
			}//if~ end
		}//for end
		
		System.out.println(count);
			
	}//main() end
	
}
