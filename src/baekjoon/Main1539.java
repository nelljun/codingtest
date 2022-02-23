package src.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Vertex {
	Vertex left, right;
	int key;
	int level;
	
	Vertex(int key, Vertex left, Vertex right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}
}
class BSTree {
	Vertex root;
	int levelCnt;
	
	BSTree() {
		this.root = null;
	}
	
	void insert(Vertex v, int num) {
		if(num<v.key) {
			if(v.left!=null) {
				insert(v.left, num);
			} else {
				v.left = new Vertex(num, null, null);
			}
		} else if(num>v.key){
			if(v.right!=null) {
				insert(v.right, num);
			} else {
				v.right = new Vertex(num, null, null);
			}
		}
		levelCnt++;
	}//insert() end
	
}
