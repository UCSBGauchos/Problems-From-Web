package Algorithm;

public class SwapChildrenInTree {
	
	public void swap(Node root){
		if(root == null){
			return;
		}
		if(root.left!=null&&root.right!=null){
			Node tmp = root.left;
			System.out.println(tmp.value);
			root.left = root.right;
			System.out.println(tmp.value);
			root.right = tmp;
		}else if(root.left==null&&root.right!=null){
			root.left = root.right;
			root.right = null;
		}else if(root.left!=null&&root.right==null){
			root.right = root.left;
			root.left = null;
		}
		swap(root.left);
		swap(root.right);
	}
	
	public static void main(String [] args){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		n1.addLeft(n2);
		n1.addRight(n5);
		n2.addLeft(n3);
		n2.addRight(n4);
		SwapChildrenInTree scit = new SwapChildrenInTree();
		scit.swap(n1);
		//System.out.println(n1.right.value);
		
	}
}
