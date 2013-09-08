package LinkedList;

import java.util.Iterator;

public class LinkedList implements Iterable<Integer>{
	public LinkedListNode<Integer> start = null;
	public LinkedList(LinkedListNode<Integer> start){
		this.start = start;
	}
	
	public LinkedList(){
		
	}
	
	public boolean insert(Integer data){
		LinkedListNode<Integer> node = new LinkedListNode<>(data);
		LinkedListNode<Integer> current = start;
		if (start == null){
			start = node;
			return true;
		}
		while (current.hasNext()){
			current = current.next;
		}
		
		current.next = node;
		return true;
			
	}
	
	public Integer removeFirst(){
		if (start == null){
			return null;
		}
		LinkedListNode<Integer> node = start;
		start= node.next;
		return node.data;
	}
	
	public Integer peek(){
		if (start == null){
			return null;
		}
		return start.data;
	}
	/**
	 * Used to create a loop linked list
	 * @param ahead node we want to insert after
	 * @param data node we want to insert
	 * @return 
	 */
	public boolean insertAfter(int ahead, int data){
		// check whether the start node is empty 
		if (start == null){
			System.out.println("No Valid Data!");
			return false;
		}
		// find whether node exists
		LinkedListNode<Integer> current = start;
		LinkedListNode<Integer> node = null;
		while(true){
			if (current.data.equals(data)){
				node = current;
				break;
			}
			
			if (current.hasNext()){
				current = current.next;
			} else {
				node = new LinkedListNode<>(data);
				break;
			}
		}

		current = start;
		while (true){
			if (current.data.equals(ahead)){
				current.next = node;
				break;
			}
			
			if(!current.hasNext()){
				System.out.println("Can't find the place to insert!");
				return false;
			} else {
				current = current.next;
			}
		}
		
		return true;
	} 
	
	public String toString(){
		String strList = "";
		if (start == null){
			return strList;
		}
		LinkedListNode<Integer> current = start;

		while (current.hasNext()){
			strList = strList + " " + current.data;
			current = current.next;
		}
		strList = strList + " " + current.data;
		return strList;
	}
	
	public static void main(String[] args){
		LinkedList list = new LinkedList();
		list.insert(1);
		list.insertAfter(1, 2);
		list.insertAfter(2, 3);
		list.insertAfter(3, 4);
		list.insertAfter(4, 5);
		list.insertAfter(5, 3);
		//System.out.println(list.toString());
		int i = 0;
		LinkedListNode<Integer> current = list.start;
		while (i < 10){
			System.out.println(current.data);
			current = current.next;
			i++;
		}
		
		LinkedListNode<Integer> node = BeginningOfLoop.FindBeginning(list);
		System.out.println("Collision Point is " + node.data);
	}

	@Override
	public Iterator<Integer> iterator() {
		
		return new linkedListIterator();
	}
	
	public class linkedListIterator implements Iterator<Integer>{
		LinkedListNode<Integer> current = start;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Integer next() {
			LinkedListNode<Integer> node = current;
			current = node.next;
			return node.data;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
