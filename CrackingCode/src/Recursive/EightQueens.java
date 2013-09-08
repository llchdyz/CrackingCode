package Recursive;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class EightQueens {
	private final static int MAX_ROW = 8;
	public static void placeQueen(int row, Integer[] column, ArrayList<Integer[]> result){
		if (row == MAX_ROW){
			result.add(column.clone());
		} else {
			for (int i = 0; i < MAX_ROW; i++){
				if (isValid(row, column, i)){
					column[row] = i;
					placeQueen(row + 1, column, result);
				}
			}
		}
	}
	
	private static boolean isValid(int row, Integer[] column, int newCol) {
		for (int i = 0; i < row; i++){
			int oldCol = column[i];
			if (oldCol == newCol){
				return false;
			}
		
			int colDistance = Math.abs(oldCol - newCol);
			int rowDistance = row - i;
			
			if (colDistance == rowDistance){
				return false;
			}
		
		}
		return true;
	}
	
	public static void main(String[] args){
		ArrayList<Integer[]> result = new ArrayList<>();
		Integer[] column = new Integer[8];
		placeQueen(0, column, result);
		Iterator<Integer[]> it = result.iterator();
		while (it.hasNext()){
			System.out.println(Arrays.toString(it.next()));
		}
	}
}
