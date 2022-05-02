package src.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 순위검색 {

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};

        String[] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};

        solution2(info, query);
    }

    //시간초과(query - info 각각 비교)
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int index = 0;
        for (String conditions : query) {
            String[] condition = conditions.split(" ");

            answer[index++] = find(condition[0],
                                    condition[2],
                                    condition[4],
                                    condition[6],
                                    condition[7],
                                    info);

        }//for end

        return answer;
    }//solution() end

    //info 돌면서 조건에 맞는 사람 찾는 method
    public static int find(String language,
                           String department,
                           String career,
                           String food,
                           String score,
                           String[] info) {
        int count = 0;
        for (String participant : info) {
            String[] participantInfo = participant.split(" ");
            if ((language.equals("-") || participantInfo[0].equals(language))
            && (department.equals("-") || participantInfo[1].equals(department))
            && (career.equals("-") || participantInfo[2].equals(career))
            && (food.equals("-") || participantInfo[3].equals(food))
            && (Integer.parseInt(participantInfo[4])>=Integer.parseInt(score))) {
                count++;
            }
        }//for end

        return count;
    }

    
    //<각 info에서 가능한 모든 경우의 문자열, 해당하는 점수 리스트>
    static Map<String, ArrayList<Integer>> map;
    static StringBuilder sb = new StringBuilder();

    //반대로 info에서 가능한 모든 문자열을 만들어 점수와 함께 map에 저장
    public static int[] solution2(String[] info, String[] query) {
        map = new HashMap<>();

        for (String conditions : info) {
            sb.setLength(0);
            String[] condition = conditions.split(" ");
            makeStr(0, condition, sb);
        }//for end

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }//for end

        int answerSize = query.length;
        int[] answer = new int[answerSize];

        for (int i = 0; i < answerSize; i++) {
            String[] queryInfo = query[i].replaceAll(" and ", "").split(" ");
            answer[i] = map.containsKey(queryInfo[0])? rank(queryInfo[0], Integer.parseInt(queryInfo[1])) : 0;
        }//for end

        return answer;
    }

    public static void makeStr(int index, String[] condition, StringBuilder sb) {
        if (index==4) {
            String keyStr = sb.toString();
            if (!map.containsKey(keyStr)) {
                ArrayList<Integer> list = new ArrayList<>();
                map.put(keyStr, list);
            }
            map.get(keyStr).add(Integer.parseInt(condition[4]));
            return;
        }

        makeStr(index+1, condition, sb.append("-"));
        sb.deleteCharAt(sb.length()-1);
        makeStr(index+1, condition, sb.append(condition[index]));
        sb.delete(sb.length()-condition[index].length(), sb.length());
    }

    public static int rank(String key, int queryScore) {
        ArrayList<Integer> scores = map.get(key);
        int scoresSize = scores.size();

        int start = 0;
        int end = scoresSize-1;

        while (start<=end) {
            int mid = (start+end)/2;

            if (queryScore<=scores.get(mid)) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }//while end

        return scoresSize-start;
    }
}
