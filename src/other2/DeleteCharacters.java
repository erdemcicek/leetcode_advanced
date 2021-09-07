package other2;

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
	}
	
	private static int deleteChar(String s) {
		
		// ccaaffddecee --> 6 all 'e' all 'f' one 'd' ==> ccaadc
		// c --> 3
		// a --> 2
		// f --> 2 ==> all
		// d --> 2 ==> 1
		// e --> 3 ==> all
		
		Map<String, Integer> map = new HashMap<>();
		for(String w: Arrays.asList(s.split(""))) {
			int f = Collections.frequency(Arrays.asList(s.split("")), w);
			map.put(w,f);
		}
		if(map.size()==1) return 0;		
		
		for(String w: map.keySet()) {
			while (Collections.frequency(map.values(), map.get(w)) > 1 ){
				map.put(w, map.get(w)-1);
				if(map.get(w)==0) break;
			}
		}		
		return s.length() - map.values().stream().filter(t->t>0).reduce(0, (x,y)->x+y) ;
	}
}
