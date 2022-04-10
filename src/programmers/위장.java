package src.programmers;

import java.util.*;

public class 위장 {

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        solution(clothes);
    }
    public static int solution(String[][] clothes) {
        //<종류, 해당 종류 옷의 갯수> 형식의 map구조
        HashMap<String, Integer> clothesMap = new HashMap<>();

        for (String[] cloth : clothes) {
            //key가 cloth[1]인 value값이 있으면 그 값의 + 1하고,
            //없으면 0에 +1 한다.
            clothesMap.put(cloth[1], clothesMap.getOrDefault(cloth[1], 0)+1);
        }//for end

        //map 탐색할 iterator
        Iterator<Integer> iterator = clothesMap.values().iterator();

        /**
         * 어떤 종류의 옷이 i개라면,
         * 해당 종류에서 나오는 경우의 수는 안 입는 경우 포함해서 (i+1)개.
         * 각 종류에 대해 (개수+1)개 값 곱한 후에, 모든 종류를 안 입는 경우 1개를 빼주면 답
         */
        int answer = 1;
        while (iterator.hasNext()) {
            answer *= iterator.next()+1;
        }//while end

        return answer-1;

    }//solution() end

    //Stream
    public static int  solution2(String[][] clothes) {
        return Arrays.stream(clothes)
                .map(c -> c[1])
                .distinct()
                .map(type -> (int) Arrays.stream(clothes).filter(c -> c[1].equals(type)).count())
                .map(c -> c + 1)
                .reduce(1, (c, n) -> c * n) - 1;
    }
}
