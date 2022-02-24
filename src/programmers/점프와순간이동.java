package src.programmers;

public class 점프와순간이동 {

    public static void main(String[] args) {
        solution(6);
    }//main() end

    public static void solution(int n) {
        recursive(n);
        System.out.println(count);
    }//solution() end

    static int count = 0;
    public static void recursive(int n) {
        if(n==0) return;
        if(n%2==0) {
            n /= 2;
            recursive(n);
        } else {
            count++;
            n = (n-1)/2;
            recursive(n);
        }
    }//recursive
}
