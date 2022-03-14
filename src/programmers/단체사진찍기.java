package src.programmers;

public class 단체사진찍기 {

    static final char[] FRIENDS = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[] isUsed = new boolean[FRIENDS.length];
    static int answer = 0;
    //매번 data를 파라미터로 넘기지 말고 전역변수로
    static String[] conditions;

    public static void main(String[] args) {
        String[] data = {"N~F=0", "R~T>2"};
        solution(2, data);
    }//main() end

    public static void solution(int n, String[] data) {

        StringBuilder sb = new StringBuilder();
        //전역변수 conditions가 data 참조
        conditions = data;

        arrange(0, sb);

    }//solution() end

    public static void arrange(int idx, StringBuilder sb) {
        if(idx==FRIENDS.length) {
            //8명 배치 다 됐으면, 조건 검사 통과하면 answer 값 증가
            if(check(sb)) answer++;
            return;
        }

        for(int i=0; i<FRIENDS.length; i++) {
            if(!isUsed[i]) {
                sb.append(FRIENDS[i]);
                isUsed[i] = true;
                arrange(idx+1, sb);
                isUsed[i] = false;
                sb.delete(idx, sb.length());
            }
        }//for end
    }//combination() end

    //조건에 맞는지 확인
    public static boolean check(StringBuilder sb) {
        String friend1;
        String friend2;
        char operator;
        int gap;
        int realGap;

        for (String condition : conditions) {
            friend1 = String.valueOf(condition.charAt(0));
            friend2 = String.valueOf(condition.charAt(2));
            operator = condition.charAt(3);
            gap = condition.charAt(4) - '0';

            realGap = Math.abs(sb.indexOf(friend1)-sb.indexOf(friend2))-1;

            switch(operator) {
                case '=' :
                    if(realGap != gap) return false;
                    break;
                case '<' :
                    if(realGap >= gap) return false;
                    break;
                case '>' :
                    if(realGap <= gap) return false;
                    break;
            }//switch end
        }//for end

        return true;
    }//check() end

}
