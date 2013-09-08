package SortAndSearch;

public class RankNode{
	private int rank = 0;// number of left size
	private RankNode left, right;
	private int data = 0;
	
	public RankNode(int num){
		this.data = num;
	}
	
	public void setRank(int r){
		this.rank = r;
	}
	
	public int data(){
		return this.data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public void insert(int data){
		if (data <= this.data){
			if (this.left != null){
				left.insert(data);
			} else {
				left = new RankNode(data);
			}
			rank++;
		} else {
			if (this.right != null) {
				right.insert(data);
				
			} else {
				right = new RankNode(data);
			}
		}
	}
	
	public int getRank(int data){
		if (this.data == data){
			return this.rank;
		} else if (this.data < data){
			int rightRank = right == null ? -1 : right.getRank(data);
			if (rightRank == -1){
				return -1;
			} else {
				return rank + 1 + rightRank;
			}

		} else {
			if (left == null){
				return -1;
			} else {
				return left.getRank(data);
			}
		}
	}
}
