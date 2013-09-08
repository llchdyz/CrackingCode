package SortAndSearch;

public class HtWt implements Comparable<HtWt>{
	private int Ht;
	private int Wt;
	
	public HtWt(int Ht, int Wt){
		this.Ht = Ht;
		this.Wt = Wt;
	}
	
	public void put(int Ht, int Wt){
		this.Ht = Ht;
		this.Wt = Wt;
	}
	
	public int Ht(){
		return this.Ht;
	}
	
	public int Wt(){
		return this.Wt;
	}
	
	public boolean isBefore(HtWt p){
		if (this.Ht < p.Ht && this.Wt < p.Wt){
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(HtWt p) {
		if (this.Ht > p.Ht){
			return 1;
		} else if (this.Ht < p.Ht){
			return -1;
		} else {
			if (this.Wt > p.Wt){
				return 1;
			} else if (this.Wt < p.Wt){
				return -1;
			} else {
				return 0;
			}
		}
	}
}
