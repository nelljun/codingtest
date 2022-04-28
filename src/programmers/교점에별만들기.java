package src.programmers;

import java.util.*;


public class 교점에별만들기 {

    static class Cross {
         long x;
         long y;
         Cross(long x, long y) {
             this.x = x;
             this.y = y;
         }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Cross) {
                Cross temp = (Cross) obj;
                return (this.x==temp.x) && (this.y==temp.y);
            }
            return false;
        }//equals() end

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static HashSet<Cross> crossSet = new HashSet<>();

    public static void main(String[] args) {

        int[][] lines1 = {{2,-1,4},{-2,-1,4},{0,-1,1},{5,-8,-12},{5,8,12}};
        int[][] lines2 = {{1,-1,0},{2,-1,0},{4,-1,0}};
        solution(lines1);
    }//main() end


    public static void solution(int[][] line) {
        int theNumOfLine = line.length;

        for(int i=0; i<theNumOfLine; i++) {
            for(int j=i+1; j<theNumOfLine; j++) {
                crossCheck(line[i], line[j]);
            }//for end
        }//for end

        StringBuilder sb = new StringBuilder();

        Iterator<Cross> iter = crossSet.iterator();
        long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE, maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;
        while(iter.hasNext()) {
            Cross nextCross = iter.next();
            minX = Math.min(minX, nextCross.x);
            maxX = Math.max(maxX, nextCross.x);
            minY = Math.min(minY, nextCross.y);
            maxY = Math.max(maxY, nextCross.y);
        }//while end

        iter = crossSet.iterator();
        while(iter.hasNext()) {
            Cross nextCross = iter.next();
            nextCross.x -= minX;
            nextCross.y -= minY;
        }
        long height = (maxY-minY)+1;
        long width = (maxX-minX)+1;
        String[] answer = new String[(int)height];
        for(int i=0; i<width; i++) {
            sb.append(".");
        }//for end
        Arrays.fill(answer, sb.toString());

        for(Cross cross : crossSet) {
            int index = (int)(height-1-cross.y);
            answer[index] = answer[index].substring(0, (int)cross.x)+"*"+answer[index].substring((int)cross.x+1);
        }//for() end

    }//solution() end

    public static void crossCheck(int[] line1, int[] line2) {
        long a = line1[0];
        long b = line1[1];
        long e = line1[2];
        long c = line2[0];
        long d = line2[1];
        long f = line2[2];
        if(a*d!=b*c) {
            if((b*f-e*d)%(a*d-b*c)==0
            && (e*c-a*f)%(a*d-b*c)==0) {
                //x, y 모두 정수일 때만
                //set에 저장 {x, y}
                Cross newCross = new Cross((b*f-e*d)/(a*d-b*c),(e*c-a*f)/(a*d-b*c));
                crossSet.add(newCross);
            }//if end
        }//if end
    }//crossCheck() end
}
