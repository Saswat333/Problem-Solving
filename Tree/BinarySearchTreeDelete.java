/*
- BST insertion , deletion and update:
- time complexity: 
	avg: O(log n) , O(1) - space
	worst: O(n) ,O(1) -space -- when skewed tree
- 
*********DELETION FUNCTION********************/

import java.util.*;

class BinarySearchTreeDelete{
	class Node{
		int key;
		Node left, right;
		
		public Node(int item){
			this.key = item;
			left = right = null;
		}
	}
	
	Node root;
	
	BinarySearchTreeDelete(){
		root = null;
	}
	
	public static void main(String[] args){
		BinarySearchTreeDelete  tree = new BinarySearchTreeDelete();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(80);
		tree.insert(60);
		//tree.insert();
		
		
	}
	//print the tree
	 System.out.println("Inorder traversal of the given tree");
	tree.inorder();
	
	System.out.println("\nDelete 20"); 
    tree.deleteKey(20); 
    System.out.println("Inorder traversal of the modified tree"); 
    tree.inorder(); 
		
	System.out.println("\nDelete 20"); 
    tree.deleteKey(20); 
    System.out.println("Inorder traversal of the modified tree"); 
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
	
	void deleteKey(int key){
		root = deleteRec(root, key);
	}
	
	Node deleteRec(Node root, int key){
		//base condition
		if(root == null) return root;
		
		//recur down
		//This section of code is used to put back the, previous nodes which we have traversed down to the required node.
		if(key<root.key)
			root.left = deleteRec(root.left, key);
		else if(key > root.key)
			root.right = deleteRec(root.right, key);
		else
		{//if there is key match in any level of the tree we check for 
			//if key is only one child or no child 
			if(root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			
			//node with 2 child find inorder successor
			root.key = minValue(root.right); 
			
			//delete theinorder successor
			root.right = deleteRec(root.right,root.key);
				
		}
		return root;
		
	}
	
	/* Given a non-empty binary search tree, return the node with minimum 
   key value found in that tree. Note that the entire tree does not 
   need to be searched. */
   int minValue(Node root){
	   int minV = root.key;
	   while(root.left !=null){
		   minV = root.left.key;
		   root = root.left;
	   }
	   return minV;
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