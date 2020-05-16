import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

/*
The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two leaves in the tree. 
- Basically we need to references
1. node reference : creating one single note
2. tree reference : object of tree class , which will hold the tree
Note: Height is the number f nodes along the longest path from the root node down to the farthest leaf node.
 */
//Creating node class
public class Node{
    int data;
    Node left, right;
    
    public Node(int item)
    {
        this.data = item;
        left = right = null;
    }
}
// class to use and print the tree
class BinaryTree
{
    Node root; //referenc of the root node

    //Method to calculate the diameter and return it to main
    int diameter (Node root)
    {
        // base case if there is no tree
        if(root == null)
        return 0; 



    }

    /* A wrapper over diameter(Node root) */
    int diameter(){
        return diameter(root);
    }

    /*The function Compute the "height" of a tree. */
    static int height(Node node)
    {
        //base condition
        if(node == null)
        return 0;
        else
        return()
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        //use tree ref to hold tree and root ref to hold root node(tree hold a node i.e. tree.root.left/right)
        tree.root = new Node(1); // creating the root node , by passing param to NODE constructor
        tree.root.left = new Node(2); //left child of root
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Diameter of the tree is "+ tree.diameter());
    }
}