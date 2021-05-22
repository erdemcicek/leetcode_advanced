package stringManipulation;

import java.util.List;

public class CanConstructOurselves {
	
	public static void main(String[] args) {
		
		List<String> list = List.of("d", "e", "den","dn", "niz");
		
		System.out.println(canConstruct("deniz", list)); 

	}
	public static boolean canConstruct(String target, List<String> list) { 
		
		// canConstruct("", list) ==> true
		if ( target.equals("")) return true;
		
		for ( int i = 0 ; i < list.size() ; i++) { 
			if ( target.indexOf(list.get(i)) == 0) {
				if (canConstruct(target.substring(list.get(i).length()) , list)) {
					return true;
				}
			}
		}	
		return false;
	}
}
