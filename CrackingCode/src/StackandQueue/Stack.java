package StackandQueue;

import java.util.Iterator;


public class Stack<Item> implements Iterable<Item>{
	public Node<Item> top = null;
	
	public Stack(){
		
	}

	public boolean push(Item data){
		Node<Item> node = new Node<>(data);
		node.next = top;
		top = node;
		return true;
		
	}
	public Node<Item> pop(){
		if (top == null){
			return null;
		} else{
			Node<Item> t = top;
			top = top.next;
			return t;
		}
	}
	
	public Item peek(){
		if (top == null){
			return null;
		}
		return top.data;
	}
	
	public boolean isEmpty(){
		return top == null;
	}

	public Iterator<Item> iterator() {

		return new stackIterator();
	}
	
	public class stackIterator implements Iterator<Item>{

		public Node<Item> current = top;
		public boolean hasNext() {
			
			return current != null;
		}

		@Override
		public Item next() {
			Item data = current.data;
			current = current.next;
			return data;
		}

		@Override
		public void remove() {
			// unsupported
			
		}
	}
}
