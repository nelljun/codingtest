package src.programmers;

import java.util.ArrayList;
import java.util.Comparator;

public class 길찾기게임 {

    /**
     * 다른 순서로 순회 -> 먼저 마친 팀 승리
     *
     * 모든 노드는 서로 다른 x
     * 같은 레벨 노드는 같은 y
     * x값 이진탐색 트리 구조
     *
     * 전위 순회 : 부모 - 왼 - 오
     * 후위 : 좌 - 우 - 부모
     */

    static class Node {
        int num;
        int x;
        int y;

        Node parent;
        Node leftChild;
        Node rightChild;

        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        
        solution(nodeinfo);
    }

    public static int[][] solution(int[][] nodeinfo) {
        int nodeCnt = nodeinfo.length;

        //넣을 순서대로 정렬한 nodeList
        ArrayList<Node> nodeList = makeOrderNodeList(nodeinfo, nodeCnt);

        //root node
        Node root = nodeList.get(0);

        //BST 생성 (노드들간 관계 맺기)
        for (int i = 1; i < nodeCnt; i++) {
            addNode(root, nodeList.get(i));
        }//for

        //순회 결과 담을 list
        ArrayList<Integer> preOrderList = new ArrayList<>();
        ArrayList<Integer> postOrderList = new ArrayList<>();

        //순회
        preOrder(root, preOrderList, nodeCnt);
        postOrder(root, postOrderList, nodeCnt);

        //list -> array
        int[] preOrderResult = preOrderList.stream()
                                            .mapToInt(Integer::intValue)
                                            .toArray();

        int[] postOrderResult = postOrderList.stream()
                                                .mapToInt(Integer::intValue)
                                                .toArray();

        int[][] answer = new int[2][];
        answer[0] = preOrderResult;
        answer[1] = postOrderResult;

        return answer;
    }//solution() end

    private static void preOrder(Node parent, ArrayList<Integer> result, int nodeCnt) {
        if (parent==null) {
            return;
        }//if end

        result.add(parent.num); //부모 방문
        preOrder(parent.leftChild, result, nodeCnt); //left subtree 이동
        preOrder(parent.rightChild, result, nodeCnt); //right subtree 이동
    }//preOrder() end

    private static void postOrder(Node parent, ArrayList<Integer> result, int nodeCnt) {
        if (parent==null) {
            return;
        }//if end

        postOrder(parent.leftChild, result, nodeCnt);
        postOrder(parent.rightChild, result, nodeCnt);
        result.add(parent.num);
    }//postOrder() end

    private static void addNode(Node parent, Node node) {
        int parentX = parent.x;
        int nodeX = node.x;

        if (parentX<nodeX) {
            if (parent.rightChild==null) {
                node.parent = parent;
                parent.rightChild = node;
            } else {
                addNode(parent.rightChild, node);
            }//if~else end
        } else {
            if (parent.leftChild==null) {
                node.parent = parent;
                parent.leftChild = node;
            } else {
                addNode(parent.leftChild, node);
            }//if~else end
        }//if~else end
    }//addNode() end

    private static ArrayList<Node> makeOrderNodeList(int[][] nodeinfo, int nodeCnt) {
        ArrayList<Node> nodeList = new ArrayList<>();

        for (int i = 0; i < nodeCnt; i++) {
            nodeList.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }//for end

        nodeList.sort(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                //1. y좌표 큰 순서대로
                int result = Integer.compare(n2.y, n1.y);

                //2. y좌표 같다면 x좌표 작은 순서대로
                if (result==0) {
                    return Integer.compare(n1.x, n2.x);
                }//if end

                return result;
            }
        });

        return nodeList;
    }
}
