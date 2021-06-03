package stringManipulation;

/*
 	Given a string s, check if it can be constructed by taking a substring of it 
 	and appending multiple copies of the substring together.
 	
 */

public class RepeatedSubstringPattern {
	
	public static void main(String[] args) {
		
		System.out.println(repSubPattern("abaaba"));
		
	}
		private static boolean repSubPattern(String s) {
		
		int n = s.length();
		if ( n < 2) return false;
		if ( n == 2) return s.charAt(0) == s.charAt(1);
		
		for ( int t = n/2 ; t > 0 ; t--) {
			if ( n % t == 0) {
				String temp = s.substring(0, t); 
				int start = t;
				int hash = temp.hashCode();
				int currHash = hash;
				
				
				while(start != n  && currHash == hash) {
					temp = s.substring(start, start + t);
					currHash = temp.hashCode();
					start = start + t;
				}
				if(currHash == hash ) return true;
			}
		}
		return false;
	}
}
