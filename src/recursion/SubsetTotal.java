package recursion;

import java.util.HashMap;
import java.util.Map;

public class SubsetTotal {
	
	public static void main(String[] args) {
		int[] arr = { 2, 4, 6, 5, 10, 2, 4};
		System.out.println(countSets(arr, 16));
	}
	private static int countSets(int[] arr, int total) {
		Map<String, Integer> hm = new HashMap<>();
		return rec(arr, total, arr.length-1, hm);
	}
	
	private static int rec(int[] arr, int total, int i, Map<String, Integer> hm) {
		
		String key = total + ":" + i;
		int to_return;
		
		if (hm.containsKey(key)) return hm.get(key);
		
		if (total == 0) return 1;
		
		else if ( total < 0 || i < 0) return 0;
		
		else if ( total < arr[i]) to_return = rec(arr, total, i-1, hm);
		
		else to_return = rec(arr, total - arr[i], i-1, hm) + rec(arr, total, i-1, hm);
		//   take current ind, and search subtotal   do not take current ind, search total
		// total > 0 , total > arr[i] , 
		hm.put(key, to_return);
		return to_return;
	}
}
