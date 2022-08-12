package src.programmers;

public class 최고의집합 {
    public static void main(String[] args) {

    }

    public static int[] solution(int n, int s) {
        if (n>s) {
            return new int[] {-1};
        }

        int quotient = s/n;
        int remainder = s%n;

        int[] answer = new int[n];
        for (int i = 0; i < n-remainder; i++) {
            answer[i] = quotient;
        }//for end
        for (int i = n-remainder; i < n; i++) {
            answer[i] = quotient+1;
        }//for end

        return answer;
    }//solution() end
}
