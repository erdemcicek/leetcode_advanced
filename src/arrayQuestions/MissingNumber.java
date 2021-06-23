package arrayQuestions;

import java.util.Arrays;

public class MissingNumber {
	
	public static void main(String[] args) {
		
		int[] arr = {0, 1, 3};
		int[] brr = {9,6,4,2,3,5,7,0,1};
		System.out.println(missingNum(brr));
		System.out.println(missingNum2(brr));
	}
	private static int missingNum(int[] nums) {
		
		boolean found = true;
		Arrays.sort(nums); // 0, 1, 3
		int x = 0;
		for ( int i = 0 ; i < nums.length ; i++) {
			if ( nums[i] != x) found = false;
			x++;
			if (!found) return nums[i]-1;
		}
		if (found) return nums.length;
		return 0;	
	}
	private static int missingNum2(int[] nums) {
		int len = nums.length;
		int sum = (len*(len+1))/2;
		for ( int i = 0 ; i < len ; i++) {
			sum -= nums[i];
		}
		return sum;
	}
}
