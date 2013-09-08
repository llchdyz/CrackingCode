package Tree;

import java.util.ArrayList;
import java.util.Iterator;


public class TreeSum extends BinaryTree<Integer> {
	public TreeSum(){
		super();
	}
	
	public TreeSum(Node<Integer> rootNode){
		super(rootNode);
	}

	public ArrayList<String> checkSum(int sum){
		ArrayList<String> paths = new ArrayList<>();
		int height = this.height(this.root, 0);
		Integer[] onePath = new Integer[height];
		check(sum, this.root, onePath, 0, paths);
		return paths;
		
	}

	private void check(int sum, Node<Integer> node, Integer[] onePath, int level, ArrayList<String> paths){
		if (node == null){
			return;
		}
		
		onePath[level] = node.data;
		int currentSum = 0;
		for (int i = 0; i <= level; i++){
			currentSum = currentSum + onePath[i];
		}
		
		if (sum == currentSum){
			paths.add(toStringPath(onePath, level));
		}
		
		check(sum, node.left, onePath, level+1, paths);
		check(sum, node.right, onePath, level+1, paths);
	}
	
	public String toStringPath(Integer[] one, int level){
		String path = "";
		for (int i = 0; i <= level; i++){
			path = path + " " + one[i];
		}
		return path;
	}
	
	public static void main(String[] args){
		Node<Integer> node = new Node<>(5);
		TreeSum tree = new TreeSum(node);

		Node<Integer> node1 = new Node<>(4);
		Node<Integer> node2 = new Node<>(6);
		
		tree.root.left = node1;
		tree.root.right = node2;
		
		Node<Integer> node3 = new Node<>(1);
		Node<Integer> node4 = new Node<>(8);
		
		node1.left = node3;
		node1.right = node4;
		
		Node<Integer> node5 = new Node<>(8);
		Node<Integer> node6 = new Node<>(2);
		
		node2.left = node5;
		node2.right = node6;
		
		Node<Integer> node7 = new Node<>(-3);
		node6.left = node7;
		
		tree.setIterateOrder(3);
		
		Iterator<Integer> it = tree.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("Height: " + tree.height(tree.root, -1));
		System.out.println("Paths");
		Iterator<String> itPath = tree.checkSum(10).iterator();
		while (itPath.hasNext()){
			System.out.println(itPath.next());
		}
	}
}
