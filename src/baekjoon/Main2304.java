package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2304 {

    static class Pole {
        int location;
        int height;

        public Pole(int location, int height) {
            this.location = location;
            this.height = height;
        }
    }


    public static void main2(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int totalPole = Integer.parseInt(bf.readLine());

        StringTokenizer st = null;

        List<Pole> poleList = new ArrayList<>();

        for (int i = 0; i < totalPole; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int location = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            poleList.add(new Pole(location, height));
        }//for end

        //기둥을 위치를 기준으로 정렬
        poleList.sort(new Comparator<Pole>() {
            @Override
            public int compare(Pole p1, Pole p2) {
                return Integer.compare(p1.location, p2.location);
            }
        });

        int maxHeight = 0;
        int maxHeightIdx = 0;

        for (int i = 0; i < totalPole; i++) {
            Pole pole = poleList.get(i);
            if (maxHeight<pole.height) {
                maxHeight = pole.height;
                maxHeightIdx = i;
            }
        }//for end


        int maxLeftHeight = 0;
        int maxLeftPrevIdx = 0;
        int maxLeftIdx = maxHeightIdx;
        int maxRightHeight = 0;
        int maxRightPrevIdx = 0;
        int maxRightIdx = maxHeightIdx;

        int sum = maxHeight;

        //왼쪽
        while (maxLeftIdx!=0) {
            maxLeftHeight = 0;
            maxLeftPrevIdx = maxLeftIdx;
            for (int i = 0; i < maxLeftPrevIdx; i++) {
                Pole now = poleList.get(i);
                if (maxLeftHeight < now.height) {
                    maxLeftHeight = now.height;
                    maxLeftIdx = i;
                }
            }//for end
            sum += maxLeftHeight * (poleList.get(maxLeftPrevIdx).location-poleList.get(maxLeftIdx).location);
        }//while end

        //오른쪽
        while (maxRightIdx!=totalPole-1) {
            maxRightHeight = 0;
            maxRightPrevIdx = maxRightIdx;
            for (int i = maxRightPrevIdx+1; i < totalPole; i++) {
                Pole now = poleList.get(i);
                if (maxRightHeight < now.height) {
                    maxRightHeight = now.height;
                    maxRightIdx = i;
                }
            }//for end
            sum += maxRightHeight * (poleList.get(maxRightIdx).location-poleList.get(maxRightPrevIdx).location);
        }//while end

        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int totalPole = Integer.parseInt(bf.readLine());

        StringTokenizer st = null;

        List<Pole> poleList = new ArrayList<>();

        for (int i = 0; i < totalPole; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int location = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            poleList.add(new Pole(location, height));
        }//for end

        //기둥을 위치를 기준으로 정렬
        poleList.sort(new Comparator<Pole>() {
            @Override
            public int compare(Pole p1, Pole p2) {
                return Integer.compare(p1.location, p2.location);
            }
        });

        int sum = 0;

        int maxHeightPoleIdx = 0;
        Pole roofPole = poleList.get(0);

        //왼쪽 -> 오른쪽
        for (int i = 1; i < totalPole; i++) {
            Pole nowPole = poleList.get(i);
            if (roofPole.height <= nowPole.height) {
                sum += roofPole.height * (nowPole.location - roofPole.location);

                roofPole = nowPole;
                maxHeightPoleIdx = i;
            }
        }//for end


        roofPole = poleList.get(poleList.size()-1);
        //오른쪽 -> 왼쪽
        for (int i = poleList.size()-2; i > maxHeightPoleIdx-1; i--) {
            Pole nowPole = poleList.get(i);
            if (roofPole.height <= nowPole.height) {
                sum += roofPole.height * (roofPole.location - nowPole.location);

                roofPole = nowPole;
            }
        }//for end

        sum += roofPole.height;
        System.out.println(sum);

    }


}
