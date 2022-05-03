package src.programmers;

public class k진수에서소수개수구하기 {
    public static void main(String[] args) {
        solution(111111, 10);
    }

    public static int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        //n을 k진법으로
        int temp = n;
        while (temp>0) {
            sb.insert(0, temp%k);
            temp /= k;
        }//while end

        String result = sb.toString();
        String[] arrWithNoZero = result.split("0+");

        int answer = 0;

        for (int i = 0; i < arrWithNoZero.length; i++) {
            if (isPrime(Long.parseLong(arrWithNoZero[i]))) answer++;
        }//for end


        return answer;
    }//solution() end

    public static boolean isPrime(long num) {
        if (num==2) return true;
        if (num==1 || num%2==0) return false;

        for (int i = 3; i*(long)i < num; i+=2) {
            if (num%i==0) return false;
        }//for end

        return true;
    }
}
