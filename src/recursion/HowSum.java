package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {
	
	public static void main(String[] args) {
		
		List<Integer> arr = List.of(50,30,10);
		List<Integer> list = new ArrayList<>();
		list.addAll(arr);
	
		Map<Integer, ArrayList<Integer>> hm = new HashMap<>();
		System.out.println(howSum(90, list, hm));
	}
	
	private static ArrayList<Integer>howSum(int targetSum, List<Integer> list, Map<Integer, ArrayList<Integer>> hm) {
		
		ArrayList<Integer> emp = new ArrayList<>();
		if ( hm.containsKey(targetSum)) return hm.get(targetSum);
		if ( targetSum == 0) return emp;
		if ( targetSum < 0) return null;
		
		for ( int i = 0 ; i < list.size() ; i++) {
			int remainder = targetSum - list.get(i);
			ArrayList<Integer> remainderResult = howSum(remainder, list, hm);
			if ( remainderResult != null) {
				remainderResult.add(list.get(i));
				hm.putIfAbsent(targetSum, remainderResult);
				return hm.get(targetSum);
			}
		}
		hm.putIfAbsent(targetSum, null);
		return null;
	}
}
