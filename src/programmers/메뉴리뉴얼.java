package src.programmers;

import java.util.*;

public class 메뉴리뉴얼 {

    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};

        solution(orders, course);
    }

    //메뉴 수에 맞는 메뉴 조합과 주문 횟수 저장할 map
    static Map<String, Integer> menuListMap;

    public static String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();
        menuListMap = new HashMap<>();

        //모든 코스요리 메뉴 수에 대해서 작업
        for (int i = 0; i < course.length; i++) {
            //map 초기화
            menuListMap.clear();
            //현재 코스요리 메뉴 수
            int menuSize = course[i];
            //모든 주문에 대해서 작업
            for (int j = 0; j < orders.length; j++) {
                //현재 주문
                String order = orders[j];

                //현재 주문을 알파벳 순서로 정렬
                String newOrder = makeAlphabeticalOrder(order);

                //현재 주문의 길이가 현재 코스요리 메뉴 수보다 길 때에만 작업
                if (newOrder.length()>=menuSize) {
                    makeMenuList("", -1, menuSize, newOrder);
                }
            }//for end

            //map에서 value들만의 collection
            Collection<Integer> values = menuListMap.values();

            //value들 중 최댓값
            int max = 0;
            Iterator<Integer> iterator = values.iterator();
            while (iterator.hasNext()) {
                max = Math.max(max, iterator.next());
            }//while end

            //횟수가 2이상이어야만 조합 채택
            if (max>=2) {
                Iterator<String> keyIterator = menuListMap.keySet().iterator();
                while (keyIterator.hasNext()) {
                    String key = keyIterator.next();
                    if (menuListMap.get(key)==max) {
                        answerList.add(key);
                    }
                }//while end
            }
        }//for end

        //list 알파벳 순으로 정렬
        answerList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        int answerSize = answerList.size();
        String[] answer = new String[answerSize];

        for (int i = 0; i < answerSize; i++) {
            answer[i] =answerList.get(i);
        }//for end

        return answer;

    }//solution() end

    /**
     *
     * @param now : 현재 조합
     * @param index : 현재 메뉴에서 현재 음식의 index
     * @param menuSize : 현재 코스요리 메뉴 수
     * @param order : 현재 메뉴
     */
    //주문을 코스요리 메뉴 수에 맞게 조합하여 map에 저장하는 재귀 method
    public static void makeMenuList(String now, int index, int menuSize, String order) {
        //현재 조합이 코스요리 메뉴 수와 맞을 때
        if (now.length()==menuSize) {
            //map에 저장
            menuListMap.put(now, menuListMap.getOrDefault(now, 0)+1);
            return;
        }//if end

        //현재 메뉴의 다음 index서부터 탐색 (알파벳 순으로 정렬되어 있으니까)
        for (int i = index+1; i < order.length(); i++) {
            makeMenuList(now+order.charAt(i), i, menuSize, order);
        }//for end
    }

    //문자열 내부를 알파벳 순으로 정렬하는 method
    public static String makeAlphabeticalOrder(String order) {
        char[] menuArr = order.toCharArray();
        Arrays.sort(menuArr);
        String newOrder = new String(menuArr);
        return newOrder;
    }
}
