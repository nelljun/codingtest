package src.programmers;

public class 예상대진표 {

    public static void main(String[] args) {
        solution(8, 3, 5);
    }//main() end

    public static void solution(int n, int a, int b) {
        int count = 0;
        while(a!=b) {
            a = (a+1)/2;
            b = (b+1)/2;
            count++;
        }//while end

    }//solution() end
}
