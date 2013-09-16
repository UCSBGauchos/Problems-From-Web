package Algorithm;

public class Node {
	int value;
	Node left;
	Node right;
	Node parents;
	boolean visited;
	
	public Node(int _value){
		this.value = _value;
		this.left=null;
		this.right=null;
		this.parents = null;
		this.visited = false;
	}
	
	public void addLeft(Node node){
		if(node != null){
			this.left = node;
			node.parents = this;
		}
	}
	
	public void addRight(Node node){
		if(node != null){
			this.right = node;
			node.parents = this;
		}
	}
}