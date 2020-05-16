/*
LEVEL ORDER TREE TRAVERSAL
- using queue
- using tree(sol-1)
*/
//Solution-1
class Node
{
	int data;
	Node left, right;
	public Node(int item)
	{
		data = item;
		left = right = null;
	}
}

class BinaryTree
{
	Node root;
	
	public BinaryTree()
	{
		root = null;
	}
	
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left= new Node(2); 
        tree.root.right= new Node(3); 
        tree.root.left.left= new Node(4); 
        tree.root.left.right= new Node(5); 
		
		System.out.println("Level order printing: ");
		tree.printLevelOrder();	
	}
	
	//function to print level order traversal of tree
	void printLevelOrder()
	{
		int h = height(root);
		for(int i=1;i<h;i++)
			printGivenLevel(root,i)
	}
	
	//prints a given level by printLevelOrder()
	void printGivenLevel(Node root, int level)
	{
		//keep reducing level till u reach level 1 and print the value
		if(root == null)
			return;
		if( level == 1)
			System.out.print(root.data + " ");
		else
		{
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right,level-1);
		}
	}
	
	int height(Node root)
	{
		//calculate height of the tree
		if(root == null)
			return 0;
		else
		{
			int lheight = height(root.left);
			int rheight = height(root.right);
			
			if(lheight>rheight)
				return (lheight+1);
			else
				return(rheight+1);
		}
	}
}

//Solution -2 (using Queue)
import java.util.Queue;
import java.util.LinkedList;

class Node
{
	int data;
	Node left, right;
	public Node(int item)
	{
		data = item;
		left = right = null;
	}
}


class BinaryTreeTraversal
{
	Node root;
	
	public BinaryTree()
	{
		root = null;
	}
	
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left= new Node(2); 
        tree.root.right= new Node(3); 
        tree.root.left.left= new Node(4); 
        tree.root.left.right= new Node(5); 
		
		System.out.println("Level order printing: ");
		tree.printLevelOrder();	
	}
	
	void printLevelOrder()
	{
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			Node temp_node = queue.poll();
			System.out.print(temp_node.data + " ");
			if(temp_node.left != null)
				queue.add(temp_node.left)
			if(temp_node.right != null)
				queue.add(temp_node.right)
		}
	}
}



