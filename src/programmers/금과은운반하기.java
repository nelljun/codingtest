package src.programmers;

public class 금과은운반하기 {
    public static void main(String[] args) {
        int[] g = {70, 70, 0};
        int[] s = {0, 0, 500};
        int[] w = {100, 100, 2};
        int[] t = {4, 8, 1};
        solution(90, 500, g, s, w, t);
    }

    public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        int numOfCities = g.length;

        long min = 0L;
        /**
         * 최악의 경우
         * 한 번에 1만큼만 옮길 수 있고,
         * 편도당 10^5 시간이 걸리고, -> (2 * 1e5)
         * 금 10^9kg, 은 10^9kg 옮겨야하는 상황 -> (2 * 1e9)
         */
        long max = (long)(1e9 * 2 * 1e5 * 2);
        long mid = 0L;
        long answer = 0L;

        //이분탐색
        while (min<=max) {
            mid = (max + min) / 2;

            //mid 시간 동안 모든 도시에서 옮길 수 있는 최대 광물의 양의 합 (금+은)
            long totalMaxSum = 0L;
            //mid 시간 동안 모든 도시에서 옮길 수 있는 최대 금의 양의 합
            long goldMaxSum = 0L;
            //mid 시간 동안 모든 도시에서 옮길 수 있는 최대 양의 양의 합
            long silverMaxSum = 0L;

            for (int i = 0; i < numOfCities; i++) {
                //mid 시간 동안 i도시에서 옮길 수 있는 최대 광물의 양
                long totalMax =  Math.min(w[i] * (((mid/t[i])+1)/2), g[i]+s[i]);

                totalMaxSum += totalMax;

                //옮길 수 있는 최대 광물의 양이 최대 금(은)의 양을 넘으면
                //최대 금(은)의 양까지만 운반 가능
                goldMaxSum += Math.min(totalMax, g[i]); //금 우선 운반
                silverMaxSum += Math.min(totalMax, s[i]); // 은 우선 운반
            }//for end

            /**
             * 최대 금의 양의 합이 a를 넘고,
             * 최대 은의 양의 합이 b를 넘고,
             * 총 합이 a+b를 넘는지 확인!
             */
            if (goldMaxSum >= a && silverMaxSum >= b && totalMaxSum >= a+b) {
                max = mid - 1;
                answer = mid;
            } else {
                min = mid + 1;
            }
        }//while end

        return answer;

    }//solution() end
}
