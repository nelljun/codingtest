package src.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 불량사용자 {
    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};

        solution(user_id, banned_id);
    }

    static ArrayList<ArrayList<Integer>> mappedUserIdListByBannedId = new ArrayList<>();
    static boolean[] isIncluded;
    static ArrayList<Integer> list = new ArrayList<>();
    static Set<String> groupSet = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static int length = 0;
    static int removedCnt = 0;

    public static int solution(String[] user_id, String[] banned_id) {
        length = banned_id.length;

        for (int i = 0; i < length; i++) {
            mappedUserIdListByBannedId.add(new ArrayList<>());
        }//for end

        isIncluded = new boolean[user_id.length];

        //1. 각 제재 아이디에 해당하는 유저 아이디 그룹 찾기 (1:N 관계 가능)
        mapId(user_id, banned_id);

        //2. 전처리
        preProcess();

        //3. 중복되는 유저 아이디 고려해서 경우의 수 구하기
        dfs(-1);

        return groupSet.size();
    }//solution() end

    public static void dfs(int index) {
        if (list.size()==(length-removedCnt)) {
            sb.setLength(0);

            list.stream()
                .sorted()
                .forEach(i -> sb.append(i));

            groupSet.add(sb.toString());
            return;
        }//if end

        for (int i = index+1; i < length; i++) {
            ArrayList<Integer> userIdList = mappedUserIdListByBannedId.get(i);
            int size = userIdList.size();

            for (int j = 0; j < size; j++) {
                Integer userId = userIdList.get(j);
                if (!list.contains(userId)) {
                    list.add(userId);
                    dfs(i);
                    list.remove(userId);
                }//if end
            }//for end
        }//for end
    }
    public static void mapId(String[] user_id, String[] banned_id) {
        for (int i = 0; i < user_id.length; i++) {
            for (int j = 0; j < banned_id.length; j++) {
                String userId = user_id[i];
                String bannedId = banned_id[j];

                int userIdLength = userId.length();
                int bannedIdLength = bannedId.length();

                if (userIdLength != bannedIdLength) continue;

                int index = 0;

                while (index < userIdLength) {
                    char userIdChar = userId.charAt(index);
                    char bannedIdChar = bannedId.charAt(index);

                    if (bannedIdChar != '*' && (userIdChar != bannedIdChar)) {
                        break;
                    }//if end

                    index++;
                }//while end

                if (index == userIdLength) {
                    mappedUserIdListByBannedId.get(j).add(i);
                }//if end
            }//for end
        }//for end
    }//mapId() end

    public static void preProcess() {
        //각 제재 아이디 리스트 사이즈가 1에 해당하면 매핑하고, 해당 제재 아이디와 매핑된 유저 아이디를 리스트에서 제외

        int sizeOneListIdx = hasSizeOneList();

        while (sizeOneListIdx != -1) {
            ArrayList<Integer> userIdList = mappedUserIdListByBannedId.get(sizeOneListIdx);
            Integer userId = userIdList.get(0);
            removedCnt++;

            for (int i = 0; i < length; i++) {
                mappedUserIdListByBannedId.get(i).remove(userId);
            }//for end

            sizeOneListIdx = hasSizeOneList();
        }//while end
    }

    public static int hasSizeOneList() {
        for (int i = 0; i < length; i++) {
            if (mappedUserIdListByBannedId.get(i).size()==1) {
                return i;
            }//if end
        }//for end

        return -1;
    }
}
