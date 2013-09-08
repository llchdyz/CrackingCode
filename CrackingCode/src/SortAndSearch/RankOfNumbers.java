package SortAndSearch;

public class RankOfNumbers{
	private static RankNode root;
	
	public static int getRoot(){
		return root.data();
	}
	public static int getRankOfNumbers(int num){
		if (root == null){
			return -1;
		}
		return root.getRank(num);
	}
	
	public static void track(int num){
		if (root == null){
			root = new RankNode(num);
		} else {
			root.insert(num);
		}
	}
	
	public static void main(String[] args){
		track(20);
		track(15);
		track(25);
		track(23);
		track(13);
		track(10);
		track(24);
		track(5);
		track(22);
		System.out.println(getRankOfNumbers(23));
	}
	

}
