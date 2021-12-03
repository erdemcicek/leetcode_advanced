package other2;

import java.util.Arrays;

public class PrintArray {
	
	public static void main(String[] args) {
		printArray(new int[] {4, 2, 6, 5});
//		printArray(new int[] {0});

	}
	
	private static void printArray(int[] arr) {        // 4, 2, 6, 5
		
		if(arr == null || arr.length == 0) {
			System.out.println("Please provide a valid input");
			return;
		}
		boolean containsNegative = Arrays.stream(arr).anyMatch(t->t<0);
		if(containsNegative) {
			System.out.println("Please do not enter negative numbers");
			return;
		}
		
		int max = Arrays.stream(arr).max().getAsInt(); // 6	
		int max_in = max; // because max is modified in for loop, I stored it in a separate variable
		for(int i = 0; i < max_in ; i++) {
			for(int j = 0 ; j < arr.length ; j++) {	    
				if( arr[j] < max) System.out.print("   ");
				else System.out.print("*  ");
			}
			System.out.println();
			max--;
		}
		for(int k = 0 ; k < arr.length ; k++) System.out.print("---");
		System.out.println();
		for(int w : arr) System.out.print(w + "  ");
	}
}
