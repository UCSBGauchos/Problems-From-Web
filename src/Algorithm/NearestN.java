package Algorithm;

import java.util.ArrayList;

public class NearestN {
	
	public int N;
	public void Nearest(Node node){
		if(node == null){
			return;
		}
		node.visited=true;
		if(node.left!=null&&N!=0&&node.left.visited==false){
			System.out.println("node "+node.left.value+" got");
			N=N-1;
		}
		if(node.right!=null&&N!=0&&node.right.visited==false){
			System.out.println("node "+node.right.value+" got");
			N=N-1;
		}
		if(node.parents!=null&&N!=0&&node.parents.visited==false){
			System.out.println("node "+node.parents.value+" got");
			N=N-1;
		}
		if(N!=0){
			if(node.left!=null&&node.left.visited == false){
				Nearest(node.left);
			}
			if(node.right!=null&&node.right.visited == false){
				Nearest(node.right);
			}
			if(node.parents!=null&&node.parents.visited == false){
				Nearest(node.parents);
			}
		}
	}
		
		
		
//		if(node.left!=null&&node.left.visited==false){
//			Nearest(node.left,N-1);
//		}
//		if(node.right!=null&&node.right.visited==false){
//			Nearest(node.right,N-1);
//		}
//		if(node.parents!=null&&node.parents.visited==false){
//			Nearest(node.parents,N-1);
//		}
	
	public static void main(String [] args){
		Node n1 = new Node(1);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);

		n5.addLeft(n3);
		n5.addRight(n7);
		n3.addLeft(n1);
		n3.addRight(n4);
		n7.addLeft(n6);
		n7.addRight(n8);
		
		NearestN nn = new NearestN();
		nn.N = 6;
		nn.Nearest(n3);
	}
}
