package StackandQueue;

import java.util.Iterator;

public class SortStack{
	public Stack<Integer> stack;
	private Stack<Integer> buffer;
	private Integer val;
	
	public SortStack(){
		stack = new Stack<Integer>();
		buffer = new Stack<Integer>();
	}
	
	public boolean sort(){
		while (!stack.isEmpty()){
			val = stack.pop().data;
			while (!buffer.isEmpty() && val < buffer.peek()){
				stack.push(buffer.pop().data);
			}
			buffer.push(val);
		}
		
		while (!buffer.isEmpty()){
			stack.push(buffer.pop().data);
		}
		return true;
	}
	
	public static void main(String[] args){
		SortStack ss = new SortStack();
		ss.stack.push(1);
		ss.stack.push(5);
		ss.stack.push(4);
		ss.stack.push(9);
		ss.stack.push(6);
		ss.stack.push(3);
		ss.stack.push(3);
		ss.sort();
		Iterator<Integer> it = ss.stack.iterator();
		while(it.hasNext()){
		System.out.println(it.next());
	
		}
	}
}
