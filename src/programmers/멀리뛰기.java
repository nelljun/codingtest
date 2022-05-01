package src.programmers;

public class 멀리뛰기 {

    public static void main(String[] args) {
        solution(4);
    }

    public static int solution(int n) {
        if (n==1) return 1;
        if (n==2) return 2;

        int[] numArr = new int[n];

        numArr[0] = 1;
        numArr[1] = 2;

        for (int i = 2; i < n; i++) {
            numArr[i] = (numArr[i-2] + numArr[i-1]) % 1234567;
        }//for end

        return numArr[n-1];
    }//solution() end

}
