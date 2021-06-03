package stringManipulation;

/*
 	Given a string s, check if it can be constructed by taking a substring of it 
 	and appending multiple copies of the substring together.
 	
 */

public class RepeatedSubstringPattern {
	
	public static void main(String[] args) {
		
		System.out.println(repSubPattern("abaaba"));
//		String a = "solidsolid";
//		System.out.println(a.substring(0, 5).hashCode());
//		System.out.println(a.substring(5).hashCode());
		
	}
		private static boolean repSubPattern(String s) {
		
		int n = s.length();
		if ( n < 2) return false;
		if ( n == 2) return s.charAt(0) == s.charAt(1);
		
		for ( int t = n/2 ; t > 0 ; t--) {
			if ( n % t == 0) {
				String temp = s.substring(0, t); 
				int start = t;
				String current;
				boolean control = true;
				
				while(start != n) {
					current = s.substring(start, start + t);
					if (!current.equals(temp)) {
						control = false;
						break;
					}
					start = start + t;
				}
				if(control) return true;
			}
		}
		return false;
	}
}


//int hash = temp.hashCode();
//int currHash = hash;

//while(start != n && currHash == hash) {
//temp = s.substring(start, start + t); // 2,4
//currHash = temp.hashCode(); // 
//start = start + t; // 2+2 
//}
//if (currHash == hash) return true;