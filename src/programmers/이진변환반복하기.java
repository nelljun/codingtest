package src.programmers;

public class 이진변환반복하기 {

    public static void main(String[] args) {
        String str1 = "110010101001";
        String str2 = "01110";
        String str3 = "1111111";

        solution(str1);
    }//main() end

    public static void solution(String s) {

        int cnt = 0;
        int sumZero = 0;

        while(!s.equals("1")) {
            int length = s.length();
            s = s.replace("0", "");
            int newLength = s.length();
            s = Integer.toBinaryString(newLength);
            cnt++;
            sumZero += length - newLength;
        }//while end

        System.out.println("{"+cnt+", "+sumZero+"}");

    }//solution() end
}
