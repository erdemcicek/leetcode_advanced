package arrayQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 		Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

		You may assume that each input would have exactly one solution, and you may not use the same element twice.

		You can return the answer in any order.
 */

public class TwoSum {
	
	public static void main(String[] args) {
		
		// [2,7,11,15], target = 9 
		int[] nums = { 2,5, 55, 7,11,15 };  
		System.out.println(Arrays.toString(twoSum(nums, 9)));
		
	}
	
	private static int[] twoSum(int[] nums, int target) { 
		
		Map<Integer, Integer> hm = new HashMap<>();
		for ( int i = 0 ; i < nums.length ; i++) {
			int diff = target - nums[i];
			if ( hm.containsKey(diff)) {
				return new int[] { hm.get(diff), i};
			}
			hm.put(nums[i], i); // 2,0   ;  
		}
		
		throw new IllegalArgumentException("No solution found");
	}
}
