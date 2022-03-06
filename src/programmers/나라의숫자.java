package src.programmers;

public class 나라의숫자 {

    public static void main(String[] args) {
        int n = 13;
        solution(n);
    }//main() end

    //3진법에서 응용한 풀이
    public static void solution(int n) {
        String[] arr = {"4","1","2"};
        StringBuilder sb = new StringBuilder();

        while(n>0) {
            int remainder= n%3;
            n = (remainder==0)? n/3-1 : n/3;
            sb.insert(0, arr[remainder]);
        }

    }//solution() end
}
