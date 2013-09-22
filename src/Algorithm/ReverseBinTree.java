package Algorithm;

public class ReverseBinTree {
	
	public void reverse(Node node){
		if(node == null){
			return;
		}
		if(node.left!=null&&node.right!=null){
			Node tmp = node.left;
			node.left = node.right;
			node.right = tmp;
		}
		else if(node.left!=null&&node.right==null){
			Node rightChild = new Node(node.left.value);
			node.addRight(rightChild);
			node.left = null;
		}
		else if(node.right!=null&&node.left==null){
			Node leftChild = new Node(node.right.value);
			node.addLeft(leftChild);
			node.right = null;
		}
		reverse(node.left);
		reverse(node.right);
		
	}
	
	
	public static void main(String [] args){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		
		n1.addLeft(n2);
		n1.addRight(n3);
		n2.addLeft(n4);
		n3.addLeft(n5);
		n3.addRight(n6);
		
		ReverseBinTree rbt = new ReverseBinTree();
		rbt.reverse(n1);
		System.out.println(n1.right.right.value);
	}
}
