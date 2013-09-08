package Bag;
import java.util.Iterator;

import LinkedList.LinkedListNode;

public class Bag<Item> implements Iterable<Item>{
	private int size;
	private LinkedListNode<Item> first = null;
	private LinkedListNode<Item> current = null;
	
	public Bag(){
		first = new LinkedListNode<>();
		current = first;
		size = 0;
	}
	
	public void add(Item data){
		LinkedListNode<Item> node = new LinkedListNode<>(data);
		current.next = node;
		current = node;
		size++;
	}
	
	public boolean contains(Item data){
		Iterator<Item> it = this.iterator();
		while (it.hasNext()){
			if (it.next() == data){
				return true;
			}
		}
		return false;
	}
	
	public boolean delete(Item data){
		LinkedListNode<Item> c = first;
		while (c.hasNext()){
			if (c.next.data == data){
				c.next = c.next.next;
				size--;
				return true;
			}
		}
		System.out.println("No item to delete");
		return true;
		
	}

	public int size(){
		return this.size;
	}

	@Override
	public Iterator<Item> iterator() {
		return new bagIterator();
	}
	
	public class bagIterator implements Iterator<Item>{
		private LinkedListNode<Item> cur = first.next;
		@Override
		public boolean hasNext() {

			return cur != null;
		}

		@Override
		public Item next() {
			Item d = cur.data;
			cur = cur.next;
			return d;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}
}
