package src.programmers;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class 입국심사 {
    public static void main(String[] args) {
        int[] times = {4, 3, 1, 1, 1};
        solution(5, times);
    }

    public static long solution(int n, int[] times) {
        Arrays.sort(times);

        long min = 0L;
        long max = (long)times[0] * n;
        long answer = 0L;

        while (min<=max) {
            long mid = (max+min) / 2;

            if (getNumOfComp(mid, times) < n) {
                min = mid+1;
            } else {
                answer = mid;
                max = mid-1;
            }
        }//while end

        return answer;
    }//solution() end

    public static long getNumOfComp(long time, int[] times) {
        long result = 0L;

        for (int t : times) {
            result += time / t;
        }//for end

        return result;
    }//getNumOfComp() end
}
