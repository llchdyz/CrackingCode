package Math;

import java.util.ArrayList;
import java.util.Iterator;

import StackandQueue.Queue;

public class PrimeFactor {
	public static ArrayList<Integer> findKthNum(int k){
		int a = 3, b = 5, c = 7;
		ArrayList<Integer> result = new ArrayList<>();
		Queue<Integer> aQ = new Queue<>();
		Queue<Integer> bQ = new Queue<>();
		Queue<Integer> cQ = new Queue<>();
		aQ.enqueue(a);
		bQ.enqueue(b);
		cQ.enqueue(c);
		while (result.size() != k){
			int minA = aQ.getSize() != 0 ? aQ.peek() : Integer.MAX_VALUE;
			int minB = bQ.getSize() != 0 ? bQ.peek() : Integer.MAX_VALUE;
			int minC = cQ.getSize() != 0 ? cQ.peek() : Integer.MAX_VALUE;
			
			int minValue = Math.min(minA, Math.min(minB,minC));
			
			if (minValue == minA){
				// aQ has the minimal
				minValue = aQ.dequeue();
				result.add(minValue);
				aQ.enqueue(minValue * a);
				bQ.enqueue(minValue * b);
			} else if (minValue == minB){
				// bQ is the minimal
				minValue = bQ.dequeue();
				result.add(minValue);
				bQ.enqueue(minValue * b);
			} else {
				// cQ is the minimal
				minValue = cQ.dequeue();
				result.add(minValue);
			}

			cQ.enqueue(minValue * c);
		}
		return result;
	}
	
	public static void main(String[] args){
		ArrayList<Integer> r = PrimeFactor.findKthNum(50);
		Iterator<Integer> it = r.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
	}
	
}
