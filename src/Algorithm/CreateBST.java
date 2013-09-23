package Algorithm;

import java.util.ArrayList;

public class CreateBST {
	
	public void BST(Node root, Node node){
		if(node.value<root.value&&root.left==null){
			root.left = node;
			return;
		}else if(node.value<root.value&&root.left!=null){
			BST(root.left, node);
		}else if(node.value>root.value&&root.right==null){
			root.right = node;
			return;
		}else if(node.value>root.value&&root.right!=null){
			BST(root.right, node);
		}
	}
	
	public static void main(String [] args){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(4);
		Node root = new Node(2);
		CreateBST cb = new CreateBST();
		for(int i: list){
			Node node = new Node(i);
			cb.BST(root, node);
		}
		System.out.println(root.right.right.value);
		
	}
}
