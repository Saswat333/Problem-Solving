/*
Inorder, PreOrder and PostOrder traversal of tree
Uses of Inorder
In case of binary search trees (BST), Inorder traversal gives nodes in non-decreasing order. To get nodes of BST in non-increasing order, a variation of Inorder traversal where Inorder traversal s reversed can be used.
Example: Inorder traversal for the above-given figure is 4 2 5 1 3.
Uses of Preorder
Preorder traversal is used to create a copy of the tree. Preorder traversal is also used to get prefix expression on of an expression tree. Please see http://en.wikipedia.org/wiki/Polish_notation to know why prefix expressions are useful.
Example: Preorder traversal for the above given figure is 1 2 4 5 3.
Uses of Postorder
Postorder traversal is used to delete the tree. Please see the question for deletion of tree for details. Postorder traversal is also useful to get the postfix expression of an expression tree. Please see http://en.wikipedia.org/wiki/Reverse_Polish_notation to for the usage of postfix expression.
*/
class BTInPrePostTraversal
{
	class Node{
		Node left, right;
		int data;
		public Node(int item)
		{
			this.data = item;
			left = right = null;
		}
	}
	
	Node root;
	
	public static void main(String[] args)
	{
		BTInPrePostTraversal tree = new BTInPrePostTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
		
		System.out.println("Preorder traversal of binary tree is "); 
        tree.printPreorder(); 
  
        System.out.println("\nInorder traversal of binary tree is "); 
        tree.printInorder(); 
  
        System.out.println("\nPostorder traversal of binary tree is "); 
        tree.printPostorder(); 
	}
	
	void printPreorder{	printPreOrder(Node root);}
	
	void printInorder{ printInorder(Node root);}
	
	void printPostorder{ printPostorder(Node root);	
	
	void printPreOrder(Node node){
		if(node == null)
			return;
		else{
			System.out.print(node.data+ " ");
			printPreOrder(node.left);
			printPreOrder(node.right);
		}
	}
	
	void printInOrder(Node node){
		if(node == null)
			return;
		else{
			printPreOrder(node.left);
			System.out.print(node.data+ " ");
			printPreOrder(node.right);
		}
	}
	
	void printPostOrder(Node node){
		if(node == null)
			return;
		else{
			printPreOrder(node.left);
			printPreOrder(node.right);
			System.out.print(node.data+ " ");
		}
	}
}


























