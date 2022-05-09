package src.baekjoon;

import java.io.*;

public class Main1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int switchCnt = Integer.parseInt(bf.readLine());

        String[] switches = bf.readLine().split(" ");

        int studentCnt = Integer.parseInt(bf.readLine());

        for (int i = 0; i < studentCnt; i++) {
            String[] infos = bf.readLine().split(" ");
            String gender = infos[0];
            int num = Integer.parseInt(infos[1]);

            if (gender.equals("1")) {
                //남학생
                for (int j = num-1; j < switchCnt; j+=num) {
                    switches[j] = switches[j].equals("0")? "1" : "0";
                }//for end
            } else {
                //여학생
                int left = num;
                int right = num;
                while ((left>=1 && right<=switchCnt)
                        && switches[left-1].equals(switches[right-1])) {
                    switches[left-1] = switches[left-1].equals("0")? "1" : "0";
                    switches[right-1] = switches[left-1];

                    left--;
                    right++;
                }//while end
            }
        }//for end

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < switchCnt; i++) {
            if (i%20==0 && i!=0) {
                sb.append("\n");
            }
            sb.append(switches[i]).append(" ");
        }//for end

        System.out.println(sb);


    }
}
