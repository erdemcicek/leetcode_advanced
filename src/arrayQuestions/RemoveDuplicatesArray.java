package arrayQuestions;

// 	Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
//	Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 
public class RemoveDuplicatesArray {
	
	public static void main(String[] args) {
		
		int[] arr = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeDup(arr));
	}
	private static int removeDup(int[] nums) {
		
		if (nums.length==0) return 0;
		int n = nums[0] - 1;
		int x = 0;
		
		for (int i = 0 ; i < nums.length-1 ; i++) {
			if ( nums[i] == nums[i+1]) {
				nums[i] = n;
			}
		}
		for ( int i = 0 ; i < nums.length ; i++) {
			if ( nums[i] != n) {
				nums[x] = nums[i];
				x++;
			}
		}
		return x;
	}
}
