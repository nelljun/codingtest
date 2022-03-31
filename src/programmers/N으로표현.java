package src.programmers;

import java.util.HashSet;
import java.util.Set;

public class N으로표현 {
    public static void main(String[] args) {
        int result =solution(2, 11);
        System.out.println("result = " + result);
    }

    /**
     * N이 i개일 때 만들 수 있는 수 set[i-1]에 저장
     *
     * N이 i개일 때 만들 수 있는 수
     * = NN...N
     * + (N이 1개일 때의 수와 N이 i-1개일 때의 수들 끼리의 사칙연산)
     * + (N이 2개일 때..         i-2개일 때의 ....                )
     * ...
     * + (N이 i-1개일 때...      N의 1개일 때 ...                 )
     */
    public static int solution(int N, int number) {
        int answer = -1;

        Set<Long> set[] = new HashSet[8];


        for (int i = 1; i <= 8; i++) {
            set[i-1] = new HashSet<>();

            set[i-1].add(makeNN(N, i));

            for (int j = 1; j <= i-1; j++) {
                for (Long l1 : set[j-1]) {
                    for (Long l2 : set[i-j-1]) {
                        set[i-1].add(l1 + l2);
                        set[i-1].add(l1 * l2);
                        set[i-1].add(l1 - l2);
                        if (l2!=0) {
                            set[i-1].add(l1 / l2);
                        }
                    }//for end
                }//for end
            }//for end

            if (set[i-1].contains((long)number)) {
                answer = i;
                break;
            }
        }//for end

        return answer;

    }//solution() end

    public static long makeNN(int N, int num) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            sb.append(N);
        }//for end

        return Long.parseLong(sb.toString());
    }//makeNN() end
}
