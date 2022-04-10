package src.programmers;

import java.util.*;

public class 해시 {
    public static void main(String[] args) {

    }

    static class Genre implements Comparable<Genre> {
        int totalPlayCnt;
        List<Song> songList;

        public Genre(int totalPlayCnt, List<Song> songList) {
            this.totalPlayCnt = totalPlayCnt;
            this.songList = songList;
        }

        @Override
        public int compareTo(Genre g) {
            return g.totalPlayCnt-this.totalPlayCnt;
        }
    }

    static class Song implements Comparable<Song> {
        int index;
        int playCnt;

        public Song(int index, int playCnt) {
            this.index = index;
            this.playCnt = playCnt;
        }

        @Override
        public int compareTo(Song s) {
            return s.playCnt-this.playCnt;
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> genreMap = new HashMap<>();

        int numOfSongs = plays.length;

        for (int i = 0; i < numOfSongs; i++) {
            String genreName = genres[i];
            int playCnt = plays[i];

            Song song = new Song(i, playCnt);

            Genre foundGenre = genreMap.get(genreName);

            if (foundGenre==null) {
                List<Song> songList = new ArrayList<>();
                songList.add(song);
                Genre newGenre = new Genre(playCnt, songList);
                genreMap.put(genreName, newGenre);
            } else {
                foundGenre.totalPlayCnt += playCnt;
                foundGenre.songList.add(song);
            }
        }//for end

        int numOfGenre = genreMap.size();
        List<Genre> genreList = new ArrayList<>(genreMap.values());

        Collections.sort(genreList);

        List<Integer> answerList = new ArrayList<>();

        Iterator<Genre> genreIter = genreList.iterator();

        while (genreIter.hasNext()) {
            Genre genre = genreIter.next();
            Collections.sort(genre.songList);
            answerList.add(genre.songList.get(0).index);
            if (genre.songList.size()>=2) {
                answerList.add(genre.songList.get(1).index);
            }
        }//while end

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }//for end

        return answer;
    }//solution() end
}
