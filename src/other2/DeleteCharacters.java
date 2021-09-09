package other2;

		//ccaaffddecee --> 6 all 'e' all 'f' one 'd' ==> ccaadc
		// c --> 3
		// a --> 2
		// f --> 2 ==> all
		// d --> 2 ==> 1
		// e --> 3 ==> all

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DeleteCharacters {
	
	public static void main(String[] args) {
		
		System.out.println(deleteChar("ccaaffddecee")); // 6
		System.out.println(deleteChar("example"));      // 4
		System.out.println(deleteChar("eeee"));         // 0
		System.out.println(deleteChar("aaaabbbb"));     // 1
		System.out.println(deleteChar(""));				// 0
		System.out.println(deleteChar(null));			// 0
	}
	
	private static int deleteChar(String s) {
		
		if( s == null || s.length() == 0) return 0;
		
		Map<String, Integer> map = new HashMap<>();
		for(String w: s.split("")) {
			map.put(w, Collections.frequency(Arrays.asList(s.split("")), w));
		}
		
		if(map.size() == 1) return 0;	
		
		for(String w: map.keySet()) { // a, c, d, e, f
			while (Collections.frequency(map.values(), map.get(w)) > 1 ){ // 1, 3, 2, 3, 2
				map.put(w, map.get(w)-1);
				if(map.get(w) == 0) break;
			}
		}
		
//		return s.length() - map.values().stream().reduce(0, (x,y)->x+y) ;             // with reduce()
		return s.length() - map.values().stream().mapToInt(Integer::intValue).sum();  // with sum()

	}
}
