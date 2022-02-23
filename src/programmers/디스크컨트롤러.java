package src.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;


public class 디스크컨트롤러 {
	
	public static void main(String[] args) {
		int[][] jobs = {{0,3}, {4,3}, {10,3}};
		solution(jobs);
	}
	
	public static class Job {
		int startTime;
		int requiredTime;
		
		Job(int startTime, int requiredTime) {
			this.startTime = startTime;
			this.requiredTime = requiredTime;
		}
		
	}
	public static void solution(int[][] jobs) {
        
		int currentTime = 0;
		int sum = 0;
        //1개의 프로세스의 총 걸리는 시간 = 대기시간 + 소요시간
        //대기시간을 최소화하는 게 목적
		
		//시작시간을 기준으로 한 pq (오름차순)
        PriorityQueue<Job> minStartPQ = new PriorityQueue<>(
        		new Comparator<Job>() {
        			@Override
        			public int compare(Job job1, Job job2) {
        				return job1.startTime - job2.startTime;
        			}
				});
        //소요시간을 기준으로 한 pq (오름차순)
        PriorityQueue<Job> minRequiredPQ = new PriorityQueue<>(
        		new Comparator<Job>() {
        			@Override
        			public int compare(Job job1, Job job2) {
        				return job1.requiredTime - job2.requiredTime;
        			}
				});
        
        //최소시작시간pq에 job 적재
        for(int[] jobInfo : jobs) {
        	Job job = new Job(jobInfo[0], jobInfo[1]);
        	minStartPQ.add(job);
        }//for end
        
        //두 pq가 모두 빌 때까지 반복
        while(!minStartPQ.isEmpty() || !minRequiredPQ.isEmpty()) {
	        //현재 시간까지 요청 온 작업을 minRequiredPQ에 적재
	        //즉, 현재 처리할 수 있는 작업들을 모음
	        while(!minStartPQ.isEmpty() 
	        		&& (currentTime >= minStartPQ.peek().startTime)) {
	        	Job availableJob = minStartPQ.poll();
	        	minRequiredPQ.add(availableJob);
	        }
	        
	        if(minRequiredPQ.isEmpty()) {
	        	//현재 시간에 처리할 수 있는 작업이 없을 때,
	        	//즉, 작업 사이에 공백이 있는 경우
	        	Job nextJob = minStartPQ.peek();
	        	currentTime = nextJob.startTime;
	        } else {
	        	//실질적으로 작업처리
		        Job onGoingJob = minRequiredPQ.poll();
		        //작업의 요청부터 종료까지 걸린 시간 계산 (대기시간 + 처리시간)
		        int waitingTime = currentTime - onGoingJob.startTime;
		        sum += (onGoingJob.requiredTime + waitingTime);
		        //작업처리 후 현재 시간 이동
		        currentTime += onGoingJob.requiredTime;
	        }
	        
	        System.out.println("작업 후 currentTime : "+ currentTime);
	        
        }//while end
        
        int answer = (sum / jobs.length);
        
        System.out.println(answer);
        
        
        
    }//solution() end
	
}
