package src.programmers;

public class 피보나치수 {
    public static void main(String[] args) {

    }

    public static int solution(int n) {
        int temp1 = 0, temp2 = 1, temp3 = 0;

        for (int i = 2; i <= n; i++) {
            temp3 = (temp1 + temp2) % 1234567;
            temp1 = temp2;
            temp2 = temp3;
        }//for end

        return temp3;
    }//solution() end
}
