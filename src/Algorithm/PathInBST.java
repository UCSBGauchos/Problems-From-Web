package Algorithm;

import java.util.ArrayList;


public class PathInBST {
	public ArrayList<Node> find(Node node, int pathLength){
		node.visited = true;
		ArrayList<Node> list = new ArrayList<Node>();
		if(pathLength == 0){
			list.add(node);
			return list;
		}
		
		if(node.left!=null&&node.left.visited == false){
			ArrayList<Node> preList = find(node.left, pathLength-1);
			list.addAll(preList);
		}
		if(node.right!=null&&node.right.visited == false){
			ArrayList<Node> preList = find(node.right, pathLength-1);
			list.addAll(preList);
		}
		if(node.parents!=null&&node.parents.visited == false){
			ArrayList<Node> preList = find(node.parents, pathLength-1);
			list.addAll(preList);
		}
		return list;
	}
	
	
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
		
		PathInBST nn = new PathInBST();
		ArrayList<Node> result = new ArrayList<Node>();
		result = nn.find(n3, 2);
		for(Node n: result){
			System.out.println(n.value);
		}
	}
}
