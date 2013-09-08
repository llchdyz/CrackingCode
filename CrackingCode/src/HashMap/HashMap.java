package HashMap;

public class HashMap<Key extends Comparable<Key>, Value> {
	private int N;
	private Key[] keys;
	private Value[] values;
	
	@SuppressWarnings("unchecked")
	public HashMap(){
		// a prime
		N = 30001;
		keys = (Key[]) new Object[N];
		values = (Value[]) new Object[N];
	}
	
	@SuppressWarnings("unchecked")
	public HashMap(int N){
		this.N = N;
		keys = (Key[]) new Object[N];
		values = (Value[]) new Object[N];
	}
	
	public int hash(Key key){
		// -2^31 is 100000000000..
		return (key.hashCode() & 0x7fffffff) % N;
	}
	
	public void put(Key key, Value value){
		int loc;
		// check duplicate
		for (loc = hash(key); keys[loc] != null; loc++){
			if (key.equals(keys[loc])){
				values[loc] = value;
				break;
			}
		}
		keys[loc] = key;
		values[loc] = value; 
	}
	
	public Value get(Key key){
		int loc;
		for (loc = hash(key); keys[loc] != null; loc++){
			// key.equals()
			if (key.equals(keys[loc])){
				return values[loc];
			}
		}
		return null;
	}
}
