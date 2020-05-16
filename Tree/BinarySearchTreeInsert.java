/*
- BST insertion , deletion and update:
- time complexity: 
	avg: O(log n) , O(1) - space
	worst: O(n) ,O(1) -space -- when skewed tree
- 
*/

import java.util.*;

class BinarySearchTreeInsert{
	class Node{
		int key;
		Node left, right;
		
		public Node(int item){
			this.key = item;
			left = right = null;
		}
	}
	
	Node root;
	
	BinarySearchTreeInsert(){
		root = null;
	}
	
	public static void main(String[] args){
		BinarySearchTreeInsert  tree = new BinarySearchTreeInsert();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(80);
		tree.insert(60);
		//tree.insert();
		
		
	}
	//print the tree
	tree.inorder();
	
	
	void insert(int key){
		//call recursive method to insert 
		// return node to keep the current update reference to the root node, as root is global reference it remember every updated node
		root = insertRec(root, key);
	}
	
	Node insertRec(Node root,int key ){
		//NOTE: this root is local root reference so it can't remember updated references of new nodes.
		// if root is empty create a root 
		if(root == null){
			root = new Node(key);
			return root;
		}
		
		if(key < root.key){
			root.left = insertRec(root.left,key);
		}
		
		if(key > root.key){
			root.right = insertRec(root.right, key);
		}
		
		return root;
	}
	
	void inorder(){
		inorderRec(root);
	}
	
	void inorderRec(Node root){
		if(root != null){
			inorderRec(root.left);
			System.out.println(root.key);
			inorderRec(root.right);
		}
	}
}

/************** SEARCH FUNCTION****************
// A utility function to search a given key in BST 
public Node search(Node root, int key) 
{ 
    // Base Cases: root is null or key is present at root 
    if (root==null || root.key==key) 
        return root; 
  
    // val is greater than root's key 
    if (root.key > key) 
        return search(root.left, key); 
  
    // val is less than root's key 
    return search(root.right, key); 
}
*/