package arrayQuestions;

import java.util.Arrays;
import java.util.List;

/*
		 Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
		 Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. 
		 Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
		 
		 Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
		 Output: [2,2,2,1,4,3,3,9,6,7,19]
 */

public class RelativeSort {
	
	public static void main(String[] args) {
		
		int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
		int[] arr2 = {2,1,4,3,9,6};
//		System.out.println(Arrays.toString(relativeSort(arr1, arr2)));
		System.out.println(Arrays.toString(relativeS(arr1, arr2)));
	}
	
	private static int[] relativeS(int[] a, int[] b) {
		
		int ans[] = new int[a.length];
		int z = 0;
		int max = Arrays.stream(a).max().getAsInt();
		int[] count = new int[max+1];
		for(int i = 0 ; i < a.length ; i++) count[a[i]]++;
		for(int i = 0 ; i < b.length ; i++) {
			while(count[b[i]] != 0) {
				ans[z] = b[i];
				z++;
				count[b[i]] -= 1;
			}
		}
		if(z<ans.length) {
			for(int i = 0 ; i < count.length ; i++) {
				while(count[i] != 0) {
					ans[z] = i;
					z++;
					count[i] -= 1;
				}
			}
		}
		return ans;
	}
		
	private static int[] relativeSort(int[] arr1, int[] arr2) {
		
//		Arrays.stream(arr1).distinct().collect(t->t=t, List::add);
		int[] arr3 = new int[arr1.length];
		Arrays.sort(arr1);
		// arr1.sort  [1, 2, 2, 2, 3, 3, 4, 6, 7, 9, 19]
		// arr2       [2, 1, 4, 3, 9, 6]
		// Output     [2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19]
		int x = 0, y = arr1.length-1;
		boolean[] control = new boolean[arr1.length];
		for(int i = 0 ; i < arr2.length ; i++) {
			for ( int j = 0 ; j < arr1.length ; j++) {
				if( arr2[i] == arr1[j] ) {
					arr3[x] = arr2[i];
					control[j] = true;
					x++;
				}
			}
		}
		for(int k = y ; k >= 0 ; k--) {
			if ( !control[k] ) {
				arr3[y] = arr1[k];
				y--;
			}
		}
		
		
		return arr3;
	}
	
	


}
