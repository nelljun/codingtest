package src.programmers;

import java.util.*;

public class 추석트래픽 {

    public static void main(String[] args) {

    }

    public static int solution(String[] lines) {
        StringTokenizer st = null;

        /**
         * {시작 시간, 끝난 시간} 배열 담을 list
         */
        List<Long[]> timestampList = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) {
            st = new StringTokenizer(lines[i]);
            st.nextToken();
            //끝난 시간
            String endTime = st.nextToken();
            //처리 시간
            String elapsed = st.nextToken();
            String elapsedTime = elapsed.replace("s", "");

            //끝난 시간 timestamp
            long endTimestamp = getTimestamp(endTime);
            //시작 시간 timestamp (+1 처리)
            long startTimestamp = endTimestamp - (long)(Double.parseDouble(elapsedTime)*1000) + 1;

            timestampList.add(new Long[]{startTimestamp, endTimestamp});
        }//for end

        //시작 시간 순으로 정렬
        Collections.sort(timestampList, new Comparator<Long[]>() {
            @Override
            public int compare(Long[] o1, Long[] o2) {
                long result = o1[0] - o2[0];
                return result>0? 1 : result==0? 0 : -1;
            }
        });

        int answer = 0;

        //log 끝 시간을 구간의 처음으로 잡으면 최대로 log가 많이 걸릴 수 있다.
        for (Long[] timestamps : timestampList) {
           answer = Math.max(countLog(timestamps[1], timestampList), answer);
        }//for end

        return answer;
    }//solution() end

    //Timestamp값 구하는 method
    public static long getTimestamp(String endTime) {
        String[] split = endTime.split(":");

        //시 분 초를 ms 단위 값으로 환산
        return Integer.parseInt(split[0]) * 3600L * 1000
                + Integer.parseInt(split[1]) * 60L * 1000
                //double형이라 1000을 먼저 곱하고 long형으로 변형을 따로 해야한다.
                + (long)(Double.parseDouble(split[2]) * 1000);

    }

    //구간 안에 지나간 log 갯수 구하는 method
    public static int countLog(long beginTimestamp, List<Long[]> timestampList) {
        int count = 0;

        Iterator<Long[]> iterator = timestampList.iterator();

        while (iterator.hasNext()) {
            Long[] timestamp = iterator.next();
            /**
             * log 시작 시간이 구간의 끝보다 앞이고,
             * log 끝 시간이 구간의 처음보다 뒤에 있으면 +1
             */
            if (timestamp[0]<=beginTimestamp+999) {
                if (timestamp[1]>=beginTimestamp) count++;
            } else {
                //log 시작 순으로 정렬했기 때문에
                //log 시작 시간이 구간의 끝보다 뒤면 그 뒤는 무조건 해당 안되므로 break;
                break;
            }
        }//while end

        return count;
    }
}
