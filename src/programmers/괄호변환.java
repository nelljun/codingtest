package src.programmers;

public class 괄호변환 {

    public static void main(String[] args) {
        solution(")((())");
    }

    static StringBuilder sbForAns = new StringBuilder();

    public static String solution(String p){
        //빈 문자열, 올바른 문자열일 때 반환
        if (checkIfRight(p)) return p;

        dfs(p);

        return sbForAns.toString();
    }//solution() end

    public static void dfs(String p) {
        int length = p.length();

        if (length==0) return;

        int i = 2;
        for (; i < length; i+=2) {
            String subStr = p.substring(0, i);
            if(checkIfBalanced(subStr)) {
                if (checkIfRight(subStr)) {
                    sbForAns.append(subStr);
                    dfs(p.substring(i));
                } else {
                    sbForAns.append("(");
                    dfs(p.substring(i));
                    sbForAns.append(")");
                    sbForAns.append(cutAndReverse(subStr));
                }//if~else end
                break;
            }//if end
        }//for end

        if (i==length) {
            if (checkIfRight(p)) {
                sbForAns.append(p);
            } else {
                sbForAns.append("(");
                sbForAns.append(")");
                sbForAns.append(cutAndReverse(p));
            }
        }//if end
    }

    static StringBuilder sb = new StringBuilder();

    public static String cutAndReverse(String parStr) {
        sb.setLength(0);

        int length = parStr.length();

        for (int i = 1; i < length-1; i++) {
            sb.append((parStr.charAt(i)=='(')? ')' : '(');
        }//for end

        return sb.toString();
    }//cutAndReverse() end

    public static boolean checkIfRight(String parStr) {
        int length = parStr.length();
        int checkNum = 0;

        for (int i = 0; i < length; i++) {
            char parChar = parStr.charAt(i);
            if (parChar =='(') {
                checkNum++;
            } else {
                if (checkNum==0) return false;

                checkNum--;
            }
        }//for end
        
        return true;
    }//checkIfRight() end

    public static boolean checkIfBalanced(String parStr) {
        int leftCnt = 0;
        int rightCnt = 0;
        int length = parStr.length();

        for (int i = 0; i < length; i++) {
            if (parStr.charAt(i)=='(') {
                leftCnt++;
            } else {
                rightCnt++;
            }
        }//for end

        return (leftCnt==rightCnt);
    }//checkIfBalanced() end

}
