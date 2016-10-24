package com.rj;

import java.util.Stack;

public class BinaryTree {

	public void printInorder(Node root) {
		if(root ==null){
			return;
		}
		Stack<Node> stack = new Stack<>();
		while(root !=null){
			stack.push(root);
			root = root.left;
		}
		while(!stack.isEmpty()){
			Node node = stack.pop();
			System.out.println(node.data);
			if(node.right != null){
				node = node.right;
				while (node !=null){
					stack.push(node);
					node = node.left;
				}
				
			}
		}
		
	}
	
	
	public Node deleteNode(Node root , int data){
		if(root != null){
			// Move to left sub tree
			if(data< root.data){
				root.left = deleteNode(root.left, data);
			}
			else if (data > root.data){
				root.right = deleteNode(root.right, data);
			}
			else{
				// Data Found
				//Case 1 : Leaf child
				if(root.left == null && root.right == null){
					root = null;
				}
				//Case 2: Node with one child
				else if(root.right == null){
					root = root.left;
				}else{
					//2 child
					Node min = findMin(root.right);
					System.out.println("Minimum found is " +  min.data);
					root.data = min.data;
					root.right = deleteNode(root.right, min.data);
				}
			}
		}
		return root;
	}
	
	private Node findMin(Node root){
		if(root != null){
			while(root.left != null){
				root = root.left;
			}
		}
		return root;
	}
	public static void main(String args[]) {
        
        /* creating a binary tree and entering 
         the nodes */
        BinaryTree tree = new BinaryTree();
        Node root = new Node(12);
        root.left = new Node(5);
        root.right = new Node(17);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.left.left.left = new Node(1);
        root.left.right.right = new Node(9);
        root.left.right.right.left = new Node(8);
        root.left.right.right.right = new Node(11);
        tree.printInorder(root);
        
        
        System.out.println("After deleting 5");
        tree.printInorder(tree.deleteNode(root, 5));
    }
}

/*
 * Class containing left and right child of current node and key value
 */
class Node {

	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
	
	@Override
	public String toString() {
		
		return "Data=" + this.data ;
	}
}
