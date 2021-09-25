package stringManipulation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanConstructString {
	
	// With the given array, write a program that returns if the target String can be built or not.
	// Each element of the array can be used multiple times
	
	public static void main(String[] args) {
		
		Map<String, Boolean> hm = new HashMap<>();
		List<String> list = List.of("e","ee","eee","eeee");
		
		System.out.println(canConstruct("eeeeeeeeeeeeeeeeef", list, hm));
	}
	private static boolean canConstruct(String target, List<String> bank, Map<String, Boolean> hm ) {
		
		if ( hm.containsKey(target)) return hm.get(target);
		if ( target.equals("")) return true;
		
		for ( int i = 0 ; i < bank.size() ; i++) {
			if ( target.indexOf(bank.get(i)) == 0) {
				String suffix = target.substring(bank.get(i).length());
				if ( canConstruct(suffix, bank, hm)) {
					hm.putIfAbsent(target, true);
					return true;
				}
			}
		}
		hm.putIfAbsent(target, false);
		return false;
	}
}
