package src.programmers;

public class 두개이하로다른비트 {

    public static void main(String[] args) {
        long[] numbers = {2,7};
        solution2(numbers);
    }//main() end

    public static void solution(long[] numbers) {

        //비트 논리 연산(&, |, ^, ~), bitCount()활용
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i]%2==1) {
                //홀수인 경우
                long originalNum = numbers[i];
                while (true) {
                    if (Long.bitCount(originalNum^++numbers[i]) <= 2) break;
                }//while end
            } else {
                //짝수인 경우
                numbers[i]++;
            }//if~else end
        }//for end

    }//solution() end

    public static void solution2(long[] numbers) {

        int length = numbers.length;
        long[] answer = new long[numbers.length];

        for(int i=0; i<length; i++) {
            if(numbers[i]%2==0) {
                //짝수
                answer[i] = numbers[i]+1;
            } else {
                //홀수
                String binStr = Long.toBinaryString(numbers[i]);
                int zeroIdx = binStr.lastIndexOf("0");
                if(zeroIdx!=-1) {
                    //이진수에서 0을 포함하는 경우
                    //가장 뒤에 있는 0을 1로 바꾼 후 그 다음 자리수의 1을 0으로 바꾼다.
                    binStr = binStr.substring(0,zeroIdx)+"10"+binStr.substring(zeroIdx+2);
                } else {
                    //이진수에서 0 없는 경우
                    //앞에서 두번째 자리에 0 추가
                    binStr = "10"+binStr.substring(1);
                }//if~else end
                answer[i] = Long.parseLong(binStr, 2);
            }//if~else end
        }//for end

    }//solution2() end

}
