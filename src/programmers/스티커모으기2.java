package src.programmers;

public class 스티커모으기2 {
    public static void main(String[] args) {
        int[] sticker = {1,3,2,5,4};
        solution(sticker);
    }

    //dp풀이
    public static int solution(int[] sticker) {
        int answer = 0;
        int length = sticker.length;

        if(length == 1) return sticker[0];

        //dp
        int[] dpWithFirst = new int[length];
        int[] dpWithoutFirst = new int[length];

        dpWithFirst[0] = sticker[0];
        dpWithFirst[1] = sticker[0];

        dpWithoutFirst[0] = 0;
        dpWithoutFirst[1] = sticker[1];

        for(int i = 2; i < length; i++) {
            dpWithFirst[i] = Math.max(dpWithFirst[i-2] + sticker[i], dpWithFirst[i-1]);
            dpWithoutFirst[i] = Math.max(dpWithoutFirst[i-2] + sticker[i], dpWithoutFirst[i-1]);
        }

        //첫번째를 뽑으면 마지막 티켓은 뽑을 수 없으므로 length-2와 비교
        return Math.max(dpWithFirst[length-2], dpWithoutFirst[length-1]);
    }//solution() end

    //dfs풀이 시도 (실패)
    static int max;
    static int[] isIncluded;

    public static int solution2(int sticker[]) {
        int answer = 0;
        int size = sticker.length;
        isIncluded = new int[size];

        if (size==1) return sticker[0];

        if (size%2==0) {
            //스티커 갯수 짝수
            int sum1 = 0;
            int sum2 = 0;

            for (int i = 0; i < size; i+=2) {
                sum1 += sticker[i];
            }//for end
            for (int i = 1; i < size; i+=2) {
                sum2 += sticker[i];
            }//for end

            answer = Math.max(sum1, sum2);
        } else {
            //스티커 갯수 홀수
            dfs(0, 0, 0, sticker);
            answer = max;
        }

        return answer;
    }//solution() end

    public static void dfs(int index, int cnt, int sum, int sticker[]) {
        if (cnt==(sticker.length-1)/2) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = index; i < sticker.length; i++) {
            if (isIncluded[i]==0) {
                isIncluded[makeInRange(i-1, sticker.length)]++;
                isIncluded[i]++;
                isIncluded[makeInRange(i+1, sticker.length)]++;
                dfs(i, cnt+1, sum+sticker[i], sticker);
                isIncluded[makeInRange(i-1, sticker.length)]--;
                isIncluded[i]--;
                isIncluded[makeInRange(i+1, sticker.length)]--;
            }
        }//for end
    }//dfs() end

    public static int makeInRange(int index, int range) {
        return (index<0)? range-1 : (index==range)? 0 : index;
    }//solution() end
}
