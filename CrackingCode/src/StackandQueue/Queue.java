package StackandQueue;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	private Item[] queue = null;
	private int capacity;
	private int head;
	private int tail;
	
	@SuppressWarnings("unchecked")
	public Queue(){
		this.capacity = 10;
		this.head = 0;
		this.tail = 0;
		queue = (Item[])new Object[this.capacity];
	}
	
	@SuppressWarnings("unchecked")
	public Queue(int capacity){
		this.capacity = capacity;
		this.head = 0;
		this.tail = 0;
		queue = (Item[])new Object[capacity];
	}
	
	public int getSize(){
		return (this.tail + this.capacity - this.head) % this.capacity;
	}
	
	public int getCapacity(){
		return this.capacity - 1;
	}
	
	public boolean isEmpty(){
		return getSize() == 0;
	}
	
	public boolean isFull(){
		return getSize() == this.capacity - 1;
	}
	
	public Item peek(){
		if (isEmpty()){
			return null;
		}
		return queue[head % this.capacity];
	}
	
	public boolean enqueue(Item data){
		if (isFull()){
			expandSize();
		}

		queue[(this.tail++) % this.capacity] = data;

		return true;
	}
	
	public Item dequeue(){
		if (isEmpty()){
			return null;
		} else {
			Item data = queue[(this.head++) % this.capacity]; 
			if (getSize() < this.capacity * 1/4){
				reduceSize();
			}
			return data;
		}
		
	}
	private void reduceSize() {
		int capa = this.capacity * 1/2;
		@SuppressWarnings("unchecked")
		Item[] newQueue = (Item[]) new Object[capa];
		Iterator<Item> it = this.iterator();
		int index = 0;
		while (it.hasNext()){
			newQueue[index++] = it.next();
		}
		this.queue = newQueue;
		this.head = 0;
		this.tail = index;
		this.capacity = capa;
		
	}

	private void expandSize() {

		int capa = this.capacity * 2;
		@SuppressWarnings("unchecked")
		Item[] newQueue = (Item[]) new Object[capa];
		Iterator<Item> it = this.iterator();
		int index = 0;
		while (it.hasNext()){
			newQueue[index++] = it.next();
		}
		this.queue = newQueue;
		this.head = 0;
		this.tail = index;
		this.capacity = capa;
		
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new queueIterator();
	}
	
	public class queueIterator implements Iterator<Item>{
		private Item[] q = queue;
		private int h = head;
		private int t = tail;
		private int c = capacity;
		@Override
		public boolean hasNext() {
			
			return (t + c - h) % c != 0;
		}

		@Override
		public Item next() {
			
			return q[(h++) % c];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
		}
	}
	
	public static void main(String[] args){
		Queue<Integer> q = new Queue<>(4);
		q.enqueue(1);
		q.enqueue(4);
		q.enqueue(3);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(1);
		q.enqueue(4);
		q.enqueue(3);
		q.enqueue(5);
		q.enqueue(6);
		Iterator<Integer> it = q.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
			
		}
		
		System.out.println("c: " + (q.getCapacity() + 1));
		
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		Iterator<Integer> it2 = q.iterator();
		while (it2.hasNext()){
			System.out.println(it2.next());
			
		}
		
		System.out.println("C: " + (q.getCapacity() + 1));
	}
}
