package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1107 {
    static ArrayList<Integer> impossibleList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        /**
         1. 시작점인 100에서부터 "+, -"만으로 target까지 이동하는 횟수를 구한다.

         2. 2-1 사용할 수 있는 숫자가 없을 경우 1에서 구한 수를 출력하고 끝낸다.
            2-2 사용할 수 있는 숫자로 이루어진 수 중 target과 가장 가까운 수를 구하고,
                해당 수와 target까지의 거리와 해당 수의 자릿수를 더한다.

         3. 1과 2-2에서 구한 수 중 최솟값을 출력한다.
         */

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(bf.readLine());

        int cnt = Integer.parseInt(bf.readLine());

        //1. 시작점인 100에서부터 "+, -"만으로 target까지 이동하는 횟수를 구한다.
        int candidate1 = (target-100 > 0)? target-100 : 100-target;


        if (cnt==10) {
            //2-1 사용할 수 있는 숫자가 없을 경우 1에서 구한 수를 출력하고 끝낸다.
            System.out.println(candidate1);
            return;
        } else if (cnt!=0){
            //cnt!=0일 때만 입력이 추가로 들어오기 때문에 조건 추가
            //cnt==0일 땐 비어있는 impossibleList 그대로
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            for (int i = 0; i < cnt; i++) {
                impossibleList.add(Integer.parseInt(st.nextToken()));
            }//for end
        }

        //2-2 사용할 수 있는 숫자로 이루어진 수 중 target과 가장 가까운 수를 구하고,
        //    해당 수와 target까지의 거리와 해당 수의 자릿수를 더한다. (count())
        int candidate2 = count(target);

        //candidate1과 candidate2 중 최소값 출력
        System.out.println(Math.min(candidate1, candidate2));
    }

    /**
     * target으로부터 1씩 더하고 빼가면서 모든 자리에서의 숫자가 사용할 수 있는 숫자로 이루어져있는 가장 가까운 수를 구하고,
     * 그 숫자의 자릿수와 target부터의 거리를 더하는 메소드
     */
    public static int count(int target) {
        int cnt = 0;
        //length : 자릿수
        int length = 0;
        while(true) {
            if ((target-cnt>=0) && !hasImpossible(target-cnt)) {
                length = Integer.toString(target - cnt).length();
                break;
            }
            if (!hasImpossible(target+cnt)) {
                length = Integer.toString(target + cnt).length();
                break;
            }
            cnt++;
        }//for end

        return cnt+length;
    }//howFarFromTarget() end

    /**
     * 매개변수의 모든 자릿수의 숫자 중 사용할 수 없는 숫자가 있는지 여부를 리턴하는 메서드
     */
    public static boolean hasImpossible(int num) {
        while (true) {
            if(impossibleList.contains(num % 10)) return true;
            num /= 10;
            if (num==0) break;
        }//while end

        return false;
    }
}
