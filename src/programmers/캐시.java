package src.programmers;

import java.util.*;

public class 캐시 {

    public static void main(String[] args) {
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        solution(cacheSize, cities);
    }//main() end

    public static int solution(int cacheSize, String[] cities) {

        if (cacheSize==0) {
            return cities.length * 5;
        }

        int totalTime = 0;

        List<String> cache = new LinkedList<>();

        for (String city : cities) {
            String lowerCity = city.toLowerCase(Locale.ROOT);
            if(cache.contains(lowerCity)) {
                //cache hit
                cache.remove(lowerCity);
                cache.add(lowerCity);
                totalTime += 1;
            } else {
                //cache miss
                if(cache.size() == cacheSize) {
                    cache.remove(0);
                }
                cache.add(lowerCity);
                totalTime += 5;
            }//if~else
        }//for end

        return totalTime;

    }//solution() end

}
