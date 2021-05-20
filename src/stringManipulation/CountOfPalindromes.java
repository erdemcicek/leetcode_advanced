package stringManipulation;

// Write a program that returns the number of unique palindrome that a given String contains.
// Example 1 : "abcdeffedxyx" should return 2 ==> "deffed" , "xyx"
// Example 2 : "abbcddeff"    should return 3 ==> "bb", "dd", "ff"

public class CountOfPalindromes {
	
	public static void main(String[] args) {
		
		System.out.println(countOfPal("abbcddeff"));
		System.out.println(countOfPal("abcdeffedxyx"));
	}
	public static int countOfPal(String s) {
		
		int count = 0;
		
		StringBuilder sb = new StringBuilder(s);
		
		while( sb.length() != 0) {
			
			int palStart = maxLengthOfPal(sb.toString())[0];
			int palEnd = maxLengthOfPal(sb.toString())[1];
			if (palEnd - palStart > 1) count++;
			sb.delete(palStart, palEnd);
		}
		return count;
	}
	
	
	public static int[] maxLengthOfPal(String s) { 
		
		int start = 0 , end = 0;
		
		for ( int i = 0 ; i < s.length() ; i++) {
			int lenSingle = expandFromMiddle(s, i, i); 
			int lenDouble = expandFromMiddle(s, i, i+1);
			int len = Math.max(lenSingle, lenDouble);
			if ( len > end - start) {
				start = i - ( (len-1)/2);
				end = i + len/2;
			}
		}
		return new int[] {start, end+1};

	}
	
	public static int expandFromMiddle(String s, int left, int right) { 
		
		if ( s == null || s.length() == 0) return 0;
		
		while ( left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}

}
