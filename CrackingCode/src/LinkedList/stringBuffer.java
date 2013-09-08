package LinkedList;

public class stringBuffer {
	private char[] buffer;
	private int capacity;
	private int length;
	
	
	public stringBuffer(){
		this(16);
	}
	
	public stringBuffer(int capacity){
		this.capacity = capacity;
		buffer = new char[this.capacity];
		this.length = 0;
	}
	
	
	public void append(String str){
		System.out.println("now string is " + str);
		if (str == null) {
			str = "null";
		}
		
		int addLength = str.length();
		int newLength = this.length + addLength;
		// check null, if it is null, append a "null" as a sign
		// check total length
		if (newLength > this.capacity){
			resize(newLength);
		} 
		
		// update buffer
		for (int i = 0; i < addLength; i++){
			//System.out.println(str.charAt(i));
			this.buffer[this.length + i] = str.charAt(i);
			
		}
		
		// update length
		this.length = newLength;
		//System.out.println(this.length);
		//System.out.println(toString());
			 
	}
	
	public int length(){
		return this.length;
	}
	
	public int capacity(){
		return this.capacity;
	}
	
	public String toString(){
		return new String(buffer, 0, this.length);
	}
	
	private void resize(int newLength) {
		System.out.println("Resizing...");
		// select a new capacity
		int newCapacity = Math.max(this.capacity * 2, newLength);
		// create a new buffer
		char[] newBuffer = new char[newCapacity];
		// move current string to the new buffer
		for (int i = 0; i < this.length; i++){
			newBuffer[i] = this.buffer[i];
		}
		// update buffer and capacity
		this.buffer = newBuffer;
		this.capacity = newCapacity;
	}
	
	public static void main(String[] args){
		stringBuffer buffer = new stringBuffer();
		String sentence = "This is a structure!";
		String[] arrSentence = sentence.split(" ");
		for (String word : arrSentence){
			buffer.append(word);
		}
		
		System.out.println("Output: " + buffer.toString() 
				+ ";Length: " + buffer.length() 
				+ ";Capacity: " + buffer.capacity());
	}
}
