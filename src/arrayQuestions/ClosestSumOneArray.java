package arrayQuestions;

import java.util.Arrays;

/*
 	Given an int array nums and an int target. Find two integers in nums such that the sum is closest to target.
			Example 1:		
			Input: nums = [1, 2, 3, 4, 5], target = 1
			Output: [4, 5]
			Example 2:
			Input: nums= [-1, 2, 1, -4], target = 4
			Output: [2, 1]
 */

public class ClosestSumOneArray {
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		/*
		  12-13-14-15
		  23-24-25
		  34-35
		  45
		 */
		System.out.println(Arrays.toString(closestPair(arr, 11)));
		
	}
	/*
	         	1 2 3 4 5  t=10
	        1   - - - - -
	        2   - - - - -
	        3   - - - - -
	        4   - - - - -
	        5   - - - - -
	 */
	public static int[] closestPair(int[] nums, int target) {
		
		Arrays.sort(nums);
		
		int i = 0, j = nums.length-1;
		int smallestDiff = Math.abs(nums[0] + nums[1] - target);
		int[] closestPair = { nums[0] , nums[1] };
		
		while( i < nums.length && j >= 0 ) {
			
			int currentDiff = nums[i] + nums[j] - target; // - + 0 
			
			if ( Math.abs(currentDiff) < smallestDiff && i!=j ) {
				smallestDiff = Math.abs(currentDiff);
				closestPair[0] = nums[i];
				closestPair[1] = nums[j];
			}
			
			if ( currentDiff == 0) return closestPair;
			else if ( currentDiff < 0) i++;
			else j--;
			
		}
		return closestPair;
	}
}
