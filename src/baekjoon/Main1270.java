package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main1270 {
    //자바로는 메모리 초과

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int areaCnt = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();

        Map<String, Integer> soldierMapInArea = new HashMap<>();

        for (int i = 0; i < areaCnt; i++) {
            String[] areaInfo = bf.readLine().split(" ");
            int soldierCnt = Integer.parseInt(areaInfo[0]);

            soldierMapInArea.clear();

            int j;
            for (j = 1; j <= soldierCnt; j++) {
                int newVal = soldierMapInArea.getOrDefault(areaInfo[j], 0) + 1;
                if (newVal > soldierCnt/2) {
                    sb.append(areaInfo[j]).append("\n");
                    break;
                } else {
                    soldierMapInArea.put(areaInfo[j], newVal);
                }
            }//for end

            if (j==soldierCnt+1) {
                sb.append("SYJKGW").append("\n");
            }

        }//for end

        System.out.println(sb);
    }
}
