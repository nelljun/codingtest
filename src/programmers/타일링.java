package src.programmers;

public class 타일링 {

    public static void main(String[] args) {

    }

    static final int BIG_NUMBER = 1000000007;

    public static int solution(int n) {
        int temp1 = 1;
        int temp2 = 2;
        int result = 0;

        if (n==1) return 1;
        if (n==2) return 2;

        //피보나치, 재귀x
        for (int i = 3; i <= n; i++) {
            result = (temp1 + temp2) % BIG_NUMBER;
            temp1 = temp2;
            temp2 = result;
        }//for end

        return result;
    }//solution() end
}
