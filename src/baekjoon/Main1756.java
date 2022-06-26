package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1756 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int ovenCnt = Integer.parseInt(st.nextToken());
        int pizzaCnt = Integer.parseInt(st.nextToken());


        //oven 맨 마지막 요소는 0으로 초기화
        int[] ovenArr = new int[ovenCnt+1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < ovenCnt; i++) {
            ovenArr[i] = Integer.parseInt(st.nextToken());
        }//for end


        int[] pizzaArr = new int[pizzaCnt];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < pizzaCnt; i++) {
            pizzaArr[i] = Integer.parseInt(st.nextToken());
        }//for end

        /**
         * 1. pizzaArr pointer가 위치한 현재 피자 지름보다 처음으로 작은 오븐 index를 찾는다.
         *
         * 2. 1번에서 찾은 index의 직전 index에 현재 피자를 위치시킨다. (직전 index의 ovenArr 요소를 0으로 바꾼다.)
         *
         * 3. 현재 pizza가 oven을 통과하지 못하거나, pizzaArr의 pointer가 pizzaArr의 마지막 index를 넘을 때까지 1, 2 과정을 반복
         *
         * 4-1. pizzaArr의 pointer가 pizzaArr의 마지막 index보다 작거나 같다면 (즉, pizza가 남았다면) 0 출력
         * 4-2. 크다면, (즉, pizza가 남지 않았다면) ovenArr의 첫 번째 0의 index + 1 값을 출력
         */

        int pizzaPointer = 0;

        while (pizzaPointer<pizzaCnt && pizzaArr[pizzaPointer]<=ovenArr[0]) {
            int nowPizza = pizzaArr[pizzaPointer];

            for (int i = 0; i <= ovenCnt; i++) {
                if (nowPizza>ovenArr[i]) {
                    ovenArr[i-1] = 0;
                    pizzaPointer++;
                    break;
                }//if end
            }//for end
        }//while end

        if (pizzaPointer<pizzaCnt) {
            //피자가 남았으면
            System.out.println(0);
        } else {
            //남은 피자가 없으면
            for (int i = 0; i < ovenCnt; i++) {
                if (ovenArr[i]==0) {
                    System.out.println(i+1);
                    break;
                }
            }//for end
        }
    }
}
