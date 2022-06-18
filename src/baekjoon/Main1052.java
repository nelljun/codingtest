package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1052 {
    static List<Integer> numList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        /**
         * N개 물병, 처음에 1리터씩, 한 번에 K개 물병씩 이동 가능
         * 사야하는 물병의 최소 개수
         * K개 이하의 물병에만 물을 채우자
         */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N<=K) {
            System.out.println(K-N);
        } else {
            //K개 이하로 만들자
            String binaryString = Integer.toBinaryString(N);
            int length = binaryString.length();
            for (int i = 0; i < length; i++) {
                char now = binaryString.charAt(i);
                if (now=='1') {
                    numList.add((int)Math.pow(2, length-1-i));
                }
            }//for end
            int size = numList.size();

            int diff = size-K;

            if (diff<0) {
                while (true) {
                    int nowSize = numList.size();
                    int i = 0;
                    for (; i < nowSize; i++) {
                        if (numList.get(i) != numList.get(i+1)) {
                            break;
                        }
                    }//for end
                    if (diff+(i+1) < 0) {
                        diff += (i+1);
                    } else if (diff+(i+1) == 0){
                        diff += (i+1);
                        break;
                    } else {
                        break;
                    }
                }//while end
                System.out.println(-diff);
            } else {
                //개수를 줄여나가자
                int cnt = 0;

                while (diff>0) {
                    int nowSize = numList.size();

                    int last = numList.get(nowSize-1);
                    int secondLast = numList.get(nowSize-2);

                    cnt += (secondLast-last);
                    diff--;

                    numList.remove(nowSize-1);
                    numList.remove(nowSize-2);
                    numList.add(secondLast*2);
                }//while end

                System.out.println(cnt);
            }//if~else end
        }//if~else end
    }

}
