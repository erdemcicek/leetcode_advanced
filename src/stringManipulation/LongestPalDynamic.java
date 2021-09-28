package stringManipulation;

public class LongestPalDynamic {
	
	public static void main(String[] args) {
		System.out.println(longestPal("madame"));
		
	}
	
	private static String longestPal(String s) {
												
		if ( s == null || s.length() < 1) return "";
		
		int start = 0, end = 0;
		
		for ( int i = 0 ; i < s.length() ; i++) {
			int len1 = expand(s, i, i); 
			int len2 = expand(s, i, i+1); 
			int len = (len1>len2)?(len1):(len2);
			if ( len > end - start) { 
				start = i - ((len-1)/2); 
				end = i + (len/2);		  
			}
		}
		
		return s.substring(start, end + 1); // 0 3  len 3 end-start
	}
	
	private static int expand(String s, int left, int right) {
		
		if ( s == null || left > right) return 0;
		
		while( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--; 
			right++; 
		}
		
		return right - left - 1;
	}
}
