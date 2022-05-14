package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class Main1406 {

    //StringBuilder - 시간초과
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(bf.readLine());
        //현재 문자열 맨 마지막에 커서 위치해야 한다.
        int pointer = sb.length();
        //명령어 갯수
        int commandCnt = Integer.parseInt(bf.readLine());

        for (int i = 0; i < commandCnt; i++) {
            //현재 연산자
            String commandLine = bf.readLine();
            char command = commandLine.charAt(0);

            switch (command) {
                case 'L':
                    if (pointer != 0) {
                        pointer--;
                    }
                    break;
                case 'D':
                    if (pointer != sb.length()) {
                        pointer++;
                    }
                    break;
                case 'B':
                    if (pointer != 0) {
                        sb.deleteCharAt(--pointer);
                    }
                    break;
                case 'P':
                    sb.insert(pointer++, commandLine.substring(2));
                    break;
            }//switch case end
        }//for end

        System.out.println(sb);
    }

    //ListIterator -> 통과
    public static void main2(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Character> list = new LinkedList<>();

        String original = bf.readLine();

        int length = original.length();

        //초기 문자열을 문자로 나눠 list에 저장
        for (int i = 0; i < length; i++) {
            list.add(original.charAt(i));
        }//for end

        //명령어 갯수
        int commandCnt = Integer.parseInt(bf.readLine());

        //list 탐색할 listIterator
        ListIterator<Character> listIterator = list.listIterator();

        //커서 위치를 맨 마지막으로
        while (listIterator.hasNext()) {
            listIterator.next();
        }//while end

        for (int i = 0; i < commandCnt; i++) {
            //현재 연산자
            String commandLine = bf.readLine();
            char command = commandLine.charAt(0);

            switch (command) {
                case 'L' :
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                    }
                break;
                case 'D' :
                    if (listIterator.hasNext()) {
                        listIterator.next();
                    }
                break;
                case 'B' :
                    if (listIterator.hasPrevious()) {
                        /**
                         * next()나 previous() 메소드에 의해 반환된 가장 마지막 요소를 리스트에서 제거하기 때문에
                         * 제거 전에 커서를 왼쪽으로 한 칸 이동(previous())
                         */
                        listIterator.previous();
                        listIterator.remove();
                    }
                break;
                case 'P' :
                    listIterator.add(commandLine.charAt(2));
                break;
            }
        }//for end

        //최종 문자열 담을 StringBuilder
        StringBuilder sb = new StringBuilder();

        for (Character c : list) {
            sb.append(c);
        }//for end

        System.out.println(sb);
    }

    //Stack 2개
    public static void main3(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //커서 위치를 기준으로 문자 담을 Stack 2개
        Stack<Character> leftStk = new Stack<>();
        Stack<Character> rightStk = new Stack<>();

        String original = bf.readLine();

        int length = original.length();

        //왼쪽 Stack에 문자를 전부 담는다. (맨 처음 커서 위치가 문자열 맨 뒤기 때문에)
        for (int i = 0; i < length; i++) {
            leftStk.push(original.charAt(i));
        }//for end

        //명령어 갯수
        int commandCnt = Integer.parseInt(bf.readLine());

        for (int i = 0; i < commandCnt; i++) {
            //현재 연산자
            String commandLine = bf.readLine();
            char command = commandLine.charAt(0);

            switch (command) {
                case 'L' :
                    if (!leftStk.isEmpty()) {
                        //커서 왼쪽 이동 -> 왼쪽 Stack 요소 pop해서 오른쪽 Stack에 push
                        rightStk.push(leftStk.pop());
                    }
                    break;
                case 'D' :
                    if (!rightStk.isEmpty()) {
                        //커서 오른쪽 이동 -> 오른쪽 Stack 요소 pop해서 왼쪽 Stack에 push
                        leftStk.push(rightStk.pop());
                    }
                    break;
                case 'B' :
                    if (!leftStk.isEmpty()) {
                        //커서 왼쪽 문자 제거 -> 왼쪽 Stack에서 pop
                        leftStk.pop();
                    }
                    break;
                case 'P' :
                    //커서 왼쪽으로 문자 추가 -> 왼쪽 Stack에 요소 push
                    leftStk.push(commandLine.charAt(2));
                    break;
            }
        }//for end

        //앞 문자부터 출력하기 위해 오른쪽 Stack으로 전부 이동
        while (!leftStk.isEmpty()) {
            rightStk.push(leftStk.pop());
        }//while end

        StringBuilder sb = new StringBuilder();

        while (!rightStk.isEmpty()) {
            sb.append(rightStk.pop());
        }//while end

        System.out.println(sb);
    }
}
