package SortAndSearch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class PeopleTower {
	public static ArrayList<HtWt> findLongestSequence(HtWt[] array){
		// sort array with Ht
		Sort.QuickSort(array);
		// find every longest sequence ending in each item
		ArrayList<ArrayList<HtWt>> eachLongest = new ArrayList<>();
		for (int i = 0; i < array.length; i++){
			findLongest(array, eachLongest, i);
		}
		// find the longest sequence
		ArrayList<HtWt> result = null;
		for (int i = 0; i < array.length; i++){
			result = compareSequence(result, eachLongest.get(i));
		}
		// return 
		return result;
	}
	
	private static ArrayList<HtWt> compareSequence(ArrayList<HtWt> a, ArrayList<HtWt> b){
		if (a == null) return b;
		if (b == null) return a;
		return a.size() > b.size() ? a : b;
	}
	
	private static void findLongest(HtWt[] array,
			ArrayList<ArrayList<HtWt>> eachLongest, int cur) {
		// find longest possible sequence for current item
		HtWt current = array[cur];
		ArrayList<HtWt> longest = null;
		for (int i = 0; i < eachLongest.size(); i++){
			ArrayList<HtWt> one = eachLongest.get(i);
			if (one.get(one.size()-1).isBefore(current)){
				longest = compareSequence(longest, one);
			}
		}
		
		ArrayList<HtWt> curLongest = new ArrayList<HtWt>();
		if (longest != null){
			curLongest.addAll(longest);
		}

		curLongest.add(current);
		eachLongest.add(curLongest);
		
	}

	public static void main(String[] args){
		int N = 20;
		HtWt[] array = new HtWt[N];
		Random r = new Random();
		for (int i = 0; i < N; i++){
			HtWt item = new HtWt(r.nextInt(120) + 60, r.nextInt(40) + 40);
			array[i] = item;
			System.out.println(array[i].Ht() + " " + array[i].Wt());
		}

		ArrayList<HtWt> result = findLongestSequence(array);
		System.out.println("Result");
		Iterator<HtWt> it = result.iterator();
		while (it.hasNext()){
			HtWt current = it.next();
			System.out.println(current.Ht() + " " + current.Wt());
		}

	}
}
