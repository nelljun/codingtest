package src.programmers;

public class 보석쇼핑 {
    public static void main(String[] args) {
        String[] gems = {"A", "B", "C", "B", "F", "D", "A", "F", "B", "D", "B"};
        solution(gems);
    }
    public static int[] solution(String[] gems) {
        int length = gems.length;

        //새로운 보석이면 end 증가 && 맨 앞 보석부터, 안에 속해있는지 검사 후 있으면 start 증가

        int start = 0;
        int end = 0;

        for (int i = 1; i < length; i++) {
            if (hasGem(start, end, gems[i], gems)) {
                int tempStart = start;
                while (true) {
                    if (hasGem(tempStart+1, i, gems[tempStart], gems)) {
                        tempStart++;
                    } else {
                        break;
                    }
                }//while end
                if ((end-start) > (i-tempStart)) {
                    end = i;
                    start = tempStart;
                }//if end
            } else {
                end = i;
                while (true) {
                    if (hasGem(start+1, end, gems[start], gems)) {
                        start++;
                    } else {
                        break;
                    }
                }//while end
            }//if~else end
        }//for end

        return new int[]{start+1, end+1};
    }//solution() end

    private static boolean hasGem(int start, int end, String gem, String[] gems) {
        for (int i = start; i <= end; i++) {
            if (gems[i].equals(gem)) {
                return true;
            }//if end
        }//for end

        return false;
    }//hasGem() end
}
