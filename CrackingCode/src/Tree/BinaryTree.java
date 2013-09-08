package Tree;

import java.util.Iterator;
import StackandQueue.Queue;
import StackandQueue.Stack;
/**
 * 
 * @author Leon
 * Including tree implementation, tree traverse(r and non-r)
 * @param <Item>
 */
public class BinaryTree<Item> implements Iterable<Item>{
	public Node<Item> root = null;
	private int order;
	private int size;
	
	public BinaryTree(){
		
	}
	
	public BinaryTree(Node<Item> rootNode){
		this.root = rootNode;
		
	}
	
	/*
	public boolean addLeft(Node<Item> parent, Node<Item> child){
		if (parent == null){
			System.out.println("No parent specified.");
			return false;
		}
		parent.left = child;
		this.size++;
		return true;
	}
	
	public boolean addRight(Node<Item> parent, Node<Item> child){
		if (parent == null){
			System.out.println("No parent specified.");
			return false;
		}
		parent.right = child;
		this.size++;
		return true;
	}	
	
	public boolean setRoot(Node<Item> node){
		if (this.root != null){
			this.root.data = node.data;
		} else {
			this.root = node;
		}
		return true;
		
	}
	*/
	
	public int height(Node<Item> node, int height){
		if (node == null){
			return height;
		} else {
			height = height + 1;
		}

		return Math.max(height(node.right, height), height(node.left,height));
	}
	

	
	public boolean setIterateOrder(int order){
		if (order != 1 && order != 2 && order != 3){
			System.out.println("Type in a volid order(1, 2 or 3), please!");
			return false;
		}
		this.order = order;
		return true;
	}
	
	public Iterator<Item> iterator(){
		return new treeIterator(this.order);
	}
	
	
	public class treeIterator implements Iterator<Item>{
		private Queue<Item> queue =  new Queue<Item>();
		private Iterator<Item> it = null;
		private Stack<Node<Item>> s = new Stack<>();
		
		public treeIterator(int order){
			
			if (order == 1){
				System.out.println("Pre Order Iteration");
				//preorder(root);
				preorderNR(root);
			} else if (order == 2){
				System.out.println("In Order Iteration");
				//inorder(root);
				inorderNR(root);
			} else{
				System.out.println("Post Order Iteration");
				//postorder(root);
				postorderNR(root);
			}
			it = queue.iterator();
		}
		
		private void postorder(Node<Item> r) {
			if (r == null){
				System.out.println("Root is null");
				return;
			}
			
			if (r.hasLeft()) postorder(r.left);
			if (r.hasRight()) postorder(r.right);
			queue.enqueue(r.data);
			
		}

		private void inorder(Node<Item> r) {
			if (r == null){
				System.out.println("Root is null");
				return;
			}

			if (r.hasLeft()) inorder(r.left);
			queue.enqueue(r.data);
			if (r.hasRight()) inorder(r.right);
			
		}

		private void preorder(Node<Item> r) {
			if (r == null){
				System.out.println("Root is null");
				return;
			}
			
			queue.enqueue(r.data);
			if (r.hasLeft()) preorder(r.left);
			if (r.hasRight()) preorder(r.right);
		}
		
		private void preorderNR(Node<Item> r){
			if (r == null){
				return;
			}
			
			while (r != null){
				while (r != null){
					queue.enqueue(r.data);
					if (r.hasRight()) s.push(r.right);
					r = r.left;
				}
				
				if (!s.isEmpty()){
					r = s.pop().data;
				}
			}
		}
		
		private void inorderNR(Node<Item> r){
			if (r == null){
				return;
			}
			
			while (r != null || !s.isEmpty()){
				while (r != null){
					s.push(r);
					r = r.left;
				}

				if (!s.isEmpty()){
					r = s.pop().data;
					queue.enqueue(r.data);
					r = r.right;
				}
			}
		}
		
		private void postorderNR(Node<Item> r){
			if (r == null){
				return;
			}
			
			while (r != null || !s.isEmpty()){
				
				while (r != null){
	
					s.push(r);
					if (r.hasLeft()){
						r = r.left;
					} else {
						r = r.right;
					}
				}
				
				if (!s.isEmpty()){
					r = s.pop().data;
					queue.enqueue(r.data);
				}	
				
				while (!s.isEmpty() && s.peek().right == r){
					r = s.pop().data;
					queue.enqueue(r.data);

				}
				
				if (!s.isEmpty()){
					r = s.peek().right;
				} else {
					r = null;
				}
			}
		}
		@Override
		public boolean hasNext() {
			
			return it.hasNext();
		}

		@Override
		public Item next() {
			return it.next();
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

	public static void main(String[] args){
		BinaryTree<String> tree = new BinaryTree<String>();
		Node<String> node = new Node<>("S");
		tree.root = node;
		Node<String> node1 = new Node<>("A");
		Node<String> node2 = new Node<>("B");
		
		node.left = node1;
		node.right = node2;
		
		Node<String> node3 = new Node<>("G");
		Node<String> node4 = new Node<>("C");
		
		node1.left = node3;
		node1.right = node4;
		
		Node<String> node5 = new Node<>("F");
		Node<String> node6 = new Node<>("Z");
		
		node2.left = node5;
		node2.right = node6;
		
		Node<String> node7 = new Node<>("M");
		node6.left = node7;
		
		tree.setIterateOrder(3);
		
		Iterator<String> it = tree.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println("Heigth: " + tree.height(tree.root,-1));
	}

}
