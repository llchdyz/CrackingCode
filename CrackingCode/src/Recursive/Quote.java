package Recursive;

import java.util.ArrayList;
import java.util.Iterator;

public class Quote {

	
	public static void main(String[] args){
		int nQuote = 4;
		char[] str = new char[nQuote * 2];
		ArrayList<String> list = new ArrayList<>();
		addParan(list, nQuote, nQuote, str, 0);
		Iterator<String> it = list.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
	}

	private static void addParan(ArrayList<String> list, int left,
			int right, char[] str, int count) {
		if (left < 0 || left > right){
			return;
		} 
		
		if (left == 0 && right == 0){
			list.add(String.copyValueOf(str));
		} else {
			if (left > 0){
				str[count] = '(';
				addParan(list, left - 1, right, str, count + 1);         
			}
			
			if (right > 0){
				str[count] = ')';
				addParan(list, left, right - 1, str, count + 1);
			}
		}
	}
}
