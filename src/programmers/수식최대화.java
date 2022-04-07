package src.programmers;

import java.util.*;

public class 수식최대화 {
    public static void main(String[] args) {
        String expression = "100-200*300-500+21";
        solution(expression);
    }

    public static long solution(String expression) {
        //numList : 숫자만 담은 list
        LinkedList<String> numList = new LinkedList<>();
        String[] numArr = expression.split("[+]|[-]|[*]");
        Collections.addAll(numList, numArr);

        //operandLst : 연산자만 담은 list
        String allOperand = expression.replaceAll("[0-9]", "");
        char[] chars = allOperand.toCharArray();
        LinkedList<Character> operandList = new LinkedList<>();
        for (char operand : chars) {
            operandList.add(operand);
        }//for end

        long max = 0L;

        //6가지 경우의 수에 맞춰 연산 후 최댓값 리턴
        //매 경우의 수 마다 새로운 numList, operandList를 파라미터로 넘김
        max = Math.max(operate(new LinkedList<>(numList),
                               new LinkedList<>(operandList),
                               '+', '-', '*'), max);
        max = Math.max(operate(new LinkedList<>(numList),
                               new LinkedList<>(operandList),
                               '+', '*', '-'), max);
        max = Math.max(operate(new LinkedList<>(numList),
                               new LinkedList<>(operandList),
                               '-', '+', '*'), max);
        max = Math.max(operate(new LinkedList<>(numList),
                               new LinkedList<>(operandList),
                               '-', '*', '+'), max);
        max = Math.max(operate(new LinkedList<>(numList),
                               new LinkedList<>(operandList),
                               '*', '+', '-'), max);
        max = Math.max(operate(new LinkedList<>(numList),
                               new LinkedList<>(operandList),
                               '*', '-', '+'), max);

        return max;
    }//solution() end

    //연산자 우선순위대로 연산하는 method
    public static long operate(LinkedList<String> numList,
                               LinkedList<Character> operandList,
                               char... operandArr) {
        //'+', '-', '*' 연산자 우선순위에 맞춰 연산
        for (int i = 0; i < operandArr.length; i++) {
            //해당 연산자가 없을 때까지 반복
            while (operandList.contains(operandArr[i])) {
                //현재 연산자의 위치 (operandList 내에서)
                int index = operandList.indexOf(operandArr[i]);

                //연산자의 위치가 index면, numList의 index번째 요소와 index+1번째 요소 연산
                long result = calculate(Long.parseLong(numList.get(index)),
                                        Long.parseLong(numList.get(index+1)),
                                        operandArr[i]);
                //연산을 마친 수 2개를 numList에서 제거
                numList.remove(index);
                numList.remove(index);
                //결과값을 해당 index에 삽입
                numList.add(index, String.valueOf(result));

                //연산이 끝난 연산자는 operandList에서 제거
                operandList.remove(index);
            }//while end
        }//for end

        //모든 연산을 마치고 numList에 최종으로 남은 수의 절대값 리턴
        return Math.abs(Long.parseLong(numList.get(0)));
    }//operate() end

    public static long calculate(long a, long b, char operand) {
        return switch (operand) {
            case '+' -> a+b;
            case '-' -> a-b;
            case '*' -> a*b;
            default -> 0L;
        };
    }
}
