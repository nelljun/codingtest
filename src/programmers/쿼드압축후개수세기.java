package src.programmers;

public class 쿼드압축후개수세기 {

    public static void main(String[] args) {
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        solution(arr);
    }//main() end

    public static int[] solution(int[][] arr) {
        compress(arr, arr.length, 0, 0);
        System.out.println("zero : "+theNumOfZero+", one : "+theNumOfOne);
        int[] answer = {theNumOfZero, theNumOfOne}
        return answer;
    }//solution() end

    static int theNumOfOne = 0;
    static int theNumOfZero = 0;

    //재귀호출
    public static void compress(int[][] arr, int size, int startCol, int startRow) {
        //size==1인 경우 (즉, 압축이 되지 않은 경우)
        //현재 요소 값에 맞춰 0 혹은 1의 갯수 올림
        //중단조건1
        if(size==1) {
            if(arr[startRow][startCol]==1) {
                theNumOfOne++;
            } else {
                theNumOfZero++;
            }
            return;
        }

        //현재 위치, 현재 사이즈의 2차원 배열 요소 합 구하기
        int sum = 0;
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                sum += arr[startRow+i][startCol+j];
            }//for end
        }//for end

        //중단조건2. 모든 요소가 0인 경우
        if(sum==0) {
            theNumOfZero++;
            return;
        }
        //중단조건3. 모든 요소가 1인 경우
        if(sum==size*size) {
            theNumOfOne++;
            return;
        }

        //4등분 하기 때문에 size->size/2, 시작 위치는 4군데 다르게 해서 재귀호출
        compress(arr, size/2, startCol, startRow);
        compress(arr, size/2, startCol+size/2, startRow);
        compress(arr, size/2, startCol, startRow+size/2);
        compress(arr, size/2, startCol+size/2, startRow+size/2);
    }//compress() end
}
