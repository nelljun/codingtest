package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main1991 {

	static class Node {
		String data;
		Node left, right;
		
		Node(String data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	static class Tree {
		Node root;
		Node pointer;
		StringBuilder sb;
		
		Tree() {
			this.root = null;
			this.pointer = null;
			this.sb = new StringBuilder();
		}
		
		private void search(String data) {
			pointer = null;
			searchNode(root, data);
		}//search() end
		
		private void searchNode(Node node, String data) {
			//pointer가 찾는 노드를 가리키도록 만듬
				if(node==null) {
					return;
				}
				if(node.data.equals(data)) {
					this.pointer = node;
					return;
				}
				if(node.left!=null && pointer==null) {
					searchNode(node.left, data);
				}
				if(node.right!=null && pointer==null) {
					searchNode(node.right, data);
				}
			
		}//searchNode() end
		
		void insertNode(String data, String left, String right) {
			search(data); //data에 해당하는 노드 찾기
			if(pointer==null) {
				//root = null인 경우
				root = new Node(data);
				if(!left.equals(".")) {
					root.left = new Node(left);
				};
				if(!right.equals(".")) {
					root.right = new Node(right);
				};
			} else {
				if(!left.equals(".")) {
					pointer.left = new Node(left);
				};
				if(!right.equals(".")) {
					pointer.right = new Node(right);
				};
			}
		}//insertNode() end
		
		private void preOrder(Node node) {
			if(node==null) {
				return;
			}
			sb.append(node.data); //루트 방문
			preOrder(node.left); //좌측 자식으로 이동
			preOrder(node.right); //우측 자식으로 이동
		}//preOrder() end
		private void inOrder(Node node) {
			if(node==null) {
				return;
			}
			inOrder(node.left);
			sb.append(node.data);
			inOrder(node.right);
		}//inOrder() end
		private void postOrder(Node node) {
			if(node==null) {
				return;
			}
			postOrder(node.left);
			postOrder(node.right);
			sb.append(node.data);
		}//postOrder() end
		
		public void preOrderTraversal() {
			sb.setLength(0);
			preOrder(root);
			System.out.println(sb);
		}//preOrderTraversal() end
		public void inOrderTraversal() {
			sb.setLength(0);
			inOrder(root);
			System.out.println(sb);
		}//inOrderTraversal() end
		public void postOrderTraversal() {
			sb.setLength(0);
			postOrder(root);
			System.out.println(sb);
		}//postOrderTraversal() end
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine()); 
		
		StringTokenizer tokenizer;
		Tree tree = new Tree();
		
		for(int i=0; i<num; i++) {
			tokenizer = new StringTokenizer(br.readLine(), " ");
			tree.insertNode(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
		}//for end
		
		tree.preOrderTraversal();
		tree.inOrderTraversal();
		tree.postOrderTraversal();
		
	}
}
