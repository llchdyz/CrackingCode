package SortAndSearch;

import java.util.Iterator;
import java.util.Random;

import LinkedList.LinkedList;

public class Sort{
	
	public static void SelectSort(Comparable[] a){
		for (int i = 0; i < a.length; i++){
			int min = i;
			for (int j = i + 1; j < a.length; j++){
				if (less(a[j], a[min])){
					min = j;
				}
			}
			// put it here can reduce the times of swap
			swap(a, i, min);
		}
	}
	
	public static void InsertSort(Comparable[] a){
		for (int i = 0; i < a.length; i++){
			for (int j = i; j > 0; j--){
				if (less(a[j], a[j-1])){
					swap(a, j, j-1);
				} else {
					break;
				}
			}
		}
	}
	
	public static void BubbleSort(Comparable[] a){
		// i and j are stopped at a.length - 1
		for (int i = 0; i < a.length - 1; i++){
			for (int j = 0; j < a.length - 1 - i; j++){
				if (less(a[j+1], a[j])){
					swap(a, j, j+1);
				}
			}
		}
	}
	/**
	 * 
	 * @param a
	 * @param start included
	 * @param end not included
	 */
	public static void BucketSort(int[] a, int start, int end){
		int range = end - start + 1;
		int[] bucket = new int[range];
		for (int i = 0; i < range; i++){
			bucket[i] = 0;
		}
		
		for (int j = 0; j < a.length; j++){
			bucket[a[j] - start]++;
		}
		int index = 0;
		for (int i = start; i < end; i++){
			for (int j = 0; j < bucket[i-start]; j++){
				a[index++] = i;
			}
		}
	}
	
	public static void RadixSort(int[] a){
		int numBucket = 10;
		int maxDigit = checkMaxDigit(a);
		int divisor = 1;
		LinkedList[] bucket = new LinkedList[numBucket];
		for (int i = 0; i < bucket.length; i++){
			bucket[i] = new LinkedList();
		}
		
		for (int i = 0; i < maxDigit; i++){
			
			for (int j = 0; j < a.length; j++){
				int hashCode = (a[j] / divisor) % numBucket;
				bucket[hashCode].insert(a[j]);
			}
			int index = 0;
			
			for (int j = 0; j < bucket.length; j++){

				while (bucket[j].peek() != null){
					a[index] = bucket[j].removeFirst();
				
					if (index + 1 == a.length){
					break;
					}
					index++;
				}
			}
			divisor = divisor * 10;
		}
	}
	
	private static int checkMaxDigit(int[] a) {
		int[] count = new int[a.length];
		int divisor = 10;
		for (int i = 0; i < a.length; i++){
			int value = a[i];
			count[i] = 0;
			while (value > 0){
				value /= 10;
				count[i]++;
			}
		}
		
		int max = 0;
		for (int i = 0; i < count.length; i++){
			if (count[i] > max){
				max = count[i];
			}
		}
		return max;
	}

	public static void QuickSort(Comparable[] a){
		QuickSort(a, 0, a.length - 1);
	}
	
	public static void QuickSort(Comparable[] a, int left, int right){
		if (left >= right) return;
		int index = partition(a, left, right);
		if (left < index){
			QuickSort(a, left, index - 1);
		} 
		if (right > index + 1){
			QuickSort(a, index + 1, right);
		}
	}
	
	private static int partition(Comparable[] a, int left, int right){
		int i = left;
		int j = right + 1;
		while (true){
			
			while (less(a[++i], a[left])){
				//Generally, the current value in j is larger than 'left'
				// Stop point 1: no values on the right are larger than 'left', i will stop at j
				// then j will --j and find the next one is less than 'left', and it stops. 
				
				if (i == right) break;// extreme stop point, all smaller than left
			}
			
			while (less(a[left], a[--j])){
				//Generally, the current value in i is less than 'left'
				// Stop point 2: no values on the left are less than 'left', j will stop at i-1
				
				if (j == left) break;// extreme stop point, all larger than left
			}
			
			if (i >= j) break;
			swap(a, i, j);
		}
		swap(a, j, left);
		return j;
	}
	
	public static void MergeSort(Comparable[] a){
		MergeSort(a, 0, a.length-1);
	}
	
	public static void MergeSort(Comparable[] a, int low, int high){
		if (high <= low){
			return;
		}
		int mid = (low + high) / 2;
		MergeSort(a, low, mid);
		MergeSort(a, mid + 1, high);
		merge(a, low, mid, high);
	}
	
	private static void merge(Comparable[] a, int low, int mid, int high){
		Comparable[] aux = new Comparable[a.length];
		for (int i = low; i <= high; i++){
			aux[i] = a[i];
		}
		
		int leftLow = low;
		int rightLow = mid + 1;
		int leftHigh = mid;
		int rightHigh = high;
		int index = low;
		while (leftLow <= leftHigh && rightLow <= rightHigh){
			if (less(aux[leftLow], aux[rightLow])){
				a[index++] = aux[leftLow++];
			} else {
				a[index++] = aux[rightLow++];
			}
		}
		
		if (rightLow > rightHigh){
			while (leftLow <= leftHigh){
				a[index++] = aux[leftLow++];
			}
		} 
	}
	
	private static boolean less(Comparable a, Comparable b){
		return a.compareTo(b) < 0;
	}
	
	private static void swap(Comparable[] a, int i, int j){
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
	public static void main(String[] args){
		int N = 10;
		int range = 100;
		int[] a = new int[N];
		 Random g = new Random();
		for (int i = 0; i < N; i++){
			a[i] = g.nextInt(range);
			System.out.println(a[i]);
		}

		Sort.RadixSort(a);
		System.out.println("Sorted:");
		for (int k : a){
			System.out.println(k);
		}
	}
}
