package other1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExchangeProblem {
	
	public static void main(String[] args) {
		
		List<Integer> list = List.of(3,2,1); // 10
		Map<Boolean, List<Integer>> hm = new HashMap<>();
		
		System.out.println(canExchange(5, list, hm));
		
	}

	private static boolean canExchange(int target, List<Integer> list, Map<Boolean, List<Integer>> hm) {
		
		List<Integer> bank = new ArrayList<>();
		
		if ( hm.containsKey(true)) System.out.println(hm);
		if ( target == 0 ) return true;
		if ( target < 0 ) return false;
		
		for ( int i = 0 ; i < list.size() ; i++) {
			int rest = target - list.get(i);
			if ( canExchange(rest, list, hm)) {
				bank.add(list.get(i));
				hm.put(true, bank);
				return true;
			}
		}
		
//		System.out.println(hm.containsKey(true));
//		System.out.println(hm.size());
		return false;
	}
}
