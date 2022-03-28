package src.leetcode;

public class Q5 {
    public static void main(String[] args) {
        String s = "babad";
        solution(s);
    }

    public static String solution(String s) {
        int length = s.length();
        int maxLen = 0, palindromeStartsAt = 0;
        String answer = null;

        //(i, j)는 i~j index의 substring(s.substring(i, j+1))이 palindrome인지 여부
        boolean[][] dp = new boolean[length][length];

        //i는 뒤에서부터, j는 i부터 마지막까지 탐색
        for (int i = length-1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                //i~j substring palindrome인지 확인
                dp[i][j] = (s.charAt(i)==s.charAt(j)) //양 끝 문자는 같고,
                        && (j-i < 3 //and 문자열 길이가 1, 2, 3이면 palindrome
                            || dp[i+1][j-1]);//or 문자열 길이가 3보다 클땐 i+1~j-1 substring이 palindrome이면 palindrome이다.

                //maxLen, palindromeStartsAt update
                if (dp[i][j] && (j-i+1)>maxLen) {
                    palindromeStartsAt = i;
                    maxLen = j-i+1;
                }
            }//for end
        }//for end

        return s.substring(palindromeStartsAt, palindromeStartsAt+maxLen);

    }//solution() end

}
