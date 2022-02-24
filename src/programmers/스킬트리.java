package src.programmers;

public class 스킬트리 {

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skillTrees = {"BACDE", "CBADF", "AECB", "BDA"};
        solution(skill, skillTrees);
    }//main() end

    public static void solution(String skill, String[] skillTrees) {

        char[] charArr = skill.toCharArray();

        int index = -1;
        int cnt = 0;
        boolean check = true;
        for (String skillTree : skillTrees) {
            System.out.println(skillTree);
            check = true;
            index = -1;
            int length = skillTree.length();
            for (int i = 0; i < length; i++) {
                for (int j = index+1; j < charArr.length; j++) {
                    if (skillTree.charAt(i) == charArr[j]) {
                        if (j!=index+1) {
                            check = false;
                            break;
                        } else {
                            index++;
                        }//if else end
                    }//if end
                }//for end
                if(!check) break;
            }//for end
            if(check) {
                cnt++;
                System.out.println("count!");
            }

        }

        System.out.println(cnt);

    }//solution() end
}
