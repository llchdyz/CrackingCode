package Tree;

public class Node<Item> {
	public Node<Item> left = null;
	public Node<Item> right = null;
	public Item data;
	public boolean visited = false;
	
	public Node(Item data, Node<Item> left, Node<Item> right){
		this.data = data;
		this.left = left;
		this.right = right;
		this.visited = false;
	}
	
	public Node(Item data){
		this.data = data;
	}
	
	public boolean hasLeft(){
		return this.left != null;
	}
	
	public boolean hasRight(){
		return this.right != null;
	}
	
}
