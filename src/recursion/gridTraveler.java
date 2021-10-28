package recursion;

import java.util.HashMap;
import java.util.Map;

public class gridTraveler {
	
	public static void main(String[] args) {
		Map<String, Long> hm1 = new HashMap<>();
		System.out.println(gridTravel(18, 18, hm1));	
	}
	
	private static long gridTravel(int m, int n, Map<String, Long> hm) {

		String s = m + "," + n; // this will create unique key for each path
		if ( hm.containsKey(s)) return hm.get(s); 
		if ( m == 1 && n == 1) return 1;
		if ( m == 0 || n == 0) return 0;
		hm.putIfAbsent(s, gridTravel(m-1, n, hm) + gridTravel(m, n-1, hm));
		return hm.get(s);
	}
}
