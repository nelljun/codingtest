package src.programmers;

import java.util.LinkedHashMap;
import java.util.Map;

public class 다단계칫솔판매 {

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        solution(enroll, referral, seller, amount);
    }

    //<직원 이름, 이익금 총합> 담을 map
    static Map<String, Integer> profitMap;
    //<직원, 추천 직원> 담을 map
    static Map<String, String> referralMap;

    public static int[] solution(String[] enroll,
                                 String[] referral,
                                 String[] seller,
                                 int[] amount) {
        //직원 수
        int groupSize = enroll.length;
        //등록 순서 중요하니 LinkedHashMap으로 구현
        profitMap = new LinkedHashMap<>();
        referralMap = new LinkedHashMap<>();
        //map에 직원 등록
        for (int i = 0; i < groupSize; i++) {
            profitMap.put(enroll[i], 0);
            referralMap.put(enroll[i], referral[i]);
        }//for end

        //판매 정보 수
        int numOfData = seller.length;
        //판매 정보마다 이익금 분배
        for (int i = 0; i < numOfData; i++) {
            distribute(seller[i], amount[i] * 100);
        }//for end

        int[] answer = new int[groupSize];
        int index = 0;
        for (Integer value : profitMap.values()) {
            answer[index++] = value;
        }//for end

        return answer;
    }//solution() end

    //이익금 분배 (재귀)
    public static void distribute(String employee, int profit) {
        if (profit<10) {
            //이익금이 10원 미만이면 추천인에게 분배하지 않고 본인이 다 가진다.
            profitMap.put(employee, profitMap.get(employee)+profit);
            return;
        } else {
            /**
             * 이익금이 10원 이상이면,
             * 추천인에게 profit의 10%(원 단위 절사) 분배하고, 남은 이익금을 가진다.
             */
            //추천인에게 분배할 이익금
            int profitToRef = (int)(profit*0.1);
            //추천인
            String ref = referralMap.get(employee);

            //남은 이익금은 자신이 가진다.
            profitMap.put(employee, profitMap.get(employee) + profit-profitToRef);

            //현재 employee의 추천인이 있을 때만 재귀 호출
            if (!ref.equals("-")) {
                distribute(ref, profitToRef);
            }
        }//if~else end
    }//distribute() end
}
