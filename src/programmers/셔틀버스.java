package src.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 셔틀버스 {

    public static void main(String[] args) {
        String[] timetable = {"08:00", "08:01", "08:02", "08:03"};
        solution(1,1,5,timetable);
    }

    public static String solution(int n, int t, int m, String[] timetable) {

        Arrays.sort(timetable, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] split1 = o1.split(":");
                String[] split2 = o2.split(":");

                if (split1[0].compareTo(split2[0])>0) {
                    return 1;
                } else if (split1[0].compareTo(split2[0])==0) {
                    return split1[1].compareTo(split2[1]);
                } else {
                    return -1;
                }
            }
        });

        //직원수
        int numOfCrew = timetable.length;
        //하루 탈 수 있는 크루 수
        int max = n * m;

        return null;
    }//solution() end

    public static int timeStamp(String timeStr) {
        String[] split = timeStr.split(":");

        return Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
    }//timeStamp() end
}
