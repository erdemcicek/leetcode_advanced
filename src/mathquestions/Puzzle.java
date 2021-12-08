package mathquestions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Puzzle {
	
	public static void main(String[] args) {
		findPuzzle(7);
//		System.out.println(Arrays.toString(shiftArray(new int[] {1, 7, 13, 19, 25}, 5))); // 0==2, 1==3, 2==4
//		dequeImpl(new Integer[] {1, 7, 13, 19, 25}, 2); // 0==2, 1==3, 2==4

	}
	
	private static void findPuzzle(int n) {
		
		Integer[][] a = new Integer[n][n];
		int p = n, s, y = 0;
		for(int i = 0 ; i < n ; i++) {
			s = i+1;
			for(int j = 0 ; j < p ; j++ ) {
				a[i][j] = s;
				s = s + n + 1;
				y = j;
			}
			p--;
			for(int k = y+1 ; k < n; k++) {
				a[i][k] = s - n;
				s = s + n + 1;
			}
		}
		System.out.println(Arrays.toString(a[0]));
		for(int i = 1 ; i < a.length ; i++) {
			a[i] = dequeImpl(a[i], i);
			System.out.println(Arrays.toString(a[i]));
		}
	}
	
	private static Integer[] dequeImpl(Integer[] arr, int m) {
		
		Deque<Integer> d = new ArrayDeque<>(Arrays.asList(arr));
		for(int i = 0 ; i < m ; i++) {
			Integer x = d.poll();
			d.add(x);
		}
		
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = d.poll();
		}
		return arr;
		
	}
	
//	private static int[] swapArrayPartially(int[] arr, int marge) { 
//		
//		int[] brr = new int[arr.length];
//		
//		List<Integer> first = new ArrayList<>();
//		for(int i = marge ; i < arr.length ; i++) first.add(arr[i]);
//		
//		List<Integer> last = new ArrayList<>();
//		for(int i = 0 ; i < marge ; i++) last.add(arr[i]);
//		
//		first.addAll(last);
//		
//		for(int i = 0 ; i < brr.length ; i++) brr[i] = first.get(i);
//		
//		return brr;
//	}
	

}
