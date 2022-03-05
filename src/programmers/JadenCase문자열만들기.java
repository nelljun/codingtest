package src.programmers;

public class JadenCase문자열만들기 {

    public static void main(String[] args) {
        String s1 = " 3people unFollowed me";
        solution(s1);
        solution2(s1);
    }//main() end

    public static void solution(String s) {

        StringBuilder sb = new StringBuilder();

        //앞 단어 공백 확인
        //맨 첫 단어때문에 true로 초기화
        boolean spaceFlag = true;
        int length = s.length();

        for(int i=0; i<length; i++) {
            char next = s.charAt(i);
            if(next>='A' && next<='Z') {
                //대문자
                if(!spaceFlag) {
                    //앞이 공백이 아니었다면 소문자로
                    next += 32;
                }//if end
            } else if(next>='a') {
                //소문자
                if(spaceFlag) {
                    //앞이 공백이었다면 대문자로
                    next -= 32;
                }//if end
            }//if~else end

            spaceFlag = (next==32)? true : false;
            sb.append(next);
        }//for end

    }//solution() end

    public static void solution2(String s) {
        StringBuilder sb = new StringBuilder();

        String allLowerStr = s.toLowerCase();

        //앞 단어 공백 확인
        //맨 첫 단어때문에 true로 초기화
        boolean spaceFlag = true;
        int length = s.length();

        for(int i=0; i<length; i++) {
            String next = allLowerStr.substring(i,i+1);
            sb.append((spaceFlag)? next.toUpperCase() : next);
            spaceFlag = next.equals(" ")? true : false;
        }//for end
    }//solution3() end

}
