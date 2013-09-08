package StackandQueue;

import java.util.Iterator;

public class Tower {
	public Stack<Integer> disks;
	public int index;
	public Tower(int index){
		disks = new Stack<>();
		this.index = index;
	}

	public boolean push(Integer data){
		if (!disks.isEmpty()&& disks.peek() < data){
			System.out.println("Larger disk must place under the smaller ones");
			return false;
		}
		disks.push(data);
		return true;
	}
	
	public Node<Integer> pop(){
		return disks.pop();
	}
	

	public boolean moveTo(Tower t){
		Integer disk = disks.pop().data;
		boolean result = t.push(disk); 
		System.out.println("Move disk " + disk + " from tower " + index + " to tower " + t.index);
		return result;
	}
	
	public void moveNTo(int n, Tower destination, Tower buffer){
		if (n > 0){
			moveNTo(n-1, buffer, destination);
			moveTo(destination);
			buffer.moveNTo(n-1, destination, this);
		}
	}
	
	public Iterator<Integer> iterator(){
		return disks.iterator();
	}
	public static void main(String[] args){
		int nTower = 3;
		int nDisks = 6;
		Tower[] towers = new Tower[nTower];
		for (int i = 0; i < nTower; i++){
			towers[i] = new Tower(i);
		}
		
		for (int i = nDisks - 1; i >= 0; i--){
			towers[0].push(i);
		}
		
		towers[0].moveNTo(nDisks, towers[2], towers[1]);
		Iterator<Integer> it = towers[2].iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
}