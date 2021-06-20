package javabook;

import java.util.Arrays;


public class MountainArray {
	public static void main(String[] args) {
        
		int[] arr = {0, 2, 5};
		int[] brr = {5, 2, 7, 1, 4};
		System.out.println(isMountain(arr));
		System.out.println("------------");
		System.out.println(isMountain(brr));
		
		
    }
	private static boolean isMountain(int[] arr) {
		
		int max = Arrays.stream(arr).max().getAsInt(), ind = 0;
	
		for (int i = 0 ; arr[i] != max ; i++) {
			ind++;
			if ( arr[i+1] - arr[i] <= 0 ) return false;
		}
		
		for (int j = ind+1  ; j < arr.length ; j++) {
			if ( arr[j] - arr[j-1] >= 0 ) return false;
		}
		return true;
	}
	
}

