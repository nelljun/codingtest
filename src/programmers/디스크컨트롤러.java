package src.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;


public class ��ũ��Ʈ�ѷ� {
	
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
        //1���� ���μ����� �� �ɸ��� �ð� = ���ð� + �ҿ�ð�
        //���ð��� �ּ�ȭ�ϴ� �� ����
		
		//���۽ð��� �������� �� pq (��������)
        PriorityQueue<Job> minStartPQ = new PriorityQueue<>(
        		new Comparator<Job>() {
        			@Override
        			public int compare(Job job1, Job job2) {
        				return job1.startTime - job2.startTime;
        			}
				});
        //�ҿ�ð��� �������� �� pq (��������)
        PriorityQueue<Job> minRequiredPQ = new PriorityQueue<>(
        		new Comparator<Job>() {
        			@Override
        			public int compare(Job job1, Job job2) {
        				return job1.requiredTime - job2.requiredTime;
        			}
				});
        
        //�ּҽ��۽ð�pq�� job ����
        for(int[] jobInfo : jobs) {
        	Job job = new Job(jobInfo[0], jobInfo[1]);
        	minStartPQ.add(job);
        }//for end
        
        //�� pq�� ��� �� ������ �ݺ�
        while(!minStartPQ.isEmpty() || !minRequiredPQ.isEmpty()) {
	        //���� �ð����� ��û �� �۾��� minRequiredPQ�� ����
	        //��, ���� ó���� �� �ִ� �۾����� ����
	        while(!minStartPQ.isEmpty() 
	        		&& (currentTime >= minStartPQ.peek().startTime)) {
	        	Job availableJob = minStartPQ.poll();
	        	minRequiredPQ.add(availableJob);
	        }
	        
	        if(minRequiredPQ.isEmpty()) {
	        	//���� �ð��� ó���� �� �ִ� �۾��� ���� ��,
	        	//��, �۾� ���̿� ������ �ִ� ���
	        	Job nextJob = minStartPQ.peek();
	        	currentTime = nextJob.startTime;
	        } else {
	        	//���������� �۾�ó��
		        Job onGoingJob = minRequiredPQ.poll();
		        //�۾��� ��û���� ������� �ɸ� �ð� ��� (���ð� + ó���ð�)
		        int waitingTime = currentTime - onGoingJob.startTime;
		        sum += (onGoingJob.requiredTime + waitingTime);
		        //�۾�ó�� �� ���� �ð� �̵�
		        currentTime += onGoingJob.requiredTime;
	        }
	        
	        System.out.println("�۾� �� currentTime : "+ currentTime);
	        
        }//while end
        
        int answer = (sum / jobs.length);
        
        System.out.println(answer);
        
        
        
    }//solution() end
	
}
