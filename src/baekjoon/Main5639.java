package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Tree {
	Node root;
	
	Tree() {
		this.root = null;
	}
	
	public void insert(int key) {
		root = insertNode(root, key);
	}
	
	private Node insertNode(Node node, int key) {
		Node newNode = new Node(key, null, null);
		if(node==null) {
			return newNode;
		} else {
			if(node.key<key) {
				node.right = insertNode(node.right, key);
			} else if(node.key>key){
				node.left = insertNode(node.left, key);
			}
		}//if end
		
		return node;
	}//insertNode() end
	
	public void postOrder() {
		postOrderTraversal(root);
	}
	
	private void postOrderTraversal(Node node) {
		if(node==null) {
			return;
		}
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.println(node.key);
	}
}

class Node {
	int key;
	Node left;
	Node right;
	
	Node(int key, Node left, Node right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}
}

public class Main5639 {
	
	public static void main(String[] args) throws IOException {
		Tree tree = new Tree();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String numStr;
		while(true) {
			numStr = bf.readLine();
			if(numStr==null || numStr.equals("")) break;
			tree.insert(Integer.parseInt(numStr));
		}
		tree.postOrder();
	}

	
}
