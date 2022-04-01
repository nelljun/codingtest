package src.programmers;

import java.util.*;

public class 여행경로 {

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "B"},{"B", "ICN"},{"ICN", "A"},{"A","D"},{"D","A"}};
        String[][] tickets2 = {{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL", "SFO"}};
        solution(tickets2);
    }

    //"도시 "형태로 문자열 이을 StringBuilder
    //" "는 배열로 split하기 위해서
    static StringBuilder sb = new StringBuilder();
    //티켓 사용 여부
    static boolean[] isUsed;
    //"ICN"으로 무조건 시작하니 "J"로 초기화
    static String result = "J";

    public static String[] solution(String[][] tickets) {
        isUsed = new boolean[tickets.length];

        sb.append("ICN ");
        dfs(0,"ICN", tickets);

        String[] answer = result.split(" ");

        return answer;
    }//solution() end

    public static void dfs(int count, String start, String[][] tickets) {
        //이동횟수 == 티켓횟수면 모든 티켓 사용한 경우에 리턴
        if (count==tickets.length) {
            //현재 완성된 이동경로와 이전 이동경로끼리 알파벳 순서 비교
            result = (result.compareTo(sb.toString()) > 0)? sb.toString() : result;
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!isUsed[i] && tickets[i][0].equals(start)) {
                isUsed[i] = true;
                sb.append(tickets[i][1]).append(" ");
                dfs(count+1, tickets[i][1], tickets);
                isUsed[i] = false;
                sb.delete(sb.length()-4, sb.length());
            }
        }//for end
    }
}
