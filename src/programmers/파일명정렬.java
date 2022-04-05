package src.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 파일명정렬 {
    public static void main(String[] args) {
        String[] files1 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] files2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        String[] files3 = {"img000012345", "img1.png","img2","IMG02"};

        solution(files3);
    }

    static class File implements Comparable<File> {
        String head;
        String number;
        String tail;

        public void setHead(String head) {
            this.head = head;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public void setTail(String tail) {
            this.tail = tail;
        }

        @Override
        public int compareTo(File o) {
            int result = this.head.compareToIgnoreCase(o.head);
            if (result==0) {
                result = (Integer.parseInt(this.number) - Integer.parseInt(o.number));
            }
            return result;
        }

        @Override
        public String toString() {
            return head+number+tail;
        }
    }

    public static String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();
        File newFile = new File();

        for (String file : files) {
            int length = file.length();

            int i = 0;
            for (; i < length; i++) {
                if (file.charAt(i)>='0' && file.charAt(i)<='9') {
                    newFile.setHead(file.substring(0,i));
                    break;
                }
            }//for end

            int j = i;
            int last = Math.min(i+5, length);
            for (; j < last; j++) {
                char charAt = file.charAt(j);
                if (!(charAt>='0' && charAt<='9')) {
                    newFile.setNumber(file.substring(i, j));
                    newFile.setTail(file.substring(j));
                    break;
                }
            }//for end

            if (j==last) {
                newFile.setNumber(file.substring(i, j));
                newFile.setTail(file.substring(j));
            }

            fileList.add(newFile);
        }//for end

        Collections.sort(fileList);

        String[] answer = new String[files.length];

        for (int i = 0; i < files.length; i++) {
            answer[i] = fileList.get(i).toString();
        }//for end

        return answer;

    }//solution() end
}
