package stringManipulation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountConstruct {
	
	public static void main(String[] args) {
		
		List<String> list = List.of("e","r","er","dem"); 
		
		Map<String, Long> hm = new HashMap<>();
		
		System.out.println(countConstruct("erdem", list, hm));

	}
	
	private static long countConstruct(String target, List<String> bank, Map<String, Long> hm) {

		if ( hm.containsKey(target)) return hm.get(target); 
		if ( target.equals("")) return 1;
		long totalCount = 0;

		for ( int i = 0 ; i < bank.size() ; i++) {
			if ( target.indexOf(bank.get(i)) == 0) {
				long numWaysForRest = countConstruct(target.substring(bank.get(i).length()), bank, hm);
				totalCount += numWaysForRest;														   
			}																						   				
		}
		
		hm.putIfAbsent(target, totalCount);
		return totalCount;
		
	}
}
