package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main2608 {
    static final Map<Character, Integer> arabiaMap = new HashMap<>();

    //초기화
    static {
        arabiaMap.put('I', 1);
        arabiaMap.put('V', 5);
        arabiaMap.put('X', 10);
        arabiaMap.put('L', 50);
        arabiaMap.put('C', 100);
        arabiaMap.put('D', 500);
        arabiaMap.put('M', 1000);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str1 = bf.readLine();
        int num1 = convertStrToNum(str1);

        String str2 = bf.readLine();
        int num2 = convertStrToNum(str2);

        int sum = num1 + num2;

        String arabia = convertNumToStr(sum);

        System.out.println(sum);
        System.out.println(arabia);
    }

    /**
     * 바로 뒤 문자와 비교해서 나타내는 값이 뒤 문자가 더 크다면
     * (뒤 문자에 해당하는 숫자 - 현재 문자에 해당하는 숫자)를 더해준다.
     * 나머지 경우는 현재 문자에 해당하는 숫자를 더해주면 된다.
     */
    //아라비아 문자를 숫자로
    public static int convertStrToNum(String str) {
        int result = 0;

        int length = str.length();

        int idx = 0;

        while (idx<length) {
            char now = str.charAt(idx);

            //다음 숫자와 비교
            idx++;
            if (idx<length) {
                char next = str.charAt(idx);

                if (arabiaMap.get(now)<arabiaMap.get(next)) {
                    //뒤가 더 클 때
                    result += (arabiaMap.get(next) - arabiaMap.get(now));
                    idx++;
                    continue;
                }//if end
            }//if end

            //나머지 모든 경우에는 현재 문자의 숫자를 더해준다.
            result += arabiaMap.get(now);
        }//while end

        return result;
    }//convertStrToNum() end

    //숫자를 아라비아 문자로
    public static String convertNumToStr(int num) {
        StringBuilder sb = new StringBuilder();

        String numStr = String.valueOf(num);

        int length = numStr.length(); //전체 자릿수

        for (int i = 0; i < length; i++) {
            //현재 자릿수에 해당하는 숫자
            int now = numStr.charAt(i) - '0';

            //0일 때는 앞에서 처리가 됐으므로 continue
            if (now==0) continue;

            //현재 처리하고 있는 자릿수
            int nowLength = (length-i);

            //1000의 자릿수일 때만 특수 케이스이므로 먼저 처리
            if (nowLength==4) {
                for (int j = 0; j < now; j++) {
                    sb.append("M");
                }//for end

                continue;
            }//if end

            //현재 처리하고 있는 자릿수에서의 1, 5, 10에 해당하는 아라비아 문자 매칭할 변수
            String one = "";
            String five = "";
            String ten = "";

            switch (nowLength) {
                case 3 :
                    one = "C";
                    five = "D";
                    ten = "M";
                break;
                case 2 :
                    one = "X";
                    five = "L";
                    ten = "C";
                break;
                case 1 :
                    one = "I";
                    five = "V";
                    ten = "X";
                break;
            }

            //아라비아 문자를 최소로 쓰게끔 만들기 때문에
            //현재 자릿수에 해당하는 숫자가
            //(1,2,3) (4) (5) (6,7,8) (9)일때 one, five, ten 아라비아 문자를 이용해 만든다.
            switch (now) {
                case 1, 2, 3 :
                    for (int j = 0; j < now; j++) {
                        sb.append(one);
                    }//for end
                break;
                case 4 :
                    sb.append(one).append(five);
                break;
                case 5 :
                    sb.append(five);
                break;
                case 6, 7, 8 :
                    sb.append(five);
                    for (int j = 0; j < now-5; j++) {
                        sb.append(one);
                    }//for end
                break;
                case 9 :
                    sb.append(one).append(ten);
                break;
            }

        }//for end

        return sb.toString();
    }//convertNumToStr() end
}
