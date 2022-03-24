package src.programmers;

import java.util.*;

public class 방금그곡 {

    public static void main(String[] args) {
        String m = "DF";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        System.out.println(solution2(m, musicinfos));
    }//main() end

    static class Song {
        int duration;
        String name;

        public Song(int duration, String name) {
            this.duration = duration;
            this.name = name;
        }
    }

    public static String solution(String m, String[] musicinfos) {

        List<Song> songList = new ArrayList<>();

        for (String musicinfo : musicinfos) {
            StringTokenizer st = new StringTokenizer(musicinfo, ",");

            String startTime = st.nextToken();
            String endTime = st.nextToken();
            String name = st.nextToken();
            String melody = st.nextToken();

            String newMelody = makeNewMelody(melody);

            int duration = getDuration(startTime, endTime);

            String playedNewMelody = playNewMelody(duration, newMelody);

            if(playedNewMelody.contains(makeNewMelody(m))) {
                songList.add(new Song(duration, name));
            }
        }//for end

        if(songList.size()==0) {
            return "(None)";
        } else {
            //연주 길이 내림차순 정렬
            songList.sort(new Comparator<Song>() {
                @Override
                public int compare(Song o1, Song o2) {
                    return o2.duration-o1.duration;
                }
            });
            //먼저 입력
            return songList.get(0).name;
        }

    }//solution() end

    //Song 클래스에 담지 말고, 연주 시간이 이전까지 최고 연주 시간보다 클 때만
    //멜로디 작업한 후 기억한 멜로디가 포함되었는지 확인!
    public static String solution2(String m, String[] musicinfos) {

        String answer = "(None)";

        int maxDuration = 0;

        for (String musicinfo : musicinfos) {
            StringTokenizer st = new StringTokenizer(musicinfo, ",");

            String startTime = st.nextToken();
            String endTime = st.nextToken();
            String name = st.nextToken();
            String melody = st.nextToken();

            int duration = getDuration(startTime, endTime);

            //현재 곡의 연주 시간(곡 길이x)이 이전까지 최고 연주 시간보다 클 때만
            if(duration > maxDuration) {
                String newMelody = makeNewMelody(melody);
                String playedNewMelody = playNewMelody(duration, newMelody);

                if(playedNewMelody.contains(makeNewMelody(m))) {
                    //기억한 멜로디를 포함한다면
                    answer = name;
                    maxDuration = duration;
                }//if end
            }//if end
        }//for end

        return answer;
    }//solution2() end

    public static int getDuration(String startTime, String endTime) {

        StringTokenizer stForDuration = new StringTokenizer(startTime, ":");

        int startTimeHour = Integer.parseInt(stForDuration.nextToken());
        int startTimeMin = Integer.parseInt(stForDuration.nextToken());

        stForDuration = new StringTokenizer(endTime, ":");

        int endTimeHour = Integer.parseInt(stForDuration.nextToken());
        int endTimeMin = Integer.parseInt(stForDuration.nextToken());

        return 60 * (endTimeHour-startTimeHour) + (endTimeMin-startTimeMin);

    }//getLength() end

    static StringBuilder sb = new StringBuilder();

    public static String playNewMelody(int duration, String newMelody) {

        sb.setLength(0);

        int newMelodyLength = newMelody.length();

        for (int i = 0; i < duration/newMelodyLength; i++) {
            sb.append(newMelody);
        }//for end

        int mod = duration % newMelodyLength;

        sb.append(newMelody.substring(0, mod));

        return sb.toString();
    }//playNewMelody() end

    public static String makeNewMelody(String melody) {
        return melody.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }//makeNewMelody() end
}
