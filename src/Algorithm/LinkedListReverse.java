package Algorithm;

public class LinkedListReverse {
	
	public void swapTwoNode(Node n1, Node n2){
		Node tmpAfter1 = n1.next;//save 2
		Node tmpPrev1 = n1.prev;//save null
		Node tmpAfter2 = n2.next;//save 3
		Node tmpPrev2 = n2.prev;//save 5
		n1.next = tmpAfter2;
		n1.prev = tmpPrev2;
		if(tmpAfter2!=null&&tmpAfter2.prev!=null){
			tmpAfter2.prev = n1;
		}
		if(tmpPrev2!=null&&tmpPrev2.next!=null){
			tmpPrev2.next = n1;
		}
		n2.next = tmpAfter1;
		n2.prev = tmpPrev1;
		if(tmpAfter1!=null&&tmpAfter1.prev!=null){
			tmpAfter1.prev = n2;
		}
		if(tmpPrev1!=null&&tmpPrev1.next!=null){
			tmpPrev1.next = n2;
		}
		
		
		
		
	}
	
	public Node reverse(Node node){
		if(node.value==3){
			return node.next;
		}
		Node nextNode = reverse(node.next);
		swapTwoNode(node, nextNode);
		nextNode = node.next;
		return nextNode;
	}
	
	public static void main(String [] args){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		n1.addNext(n2);
		n2.addNext(n3);
		n3.addNext(n4);
		n4.addNext(n5);
		
		LinkedListReverse llr = new LinkedListReverse();
		llr.reverse(n1);
		//llr.swapTwoNode(n2, n4);
		System.out.println(n5.next.value);
		
	}
}
