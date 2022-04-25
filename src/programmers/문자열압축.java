package src.programmers;

public class 문자열압축 {

    public static void main(String[] args) {
        solution("xababcdcdababcdcd");
    }//main() end

    public static int solution(String s) {
        int length = s.length();

        //길이가 1일 땐 1 리턴
        if (length==1) return 1;

        int min = Integer.MAX_VALUE;

        //절반 길이까지 단위 크기를 늘려가면서 압축 길이 갱신
        for (int i = 1; i <= length / 2; i++) {
            min = Math.min(min, getShortLength(s, i));
        }//for end

        return min;
    }//solution() end

    //단위 크기대로 압축 후 길이 리턴
    public static int getShortLength(String s, int cutSize) {
        //압축된 길이
        int answer = 0;
        //이전 구간의 String : 첫 구간 String으로 초기화
        String prevStr = s.substring(0, cutSize);

        //전체 길이
        int length = s.length();
        //같은 구간 갯수 : 1로 초기화
        int sameCnt = 1;

        //두 번째 구간부터 시작
        for (int i = cutSize; i < length; i+=cutSize) {
            //현재 구간의 String 
            String now = null;
            try {
                now = s.substring(i, i+cutSize);
            } catch (Exception e) {
                //endIndex가 길이 넘어갈 때 (즉, 갯수가 딱 안맞을 때)
                now = s.substring(i);
            } finally {
                if (now.equals(prevStr)) {
                    //이전 구간 String과 같을 때
                    //갯수 +1
                    sameCnt++;
                } else {
                    //이전 구간 String과 다르면
                    //구간 사이즈만큼 압축 길이 증가
                    answer += cutSize;
                    if (sameCnt!=1) {
                        //1개가 아니라면, sameCnt의 자릿수만큼 압축 길이 증가
                        answer += String.valueOf(sameCnt).length();
                    }
                    //1로 초기화
                    sameCnt = 1;
                    //현재 구간의 String으로 prevStr 갱신
                    prevStr = now;
                }
            }

        }//for end

        //마지막 구간에 대한 압축 길이 처리
        if (sameCnt!=1) {
            //마지막 구간이 전 구간과 같다면
            //같은 갯수 자릿수와 단위 크기만큼 증가
            answer += cutSize;
            answer += String.valueOf(sameCnt).length();
        } else {
            //다르면 마지막 구간의 길이만큼 증가
            answer += prevStr.length();
        }

        return answer;
    }



    /**
     * 재귀를 이용한 2번째 풀이
     */

    //압축 문자열 만들 StringBuilder
    static StringBuilder sb = new StringBuilder();

    public static int solution2(String s) {
        int length = s.length();

        if (length==1) return 1;

        int min = Integer.MAX_VALUE;

        //절반 길이까지 단위 크기를 늘려가면서 압축 길이 갱신
        for (int i = 1; i <= length/2; i++) {
            //sb 초기화
            sb.setLength(0);
            getShortStr(s, i, 1);
            min = Math.min(min, sb.length());
        }//for end

        return min;
    }//solution() end

    //압축 문자열 리턴 (재귀)
    public static void getShortStr(String s, int cutSize, int sameCnt) {
        //s 길이가 단위 크기보다 작으면 s를 append
        if (s.length()<cutSize) {
            sb.append(s);
            return;
        }

        //비교대상 (남은 문자열의 앞 구간)
        String prefix = s.substring(0, cutSize);
        //앞 구간을 제외한 나머지 문자열
        String rest = s.substring(cutSize, s.length());

        if (rest.startsWith(prefix)) {
            //나머지 문자열의 앞이 비교대상과 일치할 때
            //sameCnt 1 증가시키고, 나머지 문자열을 인자로 하면서 재귀 호출
            getShortStr(rest, cutSize, sameCnt+1);
        } else {
            //일치하지 않는 경우
            if (sameCnt!=1) {
                //같은 갯수가 1이 아닐 때만 sameCnt append
                sb.append(String.valueOf(sameCnt));
            }
            //비교대상 append
            sb.append(prefix);
            //나머지 문자열을 인자로, sameCnt는 1로 초기화하면서 재귀 호출
            getShortStr(rest, cutSize, 1);
       }
    }//getShortStr() end
}
