package arrayQuestions;

import java.util.Arrays;

public class ComputeJoint {
	
	public static void main(String[] args) {
		
		//System.out.println(comp(471, 480));
		int[] nums = {15, 26, 1, 5, 8, 8};
		System.out.println(minInterval(nums));
	}
	
	private static int comp(int a, int b) {
		
		int x = sum(a);
		int y = sum(b);
		int z = 0;
		
		
		while( x != y) {
			x = sum(x);
			y = sum(y);
			if(x==y) break;
			z = sum(x);
		}
		
		return z;
	}
	private static int sum(int a) {
		
		int total = a;
		
		while(a != 0) {
			total += a%10;
			a /= 10;
		}
		
		return total;
	}
	
	
	private static int minInterval(int[] nums) {
		
		Arrays.sort(nums);
		int i = 0, diff, comp = Integer.MAX_VALUE;
		// 1, 5, 8, 15, 26
		// 1, 5, 8, 15, 26

		while(i < nums.length-1) {
			diff = nums[i+1] - nums[i];
			if(diff == 0) return diff;
			else if(diff < comp ) {
				comp = diff;
			}
			i++;
		}
		
		return comp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
