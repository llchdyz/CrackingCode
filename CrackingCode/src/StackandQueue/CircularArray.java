package StackandQueue;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T>{
	private T[] items;
	private int head = 0;
	@SuppressWarnings("unchecked")
	public CircularArray(int length){
		items =(T[]) new Object[length];
	}
	
	public void rotate(int offset){
		head = adjust(offset);
	}
	
	public int adjust(int offset){
		while (offset < -1 * items.length){
			offset = offset + items.length;
		}
		return (head + items.length + offset) % items.length;
	}
	
	public void set(int i, T item){
		items[adjust(i)] = item;
	}
	
	public T get(int i){
		if (i > items.length || i < 0){
			System.out.println("Must between 0 and " + items.length);
			return null;
		}
		return items[adjust(i)];
	}
	
	public Iterator<T> iterator(){
		return new CircularArrayIterator();
		
	}
	
	public class CircularArrayIterator implements Iterator<T>{
		private int current = 0;
		
		@Override
		public boolean hasNext() {
			return current < items.length;
		}

		@Override
		public T next() {
			T item =(T) items[adjust(current++)];
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
		}
	}
	
	public static void main(String[] args){
		CircularArray<Integer> ca = new CircularArray<>(10);
		for (int i = 0; i < 10; i++){
			ca.set(i, i);
		}
		ca.rotate(1);
		Iterator<Integer> it = ca.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
    }
}
