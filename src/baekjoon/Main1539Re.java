package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Node2 {
	Node2 left, right;
	int key;
	int level;
	
	Node2(int key, Node2 left, Node2 right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}
}
class BSTree2 {
	Node2 root;
	int levelCnt;
	
	BSTree2() {
		this.root = null;
	}
	
	void insert(int num) {
		Node2 newNode = new Node2(num, null, null);
		if(root==null) {
			root = newNode;
			return;
		}
		Node2 currNode = root;
		Node2 parentNode = null;
		while(true) {
			parentNode = currNode;
			if(num<currNode.key) {
				currNode = currNode.left;
				levelCnt++;
				if(currNode==null) {
					parentNode.left = newNode;
					return;
				}
			} else {
				currNode = currNode.right;
				levelCnt++;
				if(currNode==null) {
					parentNode.right = newNode;
					return;
				}
			}
		}//while end
	}//insert() end
	
}
public class Main1539Re {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(bf.readLine());
		int[] numArr = new int[size];
		
		BSTree2 BSTree2 = new BSTree2();
		
		for(int i=0; i<size; i++) {
			numArr[i] = Integer.parseInt(bf.readLine());
			BSTree2.insert(numArr[i]);
		}//for end
		
		System.out.println(BSTree2.levelCnt+size);
		
	}//main() end
	
}
