package src.programmers;

import java.util.*;

public class 오픈채팅방 {

    static final String ENTER_MSG = "님이 들어왔습니다.";
    static final String LEAVE_MSG = "님이 나갔습니다.";

    //중간 결과물 담을 queue ({유저아이디, ENTER_MSG or LEAVE_MSG})
    //순서대로 결과 출력해야하니까 Queue 자료구조
    static Queue<String[]> queue;
    //<key : 아이디, value : 닉네임> 담을 맵
    //바뀔 때마다 업데이트
    static Map<String, String> userIdNicknameMap;

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi"};
        solution(record);
    }//main() end

    public static void solution(String[] record) {

        queue = new LinkedList<>();
        userIdNicknameMap = new HashMap<>();

        //유저 아이디 + 메시지로 queue에 담은 1차 결과
        //닉네임은 계속 바뀌니까 분리해서 따로 map에서 업데이트
        //마지막으로 queue의 유저 아이디를 map의 닉네임으로 변경하여 출력
        
        StringTokenizer st;
        String type;
        String uId;
        for(String info : record) {
            st = new StringTokenizer(info);
            type = st.nextToken();
            uId = st.nextToken();
            if(type.equals("Enter")) {
                //Enter
                //1. MSG 생성
                //2. 닉네임 업데이트
                queue.add(new String[]{uId, ENTER_MSG});
                userIdNicknameMap.put(uId, st.nextToken());
            } else if(type.equals("Leave")) {
                //Leave
                //MSG 생성
                queue.add(new String[]{uId, LEAVE_MSG});
            } else {
                //Change
                //닉네임 업데이트
                userIdNicknameMap.put(uId, st.nextToken());
            }//if~else end
        }//for end

        //queue 사이즈 = 정답 배열 사이즈
        int msgSize = queue.size();
        String[] answer = new String[msgSize];

        String[] temp;
        String finalNickname;
        String finalMsg;
        //map을 이용해 queue의 유저 아이디를 최종 nickname로 매핑
        for(int i=0; i<msgSize; i++) {
            temp = queue.poll();
            finalNickname = userIdNicknameMap.get(temp[0]);
            finalMsg = finalNickname+temp[1];
            answer[i] = finalMsg;
        }
    }//solution() end
}
