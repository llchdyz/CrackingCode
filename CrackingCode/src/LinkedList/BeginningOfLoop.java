package LinkedList;

public class BeginningOfLoop {
	public static LinkedListNode<Integer> FindBeginning(LinkedList list){
		LinkedListNode<Integer> fastRunner = list.start;
		LinkedListNode<Integer> slowRunner = list.start;
		
		while (true){
			if (fastRunner.hasNext() && fastRunner.next.hasNext()){
				fastRunner = fastRunner.next.next;
				slowRunner = slowRunner.next;
			} else {
				System.out.println("No Loop Exists!");
				return null;
			}
				
			if (fastRunner == slowRunner){
				System.out.println("Find the collision at: " + fastRunner.data);
				break;
			}	
		}
		
		slowRunner = list.start;
		
		while (true){
			if (slowRunner == fastRunner){
				return slowRunner;
			} else{
				slowRunner = slowRunner.next;
				fastRunner = fastRunner.next;
			}
		}
	}
}
