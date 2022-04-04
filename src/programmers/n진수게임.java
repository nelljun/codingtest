package src.programmers;

public class n진수게임 {
    public static void main(String[] args) {
        solution(11,4,2,1);
    }

    static final String[] ABOVE_TEN = {"A", "B", "C", "D", "E", "F"};

    public static String solution(int n, int t, int m, int p) {
        StringBuilder sbForTotal = new StringBuilder();
        StringBuilder sbForTube = new StringBuilder();

        //튜브 숫자
        //p번째, (p + m)번째, (p + 2*m), ... , (p + (t-1)*m)번째로 오는 숫자
        int totalLength = p + (t-1)*m;

        int num = 0;
        //전체 숫자 차례대로 이어붙이기 (p+(t-1)*m) 길이까지!
        while (sbForTotal.length()<totalLength) {
            sbForTotal.append(changeToN(n, num++));
        }//while end

        for (int i = 0; i < t; i++) {
            sbForTube.append(sbForTotal.charAt(p+m*i-1));
        }//for end

        return sbForTube.toString();

    }//solution() end

    //n진수 변환
    public static String changeToN(int n, int num) {
        StringBuilder sb = new StringBuilder();

        do {
            sb.insert(0, (num%n) >= 10? ABOVE_TEN[num%n -10] : num%n);
            num /= n;
        } while (num > 0);

        return sb.toString();
    }//changeToN() end


}
