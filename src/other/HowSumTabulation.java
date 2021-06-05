package other;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSumTabulation {
	
	public static void main(String[] args) {
		
		List<Integer> list = List.of(2,3);
		System.out.println(howSumTab(7, list));
		
	}
	
	public static List<Integer> howSumTab(int targetSum, List<Integer> numbers){
		
		List[] table = new List[targetSum+1];
		table[0] = List.of();
		
		for ( int i = 0 ; i <= targetSum ; i++) {
			if ( table[i] != null) {
				for ( int w : numbers) {
					if ( i+w <= targetSum) {
						table[i].add(w);
						table[i+w] = table[i];
					}
				}
			}
		}
		return null;
	}
}