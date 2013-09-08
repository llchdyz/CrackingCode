package HashMap;

public class HashMapSC<Key extends Comparable<Key>, Value> {
	// in class
	private static class Node{
		private Object key;
		private Object value;
		private Node next;
		
		private Node(Object key, Object value, Node next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	private int N;
	private Node[] nodes;
	
	public HashMapSC(){
		N = 97;
		nodes = (Node[]) new Object[N]; 
	}
	
	public void put(Key key, Value value){
		int loc = hash(key);
		for (Node node = nodes[loc]; node != null; node = node.next){
			if (node.key.equals(key)){
				node.value = value;
				return;
			}
		}
		// insert to the first
		nodes[loc] = new Node(key, value, nodes[loc]);
	}
	
	public Value get(Key key){
		int loc = hash(key);
		for (Node node = nodes[loc]; node != null; node = node.next){
			if (node.key.equals(key)){
				// cast to Value
				return (Value) node.value;
			}
		}
		return null;
	}
	
	public int hash(Key key){
		return (key.hashCode() & 0x7fffffff) % N;
	}
}
