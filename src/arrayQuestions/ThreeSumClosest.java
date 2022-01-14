package arrayQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/*
 	Given an integer array nums of length n and an integer target, 
 	find three integers in nums such that the sum is closest to target.
	Return the sum of the three integers.
	You may assume that each input would have exactly one solution.
	
	Example 1:
	Input: nums = [-1,2,1,-4], target = 1   -4, -1, 1, 2
	Output: 2
	
	Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	Example 2:
	
	Input: nums = [0,0,0], target = 1
	Output: 0
	
	Constraints
	3 <= nums.length <= 1000
	-1000 <= nums[i] <= 1000
	-104 <= target <= 104
	 */

public class ThreeSumClosest {
	
	// -7, 1, 2
	// -8
	public static void main(String[] args) {
		
		System.out.println(threeSumClosest(new int[] {1,2,0}, 3)); // -7, -3, 0, 1, 2
		System.out.println(threeSumClosest2(new int[] {1,2,0}, 3)); // -7, -3, 0, 1, 2

	}
	
	private static int threeSumClosest2(int[] nums, int target) {
		
        int res = 0;
        int diff = Integer.MAX_VALUE;    
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > target){
                    k--;
                    if(sum-target < diff){
                        res = sum;
                        diff = sum - target;
                    }
                    
                }else{
                	j++;
                    if(target-sum < diff){
                        res = sum;
                        diff = target - sum;
                    }
                }
            }
        }
                
	  return res;
	}
	
	private static int findClosest(int[] nums, int target) {
		
		Arrays.sort(nums);
		int c;
		
		if (Arrays.stream(nums).anyMatch(t->t==target)) return target;
		else if(target > Arrays.stream(nums).max().getAsInt()) c = nums[nums.length-1];
		else if (target < Arrays.stream(nums).min().getAsInt()) c = nums[0];
		else c = Arrays.stream(nums).map(t->Math.abs(t-target)).min().getAsInt();
		return c;
	}
	
	private static int threeSumClosest(int[] nums, int target) {
		
		int closest = findClosest(nums, target);
		List<Integer> list = new ArrayList<>();
		Arrays.stream(nums).forEach(t->list.add(t));
		int ind = list.indexOf(Integer.valueOf(closest));
		list.remove(ind);
		int subTotal = closestPair(list, 0);
		
		return subTotal + closest;
	}
	
	private static int closestPair(List<Integer> list, int target) {
		
		Collections.sort(list);
		int i = 0, j = list.size()-1;
		int smallestDiff = Math.abs(list.get(0) + list.get(1) - target);
		int x = 0, y = 0;
		
		while( i < list.size() && j >= 0 ) {
			
			int currentDiff = list.get(i) + list.get(j) - target; // - + 0 
			
			if ( Math.abs(currentDiff) < smallestDiff && i!=j ) {
				smallestDiff = Math.abs(currentDiff);
				x = list.get(i);
				y = list.get(j);
			}
			
			if ( currentDiff == 0) return x + y;
			else if ( currentDiff < 0) i++;
			else j--;
			
		}
		
		return x + y;
	}
}
