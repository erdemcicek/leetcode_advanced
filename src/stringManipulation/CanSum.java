package stringManipulation;

import java.util.HashMap;
import java.util.Map;

public class CanSum {
	
	public static void main(String[] args) {
		
		Map<Integer, Boolean> hm = new HashMap<>();
		int[] arr = {25, 5, 12};
		System.out.println(canSum(100, arr, hm));
		
	}
	public static boolean canSum(int targetSum, int[] numbers, Map<Integer, Boolean> hm ) {
		
		if ( hm.containsKey(targetSum)) return hm.get(targetSum);
		if ( targetSum == 0 ) return true;
		if ( targetSum < 0) return false;
		
		for ( int i = 0 ; i < numbers.length ; i++) {
			int remainder = targetSum - numbers[i];
			if ( canSum(remainder, numbers, hm)) {
				hm.putIfAbsent(targetSum, true);
				return true;
			}
		}
		hm.putIfAbsent(targetSum, false);
		return false;
	}
}
