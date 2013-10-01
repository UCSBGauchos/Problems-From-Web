package Algorithm;

public class SwapNode {
	
	public Node swap(Node root){
		if(root == null){
			return null;
		}
		Node nextRoot = root.next.next;
		root.next.next = root;
		root.prev=root.next;
		root = root.next;
		root.prev = null;
		
		
		root.next.next = swap(nextRoot);
		if(root.next.next!=null){
			root.next.next.prev = root.next;
		}
		
		return root;
		
	}
	
	public static void main(String [] args){
		SwapNode sn = new SwapNode();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		n1.addNext(n2);
		n2.addNext(n3);
		n3.addNext(n4);
		sn.swap(n1);
		System.out.println(n2.next.next.prev.value);
	}
}
