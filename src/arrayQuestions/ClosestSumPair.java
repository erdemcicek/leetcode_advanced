package arrayQuestions;

/*
	You are given two int arrays and a target integer.
	Write a program to find the closest pair to the target
			
	int[] a1 = {3, 4, 7, 11}; 
        int[] a2 = {6, 14, 9, 5}; 
        int target = 26;
        	
        Output : [11, 14]
 */

import java.util.Arrays;

public class ClosestSumPair {
	
	public static void main(String[] args) {
		
	int[] a1 = {3, 4, 7, 11};  
        int[] a2 = {6, 14, 9, 5}; 
        int aTarget = 26;
        System.out.println(Arrays.toString(closestSumPair(a1, a2, aTarget)));
		
	}
	
	private static int[] closestSumPair(int[] arr, int[] brr, int target) {
		
		Arrays.sort(arr);
		Arrays.sort(brr);
		
		int i = 0, j = brr.length-1;
		int smallestDiff = Math.abs(arr[0] + brr[0] - target);
		int[] closestPair = {arr[0], brr[0]};
		
		while( i < arr.length && j >= 0) {
			
			int v1 = arr[i];
			int v2 = brr[j];
			int currentDiff = v1 + v2 - target;
			
			if ( Math.abs(currentDiff) < smallestDiff) {
				smallestDiff = Math.abs(currentDiff);
				closestPair[0] = v1;
				closestPair[1] = v2;

			}
			if ( currentDiff == 0) return closestPair;
			else if ( currentDiff < 0 ) i++;
			else j--;
		}
	
		return closestPair;
	}
}
