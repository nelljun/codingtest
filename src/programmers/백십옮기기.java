package src.programmers;

public class 백십옮기기 {

    public static void main(String[] args) {
        String[] s = {"1110","100111100","0111111010"};
        solution(s);
    }

    public static String[] solution(String[] s) {
        String[] answerArr = new String[s.length];
        for (int i=0; i < s.length; i++) {
            sb.setLength(0);
            check(s[i]);
            answerArr[i] = sb.toString();
        }//for end

        return answerArr;
    }//solution() end

    static StringBuilder sb = new StringBuilder();

    public static void check(String str) {
        while(true) {
            int length = str.length();

            if (length == 0) {
                sb.append(str);
                return;
            }

            //111의 마지막 1의 index
            int idxOne = -1;
            //110의 마지막 0의 index
            int idxZero = -1;

            for (int i = 0; i < length; i++) {
                //1로 시작하고 i+3이 length 이하일 때
                if (str.charAt(i) == '1' && i + 3 <= length) {
                    if (idxOne == -1 && str.substring(i, i + 3).equals("111")) {
                        idxOne = i + 2;
                    }
                    if (idxOne != -1 && str.substring(i, i + 3).equals("110")) {
                        idxZero = i + 2;
                        break;
                    }
                }
            }//for end

            String result = "";

            if (idxOne != -1 && idxZero != -1) {
                sb.append(str.substring(0, idxOne)).append("0");
                str = str.substring(idxOne + 1, idxZero) + "1" + str.substring(idxZero + 1, length);
            } else {
                sb.append(str);
                return;
            }
        }
    }//solution() end
}
