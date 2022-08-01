package src.programmers;

public class 징검다리건너기 {
    public static void main(String[] args) {
        int[] stones = {200000, 200000000};
        solution(stones, 3);
    }

    public static int solution(int[] stones, int k) {
        int begin = 1;
        int end = 200000000;

        int answer = 0;

        while (begin <= end) {
            int mid = (begin + end) / 2;

            if (checkIfAcrossRiver(mid, k, stones)) {
                begin = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                end = mid - 1;
            }//if~else end
        }//while end

        return answer;
    }//solution() end

    public static boolean checkIfAcrossRiver(int numOfFriends, int k, int[] stones) {
        int length = stones.length;

        int belowCnt = 0;

        for (int i = 0; i < length; i++) {
            if (stones[i] < numOfFriends) {
                belowCnt++;
                if (belowCnt == k) {
                    return false;
                }//if end
            } else {
                belowCnt = 0;
            }//if~else end
        }//for end

        return true;
    }//checkIfAcrossRiver() end
}
