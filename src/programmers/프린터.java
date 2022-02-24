package src.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 프린터 {
	
	static Integer[] dump = {0, -1};
	
	public static void main(String[] args) {
		int[] priorities = {1,1,9,1,1,1};
		int location = 0;
		int result = solution(priorities, location);
		System.out.println(result);
	}
	
	public static int solution(int[] priorities, int location) {

		//요청리스트
		Queue<Integer[]> reqList = new LinkedList<>();
		//실제 인쇄리스트
		List<Integer> printList = new ArrayList<>();
		
		//{중요도, 인덱스}형태의 Integer배열을 Queue구조로 저장
		int nodeIdx = 0;
		for(int priority : priorities) {
			Integer[] newNode = {priority, nodeIdx++};
			reqList.add(newNode);
		}//for end
		
		//중요도를 정렬함 (여기선 오름차순)
		//내가 poll한 프린트의 중요도가 남아있는 프린트 요청 리스트에서 가장 높은지 확인하기 위해
		Arrays.sort(priorities);
		
		Integer[] top = dump;
		
		//queue에서 poll한 요소의 중요도와, sort한 priorities배열의 뒤 요소(내림차순 정리했으므로)를 비교
		int index = priorities.length-1;
		while(printList.size()<priorities.length) {
			top = reqList.poll();
			if(top[0]==priorities[index]) {
				//현재 top의 중요도와 priorities배열 값이 같으므로
				//printList에 해당 top의 location(index)를 add
				printList.add(top[1]);
				//현재 index의 priorities요소가 print됐으므로
				//그 다음 index로 이동 (내림차순 정리이므로 -1)
				index--;
			} else {
				//다르다면, 현재 top의 중요도가 남은 요청 리스트의 중요도 중에서
				//가장 높은 것이 아니므로 요청 리스트의 맨 뒤로 add
				reqList.add(top);
			}
		}
		
		int i = 0;
		for(i=0; i<printList.size(); i++) {
			if(printList.get(i)==location) break;
		}//for end
		
		return i+1;
    }
	
}

//1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
//2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
//3. 그렇지 않으면 J를 인쇄합니다.