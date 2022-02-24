package src.programmers;

public class 타겟넘버 {

	public static void main(String[] args) {
		int[] numbers = {4,1,2,1};
		int target = 4;
		
		solution(numbers, target);
	}//main() end
	
	public static void solution(int[] numbers, int target) {
		
		dfs(0, 0, numbers, target);
		
		System.out.println("count : "+count);
		
	}//solution() end
	
	static int count = 0;
	public static void dfs(int index, int sum, int[] numbers, int target) {
		//중단조건
		if(index==numbers.length) {
			if(sum==target) {
				count++;
			}
			return;
		}//if end
		
		dfs(index+1, sum+numbers[index], numbers, target);
		dfs(index+1, sum-numbers[index], numbers, target);
	}//combination
}
