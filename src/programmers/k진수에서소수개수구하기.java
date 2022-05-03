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
        //1개 이상의 0("0+")을 기준으로 분할
        String[] arrWithNoZero = result.split("0+");

        int answer = 0;

        for (int i = 0; i < arrWithNoZero.length; i++) {
            if (isPrime(Long.parseLong(arrWithNoZero[i]))) answer++;
        }//for end


        return answer;
    }//solution() end

    /**
     * @param num : long형, k진법으로 나타낸 수를 그대로 10진법으로 봤을 때 Integer의 범위 넘어갈 수 있다.
     */
    //소수 판별하는 method
    public static boolean isPrime(long num) {
        if (num==2) return true;
        if (num==1 || num%2==0) return false;

        for (int i = 3; i*(long)i <= num; i+=2) {
            if (num%i==0) return false;
        }//for end

        return true;
    }
}
