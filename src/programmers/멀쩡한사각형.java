package src.programmers;

public class 멀쩡한사각형 {

    public static void main(String[] args) {
        solution(12, 8);
    }//main() end

    public static long solution(int w, int h) {
        //가로로 한칸씩 움직이면서 대각선이 지나는 위치(y좌표)를 보고
        //지나가는 사각형의 개수를 계속 더해준다.

        //각 구간의 처음 지나가는 사각형의 위치
        //현재 대각선의 y좌표가 2.5라면 2 이후의 사각형부터 지나간다.
        int prevFlr = 0;
        int sumOfUnUsedSqr = 0;

        for(int i=1; i<=w; i++) {
            //한 칸 이동한 후 대각선의 y좌표를 포함한 사각형서부터
            //시작 위치 사각형까지 빼주면 한 칸 이동할 때 지나간 사각형의 개수다.
            sumOfUnUsedSqr += Math.ceil((long)h*i/(double)w)-prevFlr;
            prevFlr = (int)Math.floor((long)h*i/(double)w);
        }//for end

        return w*(long)h - sumOfUnUsedSqr;
    }//solution() end

    public static long solution2(int w, int h) {
        int gcd = gcd(w, h);
        return ((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
    }//solution2() end

    public static int gcd(int a, int b) {
        if(b==0) return a;

        return gcd(b, a%b);
    }//gcd() end
}
