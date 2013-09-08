package LinkedList;

public class LinkedListNode<Item> {
	public Item data;
	public LinkedListNode<Item> next = null;
	
	public LinkedListNode(Item data){
		this.data = data;			
	}
	
	public LinkedListNode(){
		this.next = null;
	}
	
	public boolean hasNext(){
		return this.next != null;
	}
	
	public boolean addToTail(LinkedListNode<Item> head, Item data){
		LinkedListNode<Item> end = new LinkedListNode<Item>(data);
		while (head.next != null){
			head = head.next;
		}
		head.next = end;
		return true;
	}
	
	public LinkedListNode<Item> deleteNode(LinkedListNode<Item> head, Item data){
		LinkedListNode<Item> current = head;
		if  (head.data.equals(data)){
			return  head.next;
		}
		
		while (current.next != null){
			if (current.next.data.equals(data)){
				current.next = current.next.next;
				return head;
			}
			current = current.next;
		}
		return head;
	}
}
