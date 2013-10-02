package Algorithm;

import java.util.ArrayList;
import java.util.Stack;

public class DP {
	
	ArrayList<Stack<Integer>> lists = new ArrayList<Stack<Integer>>();
	Stack<Integer> list = new Stack<Integer>();
	public void DP(Node node){
		if(node==null){
			return;
		}
		if(!list.contains(node.value)){
			list.add(node.value);
			DP(node.left);
			DP(node.right);
		}
		if(node.left==null&&node.right==null){
			System.out.println(node.value);
			Stack<Integer> newList = new Stack<Integer>();
			newList.addAll(list);
			lists.add(newList);
		}
		list.pop();
	}
	
	
	public static void main(String [] args){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		n1.addLeft(n2);
		n1.addRight(n5);
		n2.addLeft(n3);
		n2.addRight(n4);
		n5.addLeft(n6);
		n5.addRight(n7);
		DP dp = new DP();
		dp.DP(n1);
		System.out.println(dp.lists);
	}
}
