package stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
	The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
	You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
	For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] 
	and determine the next greater element of nums2[j] in nums2. If there is no next greater element, 
	then the answer for this query is -1.
	Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
	
	Constraints:

	1 <= nums1.length <= nums2.length <= 1000
	0 <= nums1[i], nums2[i] <= 104
	All integers in nums1 and nums2 are unique.
	All the integers of nums1 also appear in nums2.
	
*/
public class NextGreater {
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(nextGreaterElement(new int[] {1, 3}, new int[] {1, 3, 2})));
		
	}
	
	private static int[] nextGreaterElement(int[] query, int[] input) {
		
        int n = input.length;
        
        Map<Integer,Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        
        nextGreater.put(input[n-1],-1); // 2, -1
        stack.push(input[n-1]);			// 2
        
        for(int i=n-2;i>=0;i--) {
            while(stack.size()>0 && stack.peek() < input[i]) { // 2 < 3
                stack.pop();
            }
            nextGreater.put(input[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(input[i]);
        }
        
        int[] result =  new int[query.length];
        
        for(int i = 0; i < query.length; i++) {
            result[i] = nextGreater.get(query[i]);
        }
        
        return result;
    }

}
